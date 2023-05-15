package dev.camila.request.credit.system.controller

import dev.camila.request.credit.system.dto.request.customer.CustomerSaveDTO
import dev.camila.request.credit.system.dto.request.customer.CustomerUpdateDTO
import dev.camila.request.credit.system.dto.response.customer.CustomerView
import dev.camila.request.credit.system.entity.Customer
import dev.camila.request.credit.system.service.mapper.customer.CustomerSaveMapper
import dev.camila.request.credit.system.service.mapper.customer.CustomerViewMapper
import dev.camila.request.credit.system.service.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@Valid @RequestBody customerDTO: CustomerSaveDTO): ResponseEntity<String> {
        val savedCustomer = CustomerSaveMapper.apply(customerDTO);
        if (savedCustomer != null) {
            this.customerService.save(savedCustomer);
        };
        return ResponseEntity.status(HttpStatus.CREATED).body(
            "Customer ${savedCustomer?.email} saved!"
        )
    }

    @GetMapping
    fun findAllCustomer(): ResponseEntity<List<CustomerView?>> {
        return ResponseEntity.status(HttpStatus.OK).body(
            customerService.findAll().map { customer: Customer -> CustomerViewMapper.apply(customer) }.toList()
        )
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView?> {
        return ResponseEntity.status(HttpStatus.OK).body(
            CustomerViewMapper.apply(this.customerService.findById(id))
        )
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long) {
        this.customerService.delete(id);
    }

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @Valid @RequestBody customerUpdateDTO: CustomerUpdateDTO
    ): ResponseEntity<CustomerView?> {

        val customer: Customer = customerService.findById(id);
        val customerToUpdate = customerUpdateDTO.toEntity(customer);

        val customerUpdated = customerService.save(customerToUpdate);

        return ResponseEntity.status(HttpStatus.OK).body(
            CustomerViewMapper.apply(customerUpdated)
        )
    }
}
