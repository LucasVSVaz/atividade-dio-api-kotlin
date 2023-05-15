package dev.camila.request.credit.system.service.mapper.credit

import dev.camila.request.credit.system.dto.response.credit.CreditViewList
import dev.camila.request.credit.system.entity.Credit
import org.springframework.cglib.core.internal.Function

object CreditViewListMapper : Function<Credit, CreditViewList?> {
    override fun apply(credit: Credit?): CreditViewList? =
        credit?.let {
            CreditViewList(
                creditCode = it.creditCode,
                creditValue = it.creditValue,
                numberOfInstallment = it.numberOfInstallment
            )
        }
}