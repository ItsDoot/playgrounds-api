package playgrounds.api.kit

interface KitService {

    fun register(plugin: Any, spec: KitSpec)

    operator fun get(id: String): KitSpec?

    operator fun contains(id: String): Boolean
}