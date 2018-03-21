package jaira.cabarrubias.com.genderize.user.pokeapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by user on 07/03/2018.
 */

class MainAdapter(val pokemonList: ArrayList<PokemonInterface>):RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return pokemonList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val pokeForRow = layoutInflater.inflate(R.layout.pokemon_row, parent, false)
        return CustomViewHolder(pokeForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val pokemon : PokemonInterface = pokemonList[position]
        holder?.pokemonName?.text = pokemon.name
        val pokemonImage = holder?.pokemonImage
        Picasso.with(holder?.view?.context).load(pokemon.sprites.front_defualt).into(pokemonImage)


    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val pokemonName = view.findViewById<TextView>(R.id.pokemonName)
    val pokemonImage = view.findViewById<ImageView>(R.id.pokemonImg)

}