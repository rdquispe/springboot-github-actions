package com.rodrigo.quispe.springbootgithubactions

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class HomeController {

    @GetMapping(path = ["/"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun home(): HashMap<String, Any> =
        hashMapOf("message" to "Hello World!")

    @PostMapping(path = ["/user"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun user(@RequestBody userRequest: UserRequest): ResponseEntity<HashMap<String, Any>> {
        return ResponseEntity.ok(hashMapOf("username" to userRequest.username))
    }
}