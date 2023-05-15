package dev.camila.request.credit.system.service

import dev.camila.request.credit.system.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findAll(): List<Customer>

    fun findById(id: Long): Customer

    fun delete(id: Long)
}