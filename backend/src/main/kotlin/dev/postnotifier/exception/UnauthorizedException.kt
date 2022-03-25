package dev.postnotifier.exception

import io.micronaut.http.HttpStatus

class UnauthorizedException(override val errorCode: ErrorCode) : BaseException(HttpStatus.UNAUTHORIZED, errorCode)
