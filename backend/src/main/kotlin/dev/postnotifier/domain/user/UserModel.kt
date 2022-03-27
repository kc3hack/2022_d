package dev.postnotifier.domain.user

import java.time.OffsetDateTime
import java.util.*

class UserModel(
    val id: UUID? = null,

    val email: UserEmail,

    val password: UserPassword,

    val name: UserName,

    val point: UserPoint = UserPoint(0),

    val role: String,

    val createAt: OffsetDateTime? = null,

    val updateAt: OffsetDateTime? = null
)
