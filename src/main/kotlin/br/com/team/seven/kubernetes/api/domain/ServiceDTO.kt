package br.com.team.seven.kubernetes.api.domain

data class ServiceDTO(var name: String?,
                      var endPoints: MutableList<EndPoint?>) {
    override fun toString(): String {
        return "Service(name='$name', endPoints=$endPoints)"
    }
}