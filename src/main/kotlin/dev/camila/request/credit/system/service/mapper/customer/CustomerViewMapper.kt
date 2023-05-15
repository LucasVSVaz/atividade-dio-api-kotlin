package dev.camila.request.credit.system.service.mapper.customer

import dev.camila.request.credit.system.dto.response.customer.CustomerView
import dev.camila.request.credit.system.entity.Customer
import org.springframework.cglib.core.internal.Function
import org.springframework.stereotype.Service

@Service
object CustomerViewMapper : Function<Customer, CustomerView> {
    override fun apply(customer: Customer?): CustomerView? = customer?.let {
        CustomerView(
            firstName = it.firstName,
            lastName = it.lastName,
            cpf = it.cpf,
            income = it.income,
            email = it.email,
            zipCode = it.address.zipCode,
            street = it.address.street
        )
    }
}