package dev.postnotifier.api.response

import io.micronaut.core.annotation.Introspected

@Introspected
data class ErrorResponse(val errorStatus: Int, val message: String)
