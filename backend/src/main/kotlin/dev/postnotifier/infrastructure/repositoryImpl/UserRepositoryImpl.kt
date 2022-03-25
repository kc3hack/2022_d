package dev.postnotifier.infrastructure.repositoryImpl

import dev.postnotifier.domain.user.UserEmail
import dev.postnotifier.domain.user.UserModel
import dev.postnotifier.domain.user.UserPassword
import dev.postnotifier.domain.user.UserRepository
import dev.postnotifier.infrastructure.entity.UserEntity
import dev.postnotifier.infrastructure.query.UserQuery
import jakarta.inject.Singleton

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

    private fun convertUserModelToEntity(userModel: UserModel): UserEntity {
        return UserEntity(
            email = userModel.email.getValue(),
            password = userModel.password.getValue(),
            name = userModel.name,
            role = userModel.role
        )
    }

    private fun convertUserEntityToModel(userEntity: UserEntity): UserModel {
        return UserModel(
            userEntity.id,
            UserEmail(userEntity.email),
            UserPassword(userEntity.password),
            userEntity.name,
            userEntity.role,
            userEntity.createAt,
            userEntity.updateAt
        )
    }
}
