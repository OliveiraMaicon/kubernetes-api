package br.com.team.seven.kubernetes.api.domain.dto

data class Player( var max: Int,
                   var now: Int) {
    override fun toString(): String {
        return "Player(max=$max, now=$now)"
    }

}