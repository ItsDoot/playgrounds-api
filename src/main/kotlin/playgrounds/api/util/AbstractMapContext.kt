package playgrounds.api.util

abstract class AbstractMapContext(map: Map<String, Any?> = mapOf()) : IContext {

    private val map = map.toMutableMap()

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> get(key: String): T? = map[key] as T?

    override fun <T : Any> set(key: String, value: T?) {
        map[key] = value
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> require(key: String): T = map[key] as T
}