package dev.postnotifier.api.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected

@Introspected
data class UserPasswordUpdateRequest(
    val password: String,

    @JsonProperty("new_password")
    val newPassword: String
)
