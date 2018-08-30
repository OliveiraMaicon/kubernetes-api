package br.com.team.seven.kubernetes.api.domain.dto

data class EndPoint(var name: String,
                    var ip: String,
                    var port: Int,
                    var maxPlayer: Int,
                    var nowPlayer: Int) {
    override fun toString(): String {
        return "EndPoint(name='$name', ip='$ip', port=$port, maxPlayer=$maxPlayer, nowPlayer=$nowPlayer)"
    }
}