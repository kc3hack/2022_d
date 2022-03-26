package dev.postnotifier.api.controller

import dev.postnotifier.api.request.RegisterRequest
import dev.postnotifier.api.request.UserInfoUpdateRequest
import dev.postnotifier.api.request.UserPasswordUpdateRequest
import dev.postnotifier.api.response.UserInfoResponse
import dev.postnotifier.service.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import java.security.Principal
import java.util.*

@Controller("/api/user")
class UserRestController(private val userService: UserService) {
    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post("/register")
    fun register(@Body registerRequest: RegisterRequest): Publisher<HttpResponse<String>> {
        return Flux.create({ emitter ->
            userService.register(registerRequest)
            emitter.next(HttpResponse.ok("success"))
            emitter.complete()
        }, FluxSink.OverflowStrategy.ERROR)
    }

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Get("/info")
    fun getInfo(principal: Principal): Publisher<HttpResponse<UserInfoResponse>> {
        return Flux.create({ emitter ->
            val userInfoResponse = userService.getInfo(UUID.fromString(principal.name))
            emitter.next(HttpResponse.ok(userInfoResponse))
            emitter.complete()
        }, FluxSink.OverflowStrategy.ERROR)
    }

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Put("/update")
    fun updateInfo(
        principal: Principal,
        @Body userInfoUpdateRequest: UserInfoUpdateRequest
    ): Publisher<HttpResponse<String>> {
        return Flux.create({ emitter ->
            userService.updateInfo(UUID.fromString(principal.name), userInfoUpdateRequest)
            emitter.next(
                HttpResponse.ok()
            )
            emitter.complete()
        }, FluxSink.OverflowStrategy.ERROR)
    }

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Put("/update/auth")
    fun updatePassword(
        principal: Principal,
        @Body userPasswordUpdateRequest: UserPasswordUpdateRequest
    ): Publisher<HttpResponse<String>> {
        return Flux.create({ emitter ->
            userService.updatePassword(UUID.fromString(principal.name), userPasswordUpdateRequest)
            emitter.next(HttpResponse.ok())
            emitter.complete()
        }, FluxSink.OverflowStrategy.ERROR)
    }

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Get("/hello")
    fun hello(principal: Principal): Publisher<HttpResponse<String>> {
        return Flux.create({ emitter ->
            emitter.next(HttpResponse.ok("Hello, ${principal.name}"))
            emitter.complete()
        }, FluxSink.OverflowStrategy.ERROR)
    }
}
