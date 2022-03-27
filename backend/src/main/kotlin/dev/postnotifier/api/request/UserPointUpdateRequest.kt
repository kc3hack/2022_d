package dev.postnotifier.api.request

import io.micronaut.core.annotation.Introspected

@Introspected
data class UserPointUpdateRequest(val point: Int)
