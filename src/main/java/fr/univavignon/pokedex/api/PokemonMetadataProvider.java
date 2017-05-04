package fr.univavignon.pokedex.api;

import java.net.URL;

import org.jsoup.Jsoup;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

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
			stamina = 75;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name != null ? new PokemonMetadata(index, name, attack, defense, stamina) : null;
	}

}
