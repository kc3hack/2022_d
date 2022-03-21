package dev.postnotifier

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus

@Controller("/nagamochi")
class NagamochiController {

    @Get(uri = "/", produces = ["text/plain"])
    fun index(): String {
        return "Example Response"
    }
}
