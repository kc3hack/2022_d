package dev.postnotifier.service

import dev.postnotifier.api.data.UserInfoData
import dev.postnotifier.api.request.RegisterRequest
import dev.postnotifier.api.request.UserInfoUpdateRequest
import dev.postnotifier.api.request.UserPasswordUpdateRequest
import dev.postnotifier.api.request.UserPointUpdateRequest
import dev.postnotifier.api.response.UserInfoResponse
import dev.postnotifier.domain.user.*
import dev.postnotifier.exception.BadRequestException
import dev.postnotifier.exception.ErrorCode
import dev.postnotifier.exception.NotFoundException
import dev.postnotifier.util.PasswordEncoder
import jakarta.inject.Singleton
import java.util.*

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

        val userName = UserName(registerRequest.name)
        if (!userName.checkValue()) {
            throw BadRequestException(ErrorCode.INVALID_NAME)
        }

        val userModel = UserModel(
            email = userEmail,
            password = userPassword,
            name = userName,
            role = UserRole.ROLE_USER.toString()
        )
        userRepository.insert(userModel)
    }

    fun getInfo(userId: UUID): UserInfoResponse {
        val userModel = userRepository.findById(userId) ?: throw NotFoundException(ErrorCode.NOT_FOUND_DATA)
        return UserInfoResponse(
            UserInfoData(
                userModel.name.value,
                userModel.email.getValue(),
                userModel.point.value,
                userModel.createAt!!.toLocalDateTime().toString(),
                userModel.updateAt!!.toLocalDateTime().toString()
            )
        )
    }

    fun updateInfo(userId: UUID, userInfoUpdateRequest: UserInfoUpdateRequest) {
        val currentUserModel = userRepository.findById(userId) ?: throw NotFoundException(ErrorCode.NOT_FOUND_DATA)
        if (!passwordEncoder.matches(userInfoUpdateRequest.password, currentUserModel.password.getValue())) {
            throw BadRequestException(ErrorCode.MISMATCH_CURRENT_PASSWORD)
        }

        val userEmail = UserEmail(userInfoUpdateRequest.email)
        if (!userEmail.checkValue()) {
            throw BadRequestException(ErrorCode.INVALID_EMAIL)
        }

        val userName = UserName(userInfoUpdateRequest.name)
        if (!userName.checkValue()) {
            throw BadRequestException(ErrorCode.INVALID_NAME)
        }

        userRepository.update(userId, userEmail, userName)
    }

    fun updatePassword(userId: UUID, userPasswordUpdateRequest: UserPasswordUpdateRequest) {
        val userModel = userRepository.findById(userId) ?: throw NotFoundException(ErrorCode.NOT_FOUND_DATA)
        if (!passwordEncoder.matches(userPasswordUpdateRequest.password, userModel.password.getValue())) {
            throw BadRequestException(ErrorCode.MISMATCH_CURRENT_PASSWORD)
        }

        val userPassword = UserPassword(userPasswordUpdateRequest.newPassword)
        if (!userPassword.checkValue()) {
            throw BadRequestException(ErrorCode.INVALID_PASSWORD)
        }

        userPassword.setValue(passwordEncoder.encode(userPassword.getValue()))

        userRepository.updatePassword(userId, userPassword)
    }

    fun updatePoint(userId: UUID, userPointUpdateRequest: UserPointUpdateRequest) {
        val userPoint = UserPoint(userPointUpdateRequest.point)
        if (!userPoint.checkValue()) {
            throw BadRequestException(ErrorCode.INVALID_POINT)
        }
        userRepository.updatePoint(userId, userPoint)
    }
}
