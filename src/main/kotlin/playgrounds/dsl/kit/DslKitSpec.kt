package playgrounds.dsl.kit

import org.spongepowered.api.text.Text
import playgrounds.api.kit.KitSpec

operator fun KitSpec.Companion.invoke(
    id: String,
    name: String = id,
    description: Text? = null,
    permission: String? = null,
    init: DslKitSpec.() -> Unit
): KitSpec = DslKitSpec(id, name, description, permission).apply(init)

data class DslKitSpec(
    override val id: String,
    override val name: String,
    override val description: Text?,
    override val permission: String?
) : KitTree(), KitSpec