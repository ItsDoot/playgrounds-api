package playgrounds.api

import org.spongepowered.api.entity.living.player.Player

data class SimpleContestant(val player: Player) : Contestant, Player by player