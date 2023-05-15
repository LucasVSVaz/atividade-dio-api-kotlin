package dev.camila.request.credit.system.dto.request.credit

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDate

data class CreditSaveDTO(
    @field:NotNull(message = "Credit value is required")
    val creditValue: BigDecimal,
    @field:Future(message = "Must be informed at a future date")
    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    val dayFirstInstallment: LocalDate,
    @field:Min(value = 1, message = "Minimum number of installments: 1")
    @field:Max(value = 48, message = "Maximum number of installments: 48")
    val numberOfInstallment: Int,
    @field:Min(value = 1, message = "A Customer ID must be informed")
    @field:NotNull(message = "A Customer ID must be informed")
    var customerId: Long
)
