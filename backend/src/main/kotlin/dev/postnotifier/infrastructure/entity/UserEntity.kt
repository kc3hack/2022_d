package dev.postnotifier.infrastructure.entity

import io.micronaut.data.annotation.*
import java.time.OffsetDateTime
import java.util.*
import javax.validation.constraints.NotNull

@MappedEntity(value = "user")
data class UserEntity(

    @field: Id
    @GeneratedValue(GeneratedValue.Type.UUID)
    val id: UUID? = null,

    @NotNull
    val email: String,

    @NotNull
    val password: String,

    @NotNull
    val name: String,

    @NotNull
    val point: Int,

    @NotNull
    val role: String,

    @DateCreated
    val createAt: OffsetDateTime? = null,

    @DateUpdated
    val updateAt: OffsetDateTime? = null
)
