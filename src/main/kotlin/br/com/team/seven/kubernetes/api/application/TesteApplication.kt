package br.com.team.seven.kubernetes.api.application

import br.com.team.seven.kubernetes.api.domain.TesteService
import org.springframework.stereotype.Service

@Service
class TesteApplication(private var testeService: TesteService) {
}