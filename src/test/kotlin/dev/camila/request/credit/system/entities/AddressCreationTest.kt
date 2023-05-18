package dev.camila.request.credit.system.entities

import dev.camila.request.credit.system.factory.EntityFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddressCreationTest {

    @Test
    fun `Creating an Address entity`() {
        val address = EntityFactory.getAddressFactory();

        assertEquals("38400000", address.zipCode)
        assertEquals("Street Test", address.street)
    }
}