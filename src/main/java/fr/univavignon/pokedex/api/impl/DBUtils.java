package fr.univavignon.pokedex.api.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.univavignon.pokedex.api.Pokemon;

public class DBUtils {

	private static String FILE = Pokedex.class.getResource("/db/pokemons").toExternalForm();
	private static String URL = "jdbc:sqlite:" + FILE;

	public static void createTables() {
		try (Connection conn = DriverManager.getConnection(URL)) {
			if (conn != null) {

				Statement stmt = null;
				stmt = conn.createStatement();

				String sql = "CREATE TABLE IF NOT EXISTS pokemons (\n" + "id integer PRIMARY KEY,\n"
						+ "name text NOT NULL,\n" + "attack integer,\n" + "defense integer,\n" + "stamina integer,\n"
						+ "cp integer,\n" + "hp integer,\n" + "dust integer,\n" + "candy integer,\n" + "iv real\n"
						+ ");";
				stmt.execute(sql);

				// sql = "CREATE TABLE IF NOT EXISTS pokemons (\n" + " index
				// integer PRIMARY KEY,\n"
				// + " name text NOT NULL,\n" + "attack integer,\n" + "defense
				// integer,\n" + "stamina integer,\n"
				// + "cp integer,\n" + "hp integer,\n" + "dust integer,\n" +
				// "candy integer,\n" + "iv real,\n"
				// + ");";
				// stml.execute(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addPokemonToDb(Pokemon pokemon) {
		String sql = "INSERT INTO pokemons(id,name, attack, defense, stamina, cp, hd, dust, candy, iv) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// pstmt.setString(1, name);
			// pstmt.setDouble(2, capacity);
			if (pokemon != null) {
				pstmt.setInt(1, pokemon.getIndex());
				pstmt.setString(2, pokemon.getName());
				pstmt.setInt(3, pokemon.getAttack());
				pstmt.setInt(4, pokemon.getDefense());
				pstmt.setInt(5, pokemon.getStamina());
				pstmt.setInt(6, pokemon.getCp());
				pstmt.setInt(7, pokemon.getHp());
				pstmt.setInt(8, pokemon.getDust());
				pstmt.setInt(9, pokemon.getCandy());
				pstmt.setDouble(10, pokemon.getIv());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int getRowsCount() {
		String sql = "SELECT * FROM pokemons";
		int res = 0;
		try (Connection conn = DriverManager.getConnection(URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next())
				res++;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public static Pokemon getRow(int index) {
		String sql = "SELECT * FROM pokemons WHERE id='" + index + "'";
		try (Connection conn = DriverManager.getConnection(URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			return new Pokemon(rs.getInt("id"), rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"),
					rs.getInt("stamina"), rs.getInt("cp"), rs.getInt("hd"), rs.getInt("dust"), rs.getInt("candy"),
					rs.getInt("iv"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static List<Pokemon> getAllPokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<>();

		String sql = "SELECT * FROM pokemons";
		try (Connection conn = DriverManager.getConnection(URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				pokemons.add(getRow(rs.getInt("id")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return pokemons;
	}

	public static boolean rowExist(int index) {
		boolean exist = false;
		String sql = "SELECT * FROM pokemons WHERE id = '" + index + "'";
		try (Connection conn = DriverManager.getConnection(URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return exist;
	}

}
