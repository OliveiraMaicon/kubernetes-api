package br.com.team.seven.kubernetes.api.domain.service

import br.com.team.seven.kubernetes.api.infraestructure.HealmRunner
import org.springframework.stereotype.Service
import java.io.File
import java.util.concurrent.Executors


@Service
class DeploymentService {


    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            val response = Runtime.getRuntime().exec("ls -ll")

            println(response.inputStream.bufferedReader().readLine())

        }
    }
    fun teste() {

        /*val builder = ProcessBuilder()
        builder.command("sh", "-c", "ls")
        builder.directory(File(System.getProperty("user.home")))
        val process = builder.start()
        val healmRunner = HealmRunner(process.inputStream, ::println)*/
         Runtime.getRuntime().exec("")
        /*Executors.newSingleThreadExecutor().submit(healmRunner)
        val exitCode = process.waitFor()
        assert(exitCode == 0)
*/
    }


}