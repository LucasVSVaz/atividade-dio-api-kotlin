package dev.camila.request.credit.system.factory

import dev.camila.request.credit.system.entity.Address
import dev.camila.request.credit.system.entity.Credit
import dev.camila.request.credit.system.entity.Customer
import dev.camila.request.credit.system.enumeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

object EntityFactory {

    fun getCustomerFactory(): Customer {
        return Customer().apply {
            id = 1;
            firstName = "Test";
            lastName = "Test";
            cpf = "24088461614";
            email = "test@gmail.com";
            password = "test123";
            address = getAddressFactory();
            credit = listOf(getCreditFactory());
            income = BigDecimal(3000.0)
        }
    }

    fun getAddressFactory(): Address {
        return Address().apply {
            zipCode = "38400000";
            street = "Street Test"
        }
    }

    fun getCreditFactory(): Credit {

        return Credit(
            id = 1,
            creditCode = UUID.randomUUID(),
            creditValue = BigDecimal(500.0),
            dayFirstInstallment = LocalDate.now().plusMonths(1),
            numberOfInstallment = 2,
            status = Status.IN_PROGRESS
        )
    }
}