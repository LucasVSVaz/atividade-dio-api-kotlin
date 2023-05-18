package dev.camila.request.credit.system.DTO.response

import dev.camila.request.credit.system.enumeration.Status
import dev.camila.request.credit.system.factory.DTOResponseFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CreditViewCreationTest {

    @Test
    fun `Creating a CreditView return`() {
        val creditView = DTOResponseFactory.getCreditView();

        assertNotNull(creditView.creditCode);
        assertEquals(BigDecimal(300.0), creditView.creditValue);
        assertEquals(2, creditView.numberOfInstallment);
        assertEquals(Status.IN_PROGRESS, creditView.status);
        assertEquals("test@gmail.com", creditView.emailCustomer);
        assertEquals(BigDecimal(3000.0), creditView.incomeCustomer);
    }
}