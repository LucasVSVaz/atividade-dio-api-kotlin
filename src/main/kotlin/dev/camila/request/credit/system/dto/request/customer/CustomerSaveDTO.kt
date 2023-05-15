package dev.camila.request.credit.system.dto.request.customer

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerSaveDTO(
    @field:NotEmpty(message = "First name is required")
    val firstName: String,
    @field:NotEmpty(message = "Last name is required")
    val lastName: String,
    @field:NotEmpty(message = "CPF is required")
    @field:CPF(message = "Invalid Brazilian Individual Taxpayer Registration (CPF) number")
    val cpf: String,
    @field:Min(value = 1, message = "income must be greater than 1") @field:NotNull(message = "Income is required")
    val income: BigDecimal,
    @field:NotEmpty(message = "Email is required") @field:Email(message = "Invalid email")
    val email: String,
    @field:NotEmpty(message = "Password is required")
    val password: String,
    @field:NotEmpty(message = "Zip code is required")
    val zipCode: String,
    @field:NotEmpty(message = "Street is required")
    val street: String
)
