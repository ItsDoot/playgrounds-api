package playgrounds.api.kit

import org.spongepowered.api.text.Text

interface KitSpec : KitElement {

    companion object

    /**
     * The internal identifier used to represent this kit.
     */
    val id: String

    /**
     * The name displayed to [contestants][playgrounds.api.Contestant].
     */
    val name: String

    /**
     * A description of this kit, such as recommended play-styles or its abilities.
     */
    val description: Text?

    /**
     * The permission required to be able to select this kit.
     */
    val permission: String?
}