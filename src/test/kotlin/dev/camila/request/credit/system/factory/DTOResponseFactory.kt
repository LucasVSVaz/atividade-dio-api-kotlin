package dev.camila.request.credit.system.factory

import dev.camila.request.credit.system.dto.response.credit.CreditView
import dev.camila.request.credit.system.dto.response.credit.CreditViewList
import dev.camila.request.credit.system.dto.response.customer.CustomerView
import dev.camila.request.credit.system.enumeration.Status
import java.math.BigDecimal
import java.util.*

object DTOResponseFactory {

    fun getCreditView(): CreditView {
        return CreditView(
            creditCode = UUID.randomUUID(),
            creditValue = BigDecimal(300.0),
            numberOfInstallment = 2,
            status = Status.IN_PROGRESS,
            emailCustomer = "test@gmail.com",
            incomeCustomer = BigDecimal(3000.0)
        )
    }

    fun getCreditViewList(): CreditViewList {
        return CreditViewList(
            creditCode = UUID.randomUUID(),
            creditValue = BigDecimal(300.0),
            numberOfInstallment = 2
        )
    }

    fun getCustomerView(): CustomerView {
        return CustomerView(
            firstName = "Test",
            lastName = "Júnior",
            cpf = "43751009310",
            income = BigDecimal(10000.0),
            email = "test@gmail.com",
            zipCode = "38400000",
            street = "Rua Test"
        )
    }
}