package dev.postnotifier.infrastructure.repositoryImpl

import dev.postnotifier.domain.user.*
import dev.postnotifier.infrastructure.entity.UserEntity
import dev.postnotifier.infrastructure.query.UserQuery
import jakarta.inject.Singleton
import java.util.*

@Singleton
class UserRepositoryImpl(private val userQuery: UserQuery) : UserRepository {
    override fun insert(userModel: UserModel) {
        userQuery.save(convertUserModelToEntity(userModel))
    }

    override fun findByEmail(email: String): UserModel? {
        val userEntity = userQuery.findByEmail(email)
        if (userEntity != null) {
            return convertUserEntityToModel(userEntity)
        }
        return null
    }

    override fun findById(id: UUID): UserModel? {
        val userEntity = userQuery.findById(id).orElse(null)
        if (userEntity != null) {
            return convertUserEntityToModel(userEntity)
        }
        return null
    }

    override fun update(userId: UUID, email: UserEmail, name: UserName) {
        userQuery.update(userId, email.getValue(), name.value)
    }

    override fun updatePassword(userId: UUID, password: UserPassword) {
        userQuery.updatePasswordById(userId, password.getValue())
    }

    private fun convertUserModelToEntity(userModel: UserModel): UserEntity {
        return UserEntity(
            email = userModel.email.getValue(),
            password = userModel.password.getValue(),
            name = userModel.name.value,
            role = userModel.role
        )
    }

    private fun convertUserEntityToModel(userEntity: UserEntity): UserModel {
        return UserModel(
            userEntity.id,
            UserEmail(userEntity.email),
            UserPassword(userEntity.password),
            UserName(userEntity.name),
            userEntity.role,
            userEntity.createAt,
            userEntity.updateAt
        )
    }
}
