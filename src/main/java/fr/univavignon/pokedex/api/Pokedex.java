package fr.univavignon.pokedex.api;

import java.net.URL;
import java.util.Comparator;
import java.util.List;

import org.jsoup.Jsoup;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Pokedex implements IPokedex {

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		int defense = 0;
		int attack = 0;
		int stamina = 0;
		String name = null;
		try {
			System.out.println(index);
			URL url = new URL("http://pokeapi.co/api/v2/pokemon/" + index);

			String json = Jsoup.connect(url.toString()).ignoreContentType(true).execute().body();

			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray forms = jobject.getAsJsonArray("forms");
			JsonArray stats = jobject.getAsJsonArray("stats");

			name = forms.get(0).getAsJsonObject().get("name").getAsString();
			defense = stats.get(3).getAsJsonObject().get("base_stat").getAsInt();
			attack = stats.get(4).getAsJsonObject().get("base_stat").getAsInt();
			stamina = 50;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name != null ? new PokemonMetadata(index, name, attack, defense, stamina) : null;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pokemon> getPokemons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		// TODO Auto-generated method stub
		return null;
	}

}
