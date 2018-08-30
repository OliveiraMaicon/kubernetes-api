package br.com.team.seven.kubernetes.api.domain.service

import br.com.team.seven.kubernetes.api.domain.dto.EndPoint
import br.com.team.seven.kubernetes.api.domain.dto.ResponseServer
import br.com.team.seven.kubernetes.api.domain.dto.ServiceDTO
import io.kubernetes.client.apis.CoreV1Api
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class KubernetesService(private val api: CoreV1Api,
                        private val restTemplate: RestTemplate) {


    fun listServiceDetails(): List<ServiceDTO> {

        val listService = api.listNamespacedService("default", null, null, null, null, null, null, null, null, null)

        val services = mutableListOf<ServiceDTO>()

        for (item in listService.items) {
            val service = ServiceDTO("", mutableListOf())
            var ip = ""
            if (item.status.loadBalancer.ingress != null) {
                ip = item.status.loadBalancer.ingress[0].ip
            }

            if (!ip.isNullOrEmpty()) {
                if (item.spec.selector != null) {
                    service.name = item.spec.selector["app"]
                    item.spec.ports.forEach {
                        val url = "https://mcapi.us/server/status?ip=$ip&port=${it.port}"
                        val response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ResponseServer::class.java)
                        val server = response.body!!
                        service.endPoints.add(EndPoint(it.name, ip, it.port, server.players.max, server.players.now))
                    }
                }
                if (!service.name.isNullOrEmpty()) {
                    services.add(service)
                }
            }

        }
        return services
    }

    fun delete() {
       // api.deleteNamespaceAsync()

    }
}