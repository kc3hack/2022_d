package dev.postnotifier.api.response

import com.fasterxml.jackson.annotation.JsonProperty
import dev.postnotifier.api.data.UserInfoData
import io.micronaut.core.annotation.Introspected

@Introspected
data class UserInfoResponse(
    @JsonProperty("user_info")
    val userInfo: UserInfoData
)
