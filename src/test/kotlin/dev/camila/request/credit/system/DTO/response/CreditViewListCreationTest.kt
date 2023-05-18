package dev.camila.request.credit.system.DTO.response

import dev.camila.request.credit.system.factory.DTOResponseFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CreditViewListCreationTest {

    @Test
    fun `Creating a CreditViewList return`() {
        val creditViewList = DTOResponseFactory.getCreditViewList();

        assertNotNull(creditViewList.creditCode);
        assertEquals(BigDecimal(300.0), creditViewList.creditValue);
        assertEquals(2, creditViewList.numberOfInstallment);
    }
}