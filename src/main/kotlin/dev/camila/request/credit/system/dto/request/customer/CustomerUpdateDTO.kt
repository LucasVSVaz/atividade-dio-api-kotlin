package dev.camila.request.credit.system.dto.request.customer

import dev.camila.request.credit.system.entity.Customer
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDTO(
    @field:NotEmpty(message = "First name is required")
    val firstName: String,
    @field:NotEmpty(message = "Last name is required")
    val lastName: String,
    @field:Min(value = 1, message = "income must be greater than 1") @field:NotNull(message = "Income is required")
    val income: BigDecimal,
    @field:NotEmpty(message = "Zip code is required")
    val zipCode: String,
    @field:NotEmpty(message = "Street is required")
    val street: String
) {

    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName;
        customer.lastName = this.lastName;
        customer.income = this.income;
        customer.address.zipCode = this.zipCode;
        customer.address.street = this.street

        return customer;
    }
}
