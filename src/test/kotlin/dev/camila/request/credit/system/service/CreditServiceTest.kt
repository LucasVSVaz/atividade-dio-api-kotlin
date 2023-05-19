package dev.camila.request.credit.system.service

import dev.camila.request.credit.system.entity.Credit
import dev.camila.request.credit.system.entity.Customer
import dev.camila.request.credit.system.exception.BusinessException
import dev.camila.request.credit.system.factory.EntityFactory
import dev.camila.request.credit.system.repository.CreditRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class CreditServiceTest {

    @MockK
    lateinit var creditRepository: CreditRepository;

    @MockK
    lateinit var customerService: CustomerService;

    @InjectMockKs
    lateinit var creditService: CreditService;

    private var fakeCredit: Credit = EntityFactory.getCredit();

    private var fakeCustomer: Customer = EntityFactory.getCustomer();

    @Test
    fun `should create credit`() {

        //given
        every { customerService.findById(1) } returns this.fakeCustomer
        every { creditRepository.save(any()) } returns this.fakeCredit;

        //when
        val actual = creditService.save(this.fakeCredit);

        //then
        assertNotNull(actual);
        assertSame(this.fakeCredit, actual);
        verify(exactly = 1) { creditRepository.save(fakeCredit) }
    }

    @Test
    fun `should find all by customer Id`() {

        //given
        val fakeCreditList = listOf(this.fakeCredit, this.fakeCredit.apply { id = 2 });
        every { creditRepository.findAllByCustomerId(fakeCustomer.id!!) } returns listOf(
            fakeCreditList[0],
            fakeCreditList[1]
        )

        //when
        val actual = creditService.findAllByCustomer(this.fakeCustomer.id!!)

        //then
        assertNotNull(actual)
        assertEquals(2, actual.size);
        verify(exactly = 1) { creditRepository.findAllByCustomerId(fakeCustomer.id!!) }
    }

    @Test
    fun `should find by credit code`() {

        //given
        val fakeCredit = this.fakeCredit;
        every { creditRepository.findByCreditCode(fakeCredit.creditCode) } returns fakeCredit

        //when
        val actual = creditService.findByCreditCode(this.fakeCustomer.id!!, fakeCredit.creditCode)

        //then
        assertNotNull(actual);
    }

    @Test
    fun `should not find credit by invalid credit code and throw BusinessException`() {

        //given
        val fakeCreditCode = UUID.randomUUID();
        every { creditRepository.findByCreditCode(fakeCreditCode) } returns null;

        //when
        //then
        val exception = assertThrows(BusinessException::class.java) {
            creditService.findByCreditCode(fakeCustomer.id!!, fakeCreditCode)
        };

        assertEquals("Credit code not found", exception.message);
        assertThrows(BusinessException::class.java) {
            creditService.findByCreditCode(fakeCustomer.id!!, fakeCreditCode)
        }
    }
}