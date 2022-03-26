package dev.postnotifier.exception

import io.micronaut.http.HttpStatus

class NotFoundException(override val errorCode: ErrorCode): BaseException(HttpStatus.NOT_FOUND, errorCode)
