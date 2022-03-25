package dev.postnotifier.api.controller

import dev.postnotifier.api.response.ErrorResponse
import dev.postnotifier.exception.BaseException
import dev.postnotifier.exception.ErrorCode
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Produces
@Singleton
@Requires(classes = [BaseException::class, ExceptionHandler::class])
class GlobalRestControllerAdvice : ExceptionHandler<BaseException, HttpResponse<ErrorResponse>> {
    override fun handle(request: HttpRequest<*>?, exception: BaseException?): HttpResponse<ErrorResponse> {
        return if (exception != null) {
            val httpStatus = exception.httpStatus
            val errorCode = exception.errorCode
            HttpResponse.status<ErrorResponse>(httpStatus)
                .body(ErrorResponse(errorCode.errorStatus, errorCode.message))
        } else {
            val errorCode = ErrorCode.UNKNOWN_ERROR
            HttpResponse.serverError(ErrorResponse(errorCode.errorStatus, errorCode.message))
        }
    }
}
