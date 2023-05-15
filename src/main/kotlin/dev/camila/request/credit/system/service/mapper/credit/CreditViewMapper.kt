package dev.camila.request.credit.system.service.mapper.credit

import dev.camila.request.credit.system.dto.response.credit.CreditView
import dev.camila.request.credit.system.entity.Credit
import org.springframework.cglib.core.internal.Function
import org.springframework.stereotype.Service

@Service
object CreditViewMapper : Function<Credit, CreditView> {
    override fun apply(credit: Credit?): CreditView? = credit?.let {
        CreditView(
            creditCode = it.creditCode,
            creditValue = it.creditValue,
            numberOfInstallment = it.numberOfInstallment,
            status = it.status,
            emailCustomer = it.customer?.email,
            incomeCustomer = it.customer?.income
        )
    }
}