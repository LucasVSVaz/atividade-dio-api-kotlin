package dev.camila.request.credit.system.DTO.response

import dev.camila.request.credit.system.factory.DTOResponseFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CustomerViewCreationTest {

    @Test
    fun `Creating a CustomerView return`() {
        val customerView = DTOResponseFactory.getCustomerView();

        assertEquals("Test", customerView.firstName);
        assertEquals("Júnior", customerView.lastName);
        assertEquals("43751009310", customerView.cpf);
        assertEquals(BigDecimal(10000.0), customerView.income);
        assertEquals("test@gmail.com", customerView.email);
        assertEquals("38400000", customerView.zipCode);
        assertEquals("Rua Test", customerView.street);
    }
}