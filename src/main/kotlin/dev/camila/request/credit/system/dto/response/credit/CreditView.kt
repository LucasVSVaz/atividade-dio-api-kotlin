package dev.camila.request.credit.system.dto.response.credit

import dev.camila.request.credit.system.enumeration.Status
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
    val creditCode:UUID,
    val creditValue:BigDecimal,
    val numberOfInstallment:Int,
    val status: Status,
    val emailCustomer:String?,
    val incomeCustomer:BigDecimal?
)
