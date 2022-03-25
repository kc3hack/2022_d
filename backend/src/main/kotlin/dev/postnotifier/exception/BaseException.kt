package dev.postnotifier.exception

import io.micronaut.http.HttpStatus

open class BaseException(val httpStatus: HttpStatus, open val errorCode: ErrorCode) : RuntimeException()
