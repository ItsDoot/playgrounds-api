package playgrounds.dsl.kit

import playgrounds.api.Contestant
import playgrounds.api.kit.KitContext
import playgrounds.api.kit.KitElement
import java.util.*

@KitDslMarker
abstract class KitTree : KitElement {

    private val children = LinkedList<KitElement>()

    fun <E : KitElement> initElement(element: E, init: E.() -> Unit): E {
        element.init()
        children += element
        return element
    }

    override suspend fun apply(src: Contestant, ctx: KitContext) {
        for (child in children) {
            child.apply(src, ctx)
        }
    }

    override suspend fun unapply(src: Contestant, ctx: KitContext) {
        for (child in children) {
            child.unapply(src, ctx)
        }
    }
}