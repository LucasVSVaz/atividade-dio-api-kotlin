package dev.camila.request.credit.system.factory

import dev.camila.request.credit.system.dto.request.credit.CreditSaveDTO
import dev.camila.request.credit.system.dto.request.customer.CustomerSaveDTO
import dev.camila.request.credit.system.dto.request.customer.CustomerUpdateDTO
import java.math.BigDecimal
import java.time.LocalDate

object DTORequestFactory {

    fun getCreditSaveDTO(): CreditSaveDTO {
        return CreditSaveDTO(
            creditValue = BigDecimal(100.0),
            dayFirstInstallment = LocalDate.now().plusDays(15),
            numberOfInstallment = 3,
            customerId = 1L
        )
    }

    fun getCustomerSaveDTO(): CustomerSaveDTO {
        return CustomerSaveDTO(
            firstName = "Test",
            lastName = "Júnior",
            cpf = "63687531708",
            income = BigDecimal(5000.0),
            email = "test@gmail.com",
            password = "test10",
            zipCode = "38400888",
            street = "Rua test"
        )
    }

    fun getCustomerUpdateDTO(): CustomerUpdateDTO {
        return CustomerUpdateDTO(
            firstName = EntityFactory.getCustomer().firstName,
            lastName = EntityFactory.getCustomer().lastName,
            income = EntityFactory.getCustomer().income,
            zipCode = EntityFactory.getCustomer().address.zipCode,
            street = EntityFactory.getCustomer().address.street
        )
    }
}