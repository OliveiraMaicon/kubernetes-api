package br.com.team.seven.kubernetes.api.domain.dto

data class ResponseServer(var status : String,
                          var online : Boolean,
                          var motd: String,
                          var error: String,
                          var players: Player,
                          var server: Server,
                          var last_online: String,
                          var last_updated: String,
                          var duration: Long) {
    override fun toString(): String {
        return "ResponseServer(status='$status', online=$online, motd='$motd', error='$error', player=$players, server=$server, last_online='$last_online', last_updated='$last_updated', duration=$duration)"
    }
}