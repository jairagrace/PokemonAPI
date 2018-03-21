package jaira.cabarrubias.com.genderize.user.pokeapi

/**
 * Created by user on 08/03/2018.
 */

data class PokemonInterface (
        val id: Int,
        val name: String,
        val sprites: Sprites
)

data class Sprites (
        val front_defualt : String
)
