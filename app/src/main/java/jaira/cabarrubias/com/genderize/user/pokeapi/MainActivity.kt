package jaira.cabarrubias.com.genderize.user.pokeapi


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL


class MainActivity : AppCompatActivity() {
    private var pokeList = ArrayList<PokemonInterface>()
    val url = "https://pokeapi.co/api/v2/pokemon"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_pokemon.layoutManager = LinearLayoutManager(this)
        for(i in 1..20)
        {
            doAsync{
                val resultJSON = URL(url + i).readText()
                uiThread {
                    val jsonObj = JSONObject(resultJSON)

                    val id = jsonObj.getInt("id")
                    val pokename = jsonObj.getString("name")
                    val sprites = jsonObj.getString("sprites")
                    val jsonObj2 = JSONObject(sprites)
                    val front_default = jsonObj2.getString("front_default")

                    pokeList.add(PokemonInterface(id,pokename,Sprites(front_default)))

                    recyclerView_pokemon.adapter = MainAdapter(pokeList)
                    if(pokeList.size!=0) {
                        textPokemon.text = "YOU HAVE " + pokeList.size.toString() + "POKEMONS"
                    }
                    if (pokeList.size==20)
                    {
                        progressBar.visibility = GONE
                    }

                    }

                }
            }
        }
    }

