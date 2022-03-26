package dev.postnotifier.domain.user

import java.util.UUID

interface UserRepository {
    fun insert(userModel: UserModel)

    fun findById(id: UUID): UserModel?

    fun findByEmail(email: String): UserModel?

    fun update(userId: UUID, email: UserEmail, name: UserName)

    fun updatePassword(userId: UUID, password: UserPassword)
}
