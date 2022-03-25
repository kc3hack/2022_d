package dev.postnotifier.infrastructure.entity

import io.micronaut.data.annotation.*
import java.time.OffsetDateTime
import java.util.*
import javax.validation.constraints.NotNull

@MappedEntity(value = "user")
data class UserEntity(

    @field: Id
    @GeneratedValue(GeneratedValue.Type.UUID)
    val id: UUID?,

    @NotNull
    val email: String,

    @NotNull
    val password: String,

    @NotNull
    val name: String,

    @NotNull
    val role: String,

    @DateCreated
    val createAt: OffsetDateTime?,

    @DateUpdated
    val updateAt: OffsetDateTime?
    ) {
    constructor(email: String, password: String, name: String, role: String) : this(
        null,
        email,
        password,
        name,
        role,
        null,
        null
    )
}
