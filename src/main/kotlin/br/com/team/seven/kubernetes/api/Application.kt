package br.com.team.seven.kubernetes.api

import io.kubernetes.client.Configuration
import io.kubernetes.client.apis.AppsV1beta1Api
import io.kubernetes.client.apis.CoreV1Api
import io.kubernetes.client.util.Config
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate


@SpringBootApplication
class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<Application>(*args)

        }
    }

    @Bean
    fun restTemplate() = RestTemplate()


    @Bean
    fun appsV1beta1Api(): AppsV1beta1Api {
        Configuration.setDefaultApiClient(Config.defaultClient())
        return AppsV1beta1Api()
    }

    @Bean
    fun coreV1Api(): CoreV1Api {
        Configuration.setDefaultApiClient(Config.defaultClient())
        return CoreV1Api()
    }


}


