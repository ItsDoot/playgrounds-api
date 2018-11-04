package playgrounds.api.util

import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.item.inventory.entity.Hotbar
import org.spongepowered.api.item.inventory.query.QueryOperationTypes

fun Player.hotbar(): Hotbar = this.inventory.query(QueryOperationTypes.INVENTORY_TYPE.of(Hotbar::class.java))