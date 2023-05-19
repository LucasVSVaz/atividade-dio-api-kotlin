package dev.camila.request.credit.system.service

import dev.camila.request.credit.system.entity.Customer
import dev.camila.request.credit.system.exception.BusinessException
import dev.camila.request.credit.system.factory.EntityFactory
import dev.camila.request.credit.system.repository.CustomerRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.util.*
import kotlin.random.Random

@ExtendWith(MockKExtension::class)
class CustomerServiceTest {

    @MockK
    lateinit var customerRepository: CustomerRepository;

    @InjectMockKs
    lateinit var customerService: CustomerService;

    private var fakeCustomer: Customer = EntityFactory.getCustomer();


    @Test
    fun `should create a customer`() {

        //given
        every { customerRepository.save(any()) } returns fakeCustomer;

        //when
        val actual = customerService.save(fakeCustomer);

        //then
        assertNotNull(actual);
        assertSame(fakeCustomer, actual);
        verify(exactly = 1) { customerRepository.save(fakeCustomer) }
    }

    @Test
    fun `should find customer by Id`() {

        //given
        val fakeId = Random.nextLong();
        fakeCustomer.id = fakeId;
        every { customerRepository.findById(fakeId) } returns Optional.of(fakeCustomer);

        //when
        val actual = customerService.findById(fakeId);

        //then
        assertNotNull(actual);
        assertEquals(fakeId, actual.id);
        assertInstanceOf(Customer::class.java, actual)
        assertSame(fakeCustomer, actual);
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    @Test
    fun `should find all customers`(){

        //given
        val customers = listOf(fakeCustomer.apply { id = Random.nextLong() },
                               fakeCustomer.apply { id = Random.nextLong() });

        every { customerRepository.findAll() } returns listOf(customers[0], customers[1]);

        //when
        val actual = customerService.findAll();

        //then
        assertNotNull(actual);
        assertEquals(2, actual.size);
        verify(exactly = 1) { customerRepository.findAll() }
    }

    @Test
    fun `should not find customer by invalid Id and throw BusinessException`() {

        //given
        val fakeId = Random.nextLong();
        every { customerRepository.findById(fakeId) } returns Optional.empty();

        //when
        //then
        val exception = assertThrows(BusinessException::class.java) {
            customerService.findById(fakeId)
        }
        assertEquals("Id $fakeId not found", exception.message);

        assertThrows(BusinessException::class.java) {
            customerService.findById(fakeId)
        }

        verify(exactly = 2) { customerRepository.findById(fakeId) }
    }

    @Test
    fun `should delete customer by Id`(){

        //given
        val fakeId = Random.nextLong();
        fakeCustomer.id = fakeId;
        every { customerRepository.findById(fakeId) } returns Optional.of(fakeCustomer);
        every { customerRepository.delete(fakeCustomer) } just runs

        //when
        customerService.delete(fakeId)

        //then
        verify(exactly = 1) { customerRepository.findById(fakeId) }
        verify(exactly = 1) { customerRepository.delete(fakeCustomer) }
    }
}