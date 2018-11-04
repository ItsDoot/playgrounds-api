package playgrounds.dsl.kit.builtin

import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.effect.potion.PotionEffect
import org.spongepowered.api.effect.potion.PotionEffectType
import playgrounds.api.Contestant
import playgrounds.api.kit.KitContext
import playgrounds.api.kit.KitElement
import playgrounds.dsl.kit.DslKitSpec
import playgrounds.dsl.kit.KitDslMarker
import java.util.*

fun DslKitSpec.potions(init: PotionKitElement.() -> Unit) = initElement(PotionKitElement(), init)

@KitDslMarker
class PotionKitElement : KitElement {

    private val effects = LinkedList<PotionEffect>()

    operator fun PotionEffect.unaryPlus() {
        effects += this
    }

    operator fun PotionEffectType.unaryPlus() {
        PotionEffect.of(this, 0, Int.MAX_VALUE)
    }

    override suspend fun apply(src: Contestant, ctx: KitContext) {
        src.transform(Keys.POTION_EFFECTS) { current ->
            current + effects
        }
    }

    override suspend fun unapply(src: Contestant, ctx: KitContext) {
        src.transform(Keys.POTION_EFFECTS) { current ->
            val types = effects.map { it.type }.toSet()
            current.filter { it.type !in types }
        }
    }
}