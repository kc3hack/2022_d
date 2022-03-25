package dev.postnotifier.exception

import io.micronaut.http.HttpStatus

class BadRequestException(override val errorCode: ErrorCode) : BaseException(HttpStatus.BAD_REQUEST, errorCode)
