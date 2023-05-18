package dev.camila.request.credit.system.DTO.resquest

import dev.camila.request.credit.system.factory.DTORequestFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CustomerSaveDTOCreationTest {

    @Test
    fun `Creating a CustomerSaveDTO`(){
        val customer = DTORequestFactory.getCustomerSaveDTO();

        assertEquals("Test", customer.firstName)
        assertEquals("Júnior", customer.lastName)
        assertEquals("63687531708", customer.cpf)
        assertEquals(BigDecimal(5000.0), customer.income)
        assertEquals("test@gmail.com", customer.email)
        assertEquals("test10", customer.password)
        assertEquals("38400888", customer.zipCode)
        assertEquals("Rua test", customer.street)
    }
}