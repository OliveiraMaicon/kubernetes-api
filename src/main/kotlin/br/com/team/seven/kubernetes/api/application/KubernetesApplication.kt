package br.com.team.seven.kubernetes.api.application

import br.com.team.seven.kubernetes.api.domain.dto.ServiceDTO
import br.com.team.seven.kubernetes.api.domain.service.DeploymentService
import br.com.team.seven.kubernetes.api.domain.service.KubernetesService
import org.springframework.stereotype.Service

@Service
class KubernetesApplication(private var kubernetesService: KubernetesService,
                            private var deploymentService: DeploymentService) {


    fun getServicesDetails() : List<ServiceDTO> = kubernetesService.listServiceDetails()

    fun executeCommand() : String = deploymentService.runCommand()

    fun delete(name : String){
        kubernetesService.delete(name)
    }

}