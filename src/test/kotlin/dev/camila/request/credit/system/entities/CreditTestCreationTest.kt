package dev.camila.request.credit.system.entities

import dev.camila.request.credit.system.enumeration.Status
import dev.camila.request.credit.system.factory.EntityFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate

class CreditTestCreationTest {

    @Test
    fun `Creating a Credit entity`() {
        val credit = EntityFactory.getCreditFactory();

        assertEquals(1, credit.id?.toInt());
        assertNotNull(credit.creditCode)
        assertEquals(BigDecimal(500.0), credit.creditValue);
        assertEquals(LocalDate.now().plusMonths(1), credit.dayFirstInstallment);
        assertEquals(2, credit.numberOfInstallment);
        assertEquals(Status.IN_PROGRESS, credit.status)
    }
}