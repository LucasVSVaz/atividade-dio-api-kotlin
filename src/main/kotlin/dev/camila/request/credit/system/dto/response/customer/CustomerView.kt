package dev.camila.request.credit.system.dto.response.customer

import java.math.BigDecimal

data class CustomerView(
    val firstName:String,
    val lastName:String,
    val cpf:String,
    val income:BigDecimal,
    val email:String,
    val zipCode:String,
    val street:String
)
