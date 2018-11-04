package playgrounds.dsl.kit.builtin

import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.Slot
import playgrounds.api.Contestant
import playgrounds.api.kit.KitContext
import playgrounds.api.kit.KitElement
import playgrounds.api.util.hotbar
import playgrounds.dsl.kit.DslKitSpec
import playgrounds.dsl.kit.KitDslMarker
import java.util.*

fun DslKitSpec.hotbar(init: HotbarKitElement.() -> Unit) = initElement(HotbarKitElement(), init)

@KitDslMarker
class HotbarKitElement : KitElement {

    private val items = LinkedList<ItemStack>()

    operator fun ItemStack.unaryPlus() {
        items += this
    }

    fun item(stack: ItemStack) {
        items += stack
    }

    override suspend fun apply(src: Contestant, ctx: KitContext) {
        for ((item, slot) in items.zip(src.hotbar().slots<Slot>())) {
            slot.set(item)
        }
    }

    override suspend fun unapply(src: Contestant, ctx: KitContext) {
        src.hotbar().clear()
    }
}