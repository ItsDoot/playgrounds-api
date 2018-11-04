package playgrounds.dsl.kit.builtin

import org.spongepowered.api.item.ItemType
import org.spongepowered.api.item.inventory.ItemStack
import playgrounds.api.Contestant
import playgrounds.api.kit.KitContext
import playgrounds.api.kit.KitElement
import playgrounds.dsl.kit.DslKitSpec
import playgrounds.dsl.kit.KitDslMarker

fun DslKitSpec.armor(init: ArmorKitElement.() -> Unit) = initElement(ArmorKitElement(), init)

@KitDslMarker
class ArmorKitElement : KitElement {

    private var helmet: ItemStack? = null
    private var chestplate: ItemStack? = null
    private var leggings: ItemStack? = null
    private var boots: ItemStack? = null

    fun helmet(helmet: ItemStack?) {
        this.helmet = helmet
    }

    fun chestplate(chestplate: ItemStack?) {
        this.chestplate = chestplate
    }

    fun leggings(leggings: ItemStack?) {
        this.leggings = leggings
    }

    fun boots(boots: ItemStack?) {
        this.boots = boots
    }

    override suspend fun apply(src: Contestant, ctx: KitContext) {
        src.setHelmet(helmet)
        src.setChestplate(chestplate)
        src.setLeggings(leggings)
        src.setBoots(boots)
    }

    override suspend fun unapply(src: Contestant, ctx: KitContext) {
        src.setHelmet(null)
        src.setChestplate(null)
        src.setLeggings(null)
        src.setBoots(null)
    }
}

fun ArmorKitElement.helmet(helmet: ItemType?) = helmet(helmet?.let { ItemStack.of(it) })
fun ArmorKitElement.chestplate(chestplate: ItemType?) = chestplate(chestplate?.let { ItemStack.of(it) })
fun ArmorKitElement.leggings(leggings: ItemType?) = leggings(leggings?.let { ItemStack.of(it) })
fun ArmorKitElement.boots(boots: ItemType?) = boots(boots?.let { ItemStack.of(it) })