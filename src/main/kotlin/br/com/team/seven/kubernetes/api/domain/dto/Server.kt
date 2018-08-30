package br.com.team.seven.kubernetes.api.domain.dto

data class Server(var name: String,
                  var protocol: Int) {
    override fun toString(): String {
        return "Server(name='$name', protocol=$protocol)"
    }
}