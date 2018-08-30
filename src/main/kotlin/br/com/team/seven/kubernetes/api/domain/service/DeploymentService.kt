package br.com.team.seven.kubernetes.api.domain.service

import br.com.team.seven.kubernetes.api.infraestructure.HealmRunner
import org.springframework.stereotype.Service
import java.io.File
import java.util.concurrent.Executors


@Service
class DeploymentService {

    fun runCommand(): String {

        val response = Runtime.getRuntime().exec("helm install helm-minecraft")

        return response.inputStream.bufferedReader().readLine()

    }

    /*companion object {
        @JvmStatic
        fun main(args: Array<String>){

            val response = Runtime.getRuntime().exec("helm list")

            println(response.inputStream.bufferedReader().readLine())


        }
    }*/


}