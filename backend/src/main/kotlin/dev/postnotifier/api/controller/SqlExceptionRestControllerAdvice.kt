package dev.postnotifier.api.controller

import dev.postnotifier.api.response.ErrorResponse
import dev.postnotifier.exception.ErrorCode
import io.micronaut.context.annotation.Requires
import io.micronaut.data.exceptions.DataAccessException
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Produces
@Singleton
@Requires(classes = [DataAccessException::class, ExceptionHandler::class])
class SqlExceptionRestControllerAdvice : ExceptionHandler<DataAccessException, HttpResponse<ErrorResponse>> {
    override fun handle(request: HttpRequest<*>?, exception: DataAccessException?): HttpResponse<ErrorResponse> {
        return if (exception != null) {
            val errorCode = ErrorCode.DATA_ACCESS_ERROR
            HttpResponse.status<ErrorResponse>(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse(errorCode.errorStatus, errorCode.message))
        } else {
            val errorCode = ErrorCode.UNKNOWN_ERROR
            HttpResponse.serverError(ErrorResponse(errorCode.errorStatus, errorCode.message))
        }
    }
}
