package dev.camila.request.credit.system.DTO.resquest

import dev.camila.request.credit.system.factory.DTORequestFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate

class CreditSaveDTOCreationTest {

    @Test
    fun `Creating a CreditSaveDTO`() {
        val creditDTO = DTORequestFactory.getCreditSaveDTO();

        assertEquals(BigDecimal(100.0), creditDTO.creditValue);
        assertEquals(LocalDate.now().plusDays(15), creditDTO.dayFirstInstallment);
        assertEquals(3, creditDTO.numberOfInstallment)
        assertEquals(1, creditDTO.customerId.toInt())
    }
}