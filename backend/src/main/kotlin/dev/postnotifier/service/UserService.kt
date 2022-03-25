package dev.postnotifier.service

import dev.postnotifier.api.request.RegisterRequest
import dev.postnotifier.domain.user.*
import dev.postnotifier.exception.BadRequestException
import dev.postnotifier.exception.ErrorCode
import dev.postnotifier.util.PasswordEncoder
import jakarta.inject.Singleton

@Singleton
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(registerRequest: RegisterRequest) {
        val userEmail = UserEmail(registerRequest.email)
        if (!userEmail.checkValue()) {
            throw BadRequestException(ErrorCode.INVALID_EMAIL)
        }

        if (userRepository.findByEmail(registerRequest.email) != null) {
            throw BadRequestException(ErrorCode.DUPLICATION_EMAIL)
        }

        val userPassword = UserPassword(registerRequest.password)
        if (!userPassword.checkValue()) {
            throw BadRequestException(ErrorCode.INVALID_PASSWORD)
        }

        val encodedPassword = passwordEncoder.encode(registerRequest.password)
        userPassword.setValue(encodedPassword)
        val userModel = UserModel(
            email = userEmail,
            password = userPassword,
            name = registerRequest.name,
            role = UserRole.ROLE_USER.toString()
        )
        userRepository.insert(userModel)
    }
}
