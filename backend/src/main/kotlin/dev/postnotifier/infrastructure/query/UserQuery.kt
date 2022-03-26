package dev.postnotifier.infrastructure.query

import dev.postnotifier.infrastructure.entity.UserEntity
import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Id
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.util.*
import javax.transaction.Transactional

@JdbcRepository(dialect = Dialect.POSTGRES)
interface UserQuery : CrudRepository<UserEntity, UUID> {
    @Executable
    @Transactional
    fun save(userEntity: UserEntity): UserEntity

    @Executable
    fun findByEmail(email: String): UserEntity?

    @Executable
    @Transactional
    fun update(@Id id: UUID, email: String, name: String)

    @Executable
    @Transactional
    fun updatePasswordById(@Id id: UUID, password: String)
}
