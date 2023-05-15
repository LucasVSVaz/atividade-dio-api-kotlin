package dev.camila.request.credit.system.exception

import java.lang.RuntimeException

data class BusinessException(val msg:String): RuntimeException(msg) {
}