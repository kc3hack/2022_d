package dev.postnotifier.api.request

import io.micronaut.core.annotation.Introspected

@Introspected
data class UserInfoUpdateRequest(val email: String, val name: String, val password: String)
