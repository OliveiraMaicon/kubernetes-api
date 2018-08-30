package br.com.team.seven.kubernetes.api.application

import br.com.team.seven.kubernetes.api.domain.ServiceDTO
import br.com.team.seven.kubernetes.api.domain.service.KubernetesService
import org.springframework.stereotype.Service

@Service
class KubernetesApplication(private var kubernetesService: KubernetesService) {


    fun getServicesDetails() : List<ServiceDTO> = kubernetesService.listServiceDetails()

}