package fr.univavignon.pokedex.api.impl;

import java.net.URL;

import org.jsoup.Jsoup;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		int defense = 0;
		int attack = 0;
		int stamina = 0;
		String name = null;
		try {
			URL url = new URL(
					"https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json");

			String json = Jsoup.connect(url.toString()).ignoreContentType(true).execute().body();

			JsonArray array = new JsonParser().parse(json).getAsJsonArray();

			JsonObject object = array.get(index).getAsJsonObject();

			name = object.get("Identifier").getAsString();
			attack = object.get("BaseAttack").getAsInt();
			defense = object.get("BaseDefense").getAsInt();
			stamina = object.get("BaseStamina").getAsInt();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return name != null ? new PokemonMetadata(index, name, attack, defense, stamina) : null;
	}

}
