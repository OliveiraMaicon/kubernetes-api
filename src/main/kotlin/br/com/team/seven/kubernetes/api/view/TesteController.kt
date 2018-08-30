package br.com.team.seven.kubernetes.api.view

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TesteController {

    @GetMapping("/teste")
    fun teste() : ResponseEntity<Any> = ResponseEntity.ok("OK")
}