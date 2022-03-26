package dev.postnotifier.api.data

import io.micronaut.core.annotation.Introspected

@Introspected
data class UserInfoData(
    val name: String,
    val email: String,
    val createAt: String,
    val updateAt: String
)
