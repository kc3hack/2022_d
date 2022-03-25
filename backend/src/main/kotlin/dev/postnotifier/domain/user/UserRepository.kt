package dev.postnotifier.domain.user

interface UserRepository {
    fun insert(userModel: UserModel)

    fun findByEmail(email: String): UserModel?
}
