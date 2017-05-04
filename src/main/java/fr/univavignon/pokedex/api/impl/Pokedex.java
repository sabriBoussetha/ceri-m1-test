package fr.univavignon.pokedex.api.impl;

import java.awt.FocusTraversalPolicy;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.List;

import org.jsoup.Jsoup;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class Pokedex implements IPokedex {

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

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// String file =
		// Pokedex.class.getResource("/db/pokemons").toExternalForm();
		// String url = "jdbc:sqlite:" + file;
		// try (Connection conn = DriverManager.getConnection(url)) {
		// if (conn != null) {
		// DatabaseMetaData meta = conn.getMetaData();
		// System.out.println("The driver name is " + meta.getDriverName());
		// System.out.println("A new database has been created.");
		// DBUtils.addPokemonToDb(new Pokemon(1, "fgyhjtygj", 55, 65, 96, 74,
		// 75, 87, 56, 67));
		// DBUtils.createTables();
		// Statement stmt = conn.createStatement();
		// ResultSet rs = stmt.executeQuery("SELECT * FROM pokemons");
		// ResultSetMetaData rsmd = rs.getMetaData();
		// for (int i = 1; i <= rsmd.getColumnCount(); i++)
		// System.out.println(rsmd.getColumnName(i));
		// }
		// } catch (SQLException e) {
		// System.out.println(e.getMessage());
		// }
		
		return DBUtils.getRowsCount();
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
