package dev.camila.request.credit.system.exception

import java.lang.RuntimeException

data class DateException(val msg:String): RuntimeException(msg) {
}