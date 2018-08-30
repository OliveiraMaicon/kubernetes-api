package br.com.team.seven.kubernetes.api.view

import br.com.team.seven.kubernetes.api.application.KubernetesApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ServiceController(val kubernetesApplication: KubernetesApplication) {

    @GetMapping("/services")
    fun list(): ResponseEntity<Any> {
        return ResponseEntity.ok(kubernetesApplication.getServicesDetails())
    }

    @PutMapping("/deployments")
    fun deployment(): ResponseEntity<String> {
        return ResponseEntity.ok(kubernetesApplication.executeCommand())
    }
}