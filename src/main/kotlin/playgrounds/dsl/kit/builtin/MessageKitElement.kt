package playgrounds.dsl.kit.builtin

import org.spongepowered.api.text.Text
import playgrounds.api.Contestant
import playgrounds.api.kit.KitContext
import playgrounds.api.kit.KitElement
import playgrounds.dsl.kit.DslKitSpec
import playgrounds.dsl.kit.KitDslMarker
import java.util.*

fun DslKitSpec.messages(init: MessageKitElement.() -> Unit) = initElement(MessageKitElement(), init)

@KitDslMarker
class MessageKitElement : KitElement {

    private val applyMessages = LinkedList<Text>()
    private val unapplyMessages = LinkedList<Text>()

    operator fun Text.unaryPlus() {
        applyMessages += this
    }

    operator fun Text.unaryMinus() {
        unapplyMessages += this
    }

    override suspend fun apply(src: Contestant, ctx: KitContext) {
        src.sendMessages(applyMessages)
    }

    override suspend fun unapply(src: Contestant, ctx: KitContext) {
        src.sendMessages(unapplyMessages)
    }
}