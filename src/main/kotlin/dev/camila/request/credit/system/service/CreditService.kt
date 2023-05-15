package dev.camila.request.credit.system.service

import dev.camila.request.credit.system.entity.Credit
import dev.camila.request.credit.system.exception.BusinessException
import dev.camila.request.credit.system.repository.CreditRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository, private val customerService: CustomerService
) : ICreditService {


    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }

        return creditRepository.save(credit);
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit =
            this.creditRepository.findByCreditCode(creditCode) ?: throw BusinessException("Credit code not found");

        return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact Adm");
    }
}