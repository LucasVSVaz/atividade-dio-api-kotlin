package dev.camila.request.credit.system.service.mapper.credit

import dev.camila.request.credit.system.dto.request.credit.CreditSaveDTO
import dev.camila.request.credit.system.entity.Credit
import dev.camila.request.credit.system.entity.Customer
import org.springframework.cglib.core.internal.Function
import org.springframework.stereotype.Service

@Service
object CreditSaveMapper : Function<CreditSaveDTO, Credit> {
    override fun apply(creditSaveDTO: CreditSaveDTO?): Credit? = creditSaveDTO?.let {
        Credit(
            creditValue = it.creditValue,
            dayFirstInstallment = it.dayFirstInstallment,
            numberOfInstallment = it.numberOfInstallment,
            customer = Customer(it.customerId)
        )
    }
}