package playgrounds.api.util

import kotlin.reflect.KProperty

interface IContext {

    operator fun <T : Any> get(key: String): T?

    operator fun <T : Any> set(key: String, value: T?)

    fun <T> require(key: String): T
}

operator fun <T> IContext.getValue(self: Any?, property: KProperty<*>): T = require(property.name)

operator fun <T> IContext.setValue(self: Any?, property: KProperty<*>, value: T) = set(property.name, value as? Any)