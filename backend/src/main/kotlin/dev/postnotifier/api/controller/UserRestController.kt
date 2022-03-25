package dev.postnotifier.api.controller

import dev.postnotifier.api.request.RegisterRequest
import dev.postnotifier.service.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import java.security.Principal

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
    @Get("/hello")
    fun hello(principal: Principal): Publisher<HttpResponse<String>> {
        return Flux.create({ emitter ->
            emitter.next(HttpResponse.ok("Hello, ${principal.name}"))
            emitter.complete()
        }, FluxSink.OverflowStrategy.ERROR)
    }
}
