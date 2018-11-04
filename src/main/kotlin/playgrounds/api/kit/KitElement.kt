package playgrounds.api.kit

import playgrounds.api.Contestant

interface KitElement {

    suspend fun apply(src: Contestant, ctx: KitContext)

    suspend fun unapply(src: Contestant, ctx: KitContext)
}