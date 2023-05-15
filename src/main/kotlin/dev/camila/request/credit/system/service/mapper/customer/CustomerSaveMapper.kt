package dev.camila.request.credit.system.service.mapper.customer

import dev.camila.request.credit.system.dto.request.customer.CustomerSaveDTO
import dev.camila.request.credit.system.entity.Address
import dev.camila.request.credit.system.entity.Customer
import org.springframework.cglib.core.internal.Function
import org.springframework.stereotype.Service

@Service
object CustomerSaveMapper : Function<CustomerSaveDTO, Customer> {
    override fun apply(customerDTO: CustomerSaveDTO?): Customer? = customerDTO?.let {
        Customer(
            firstName = it.firstName,
            lastName = it.lastName,
            cpf = it.cpf,
            income = it.income,
            email = it.email,
            password = it.password,
            address = Address(
                zipCode = it.zipCode,
                street = it.street
            )
        )
    }
}