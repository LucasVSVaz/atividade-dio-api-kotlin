package dev.camila.request.credit.system.DTO.resquest

import dev.camila.request.credit.system.factory.DTORequestFactory
import dev.camila.request.credit.system.factory.EntityFactory
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.math.BigDecimal

class CustomerUpdateDTOCreationTest {

    @Test
    fun `Creating a CustomerUpdateDTO`() {
        val customer = EntityFactory.getCustomerFactory();
        val customerUpdate = DTORequestFactory.getCustomerUpdateDTO();
        val customerToEntity = customerUpdate.toEntity(customer);

        assertEquals("Test", customerToEntity.firstName);
        assertEquals("Test", customerToEntity.lastName);
        assertEquals(BigDecimal(3000.0), customerToEntity.income);
        assertEquals("38400000", customerToEntity.address.zipCode);
        assertEquals("Street Test", customerToEntity.address.street);
    }
}