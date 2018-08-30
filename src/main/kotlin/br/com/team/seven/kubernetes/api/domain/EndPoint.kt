package br.com.team.seven.kubernetes.api.domain

data class EndPoint(var name: String,
                    var ip: String,
                    var port: Int) {

    override fun toString(): String {
        return "EndPoint(name='$name', ip='$ip', port='$port')"
    }
}