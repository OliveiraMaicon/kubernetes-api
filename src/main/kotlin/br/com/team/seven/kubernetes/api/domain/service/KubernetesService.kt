package br.com.team.seven.kubernetes.api.domain.service

import br.com.team.seven.kubernetes.api.domain.EndPoint
import br.com.team.seven.kubernetes.api.domain.ServiceDTO
import io.kubernetes.client.apis.CoreV1Api
import org.springframework.stereotype.Service

@Service
class KubernetesService(var api: CoreV1Api) {


    fun listServiceDetails(): List<ServiceDTO> {

        val listService = api.listNamespacedService("default", null, null, null, null, null, null, null, null, null)

        val services = mutableListOf<ServiceDTO>()

        for (item in listService.items) {
            val service = ServiceDTO("", mutableListOf())
            var ip = ""
            if (item.status.loadBalancer.ingress != null) {
                ip = item.status.loadBalancer.ingress[0].ip
            }

            if (item.spec.selector != null) {
                service.name = item.spec.selector["app"]
                item.spec.ports.forEach {
                    service.endPoints.add(EndPoint(it.name, ip, it.port))
                }
                println(service.name)
            }

            if (!service.name.isNullOrEmpty()) {
                services.add(service)
            }
        }
        return services
    }
}