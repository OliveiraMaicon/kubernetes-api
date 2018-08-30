package br.com.team.seven.kubernetes.api.infraestructure

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.function.Consumer

class HealmRunner(var inputStream: InputStream,
                  var consumer: Consumer<String>) : Runnable {

    override fun run() = BufferedReader(InputStreamReader(inputStream)).lines()
            .forEach(consumer)
}