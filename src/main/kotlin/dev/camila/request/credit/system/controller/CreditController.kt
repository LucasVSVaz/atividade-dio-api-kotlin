package dev.camila.request.credit.system.controller

import dev.camila.request.credit.system.dto.request.credit.CreditSaveDTO
import dev.camila.request.credit.system.dto.response.credit.CreditView
import dev.camila.request.credit.system.dto.response.credit.CreditViewList
import dev.camila.request.credit.system.entity.Credit
import dev.camila.request.credit.system.service.CreditService
import dev.camila.request.credit.system.service.mapper.credit.CreditViewListMapper
import dev.camila.request.credit.system.service.mapper.credit.CreditSaveMapper
import dev.camila.request.credit.system.service.mapper.credit.CreditViewMapper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {

    @PostMapping
    fun save(@Valid @RequestBody creditSaveDTO: CreditSaveDTO): ResponseEntity<String> {
        val creditToSave = CreditSaveMapper.apply(creditSaveDTO);
        if (creditToSave != null) {
            creditService.save(creditToSave)
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(
            "Credit ${creditToSave?.creditCode} - Customer ${creditToSave?.customer?.firstName} saved!"
        )
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") id: Long): ResponseEntity<List<CreditViewList?>> {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.creditService.findAllByCustomer(id)
                .map { credit: Credit -> CreditViewListMapper.apply(credit) }.toList()
        )
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(value = "customerId") customerId: Long,
        @PathVariable creditCode: UUID
    ): ResponseEntity<CreditView?> {

        return ResponseEntity.status(HttpStatus.OK).body(
            CreditViewMapper.apply(creditService.findByCreditCode(customerId, creditCode))
        )
    }
}