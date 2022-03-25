package dev.postnotifier.infrastructure.query

import dev.postnotifier.infrastructure.entity.UserEntity
import io.micronaut.context.annotation.Executable
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.util.*

@JdbcRepository(dialect = Dialect.POSTGRES)
interface UserQuery : CrudRepository<UserEntity, UUID> {
    @Executable
    fun save(userEntity: UserEntity): UserEntity

    @Executable
    fun findByEmail(email: String): UserEntity?
}
