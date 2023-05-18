package dev.camila.request.credit.system.entities

import dev.camila.request.credit.system.factory.EntityFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CustomerTestCreationTest {

    @Test
    fun `Creating a Customer entity`() {
        val customer = EntityFactory.getCustomerFactory();
        val address = EntityFactory.getAddressFactory();

        assertEquals(1, customer.id?.toInt());
        assertEquals("Test", customer.firstName);
        assertEquals("Test", customer.lastName);
        assertEquals("24088461614", customer.cpf);
        assertEquals("test@gmail.com", customer.email);
        assertEquals("test123", customer.password);
        assertEquals(address, customer.address);
    }
}