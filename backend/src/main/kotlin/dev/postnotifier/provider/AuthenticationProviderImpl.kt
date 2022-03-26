package dev.postnotifier.provider

import dev.postnotifier.domain.user.UserRepository
import dev.postnotifier.exception.BadRequestException
import dev.postnotifier.exception.ErrorCode
import dev.postnotifier.exception.UnauthorizedException
import dev.postnotifier.util.PasswordEncoder
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import jakarta.inject.Singleton
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink

@Singleton
class AuthenticationProviderImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : AuthenticationProvider {
    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {
        return Flux.create { emitter: FluxSink<AuthenticationResponse> ->
            if (authenticationRequest != null) {
                val userModel = userRepository.findByEmail(authenticationRequest.identity as String)
                if (userModel != null) {
                    if (passwordEncoder.matches(
                            authenticationRequest.secret as String,
                            userModel.password.getValue()
                        )
                    ) {
                        emitter.next(AuthenticationResponse.success(userModel.id.toString(), listOf(userModel.role)))
                        emitter.complete()
                    } else {
                        emitter.error(UnauthorizedException(ErrorCode.MISMATCH_PASSWORD))
                    }
                } else {
                    emitter.error(UnauthorizedException(ErrorCode.NOT_FOUND_USER))
                }
            } else {
                emitter.error(BadRequestException(ErrorCode.NOT_FOUND_AUTH_PARAMETER))
            }
        }
    }
}
