package dev.postnotifier.domain.user

import java.time.OffsetDateTime
import java.util.*

class UserModel(
    val id: UUID?,

    val email: UserEmail,

    val password: UserPassword,

    val name: String,

    val role: String,

    val createAt: OffsetDateTime?,

    val updateAt: OffsetDateTime?
) {
    constructor(
        email: UserEmail,
        password: UserPassword,
        name: String,
        role: String
    ) : this(
        null, email, password, name, role, null, null
    )
}
