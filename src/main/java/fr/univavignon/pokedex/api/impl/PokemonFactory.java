package fr.univavignon.pokedex.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class PokemonFactory implements IPokemonFactory {

	/**
	 * 
	 */
	IPokemonMetadataProvider pokemonMetadataProvider;

	/**
	 * 
	 */
	Wait<WebDriver> wait;

	public PokemonFactory() {
		pokemonMetadataProvider = new PokemonMetadataProvider();
	}

	/**
	 * 
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		Pokemon pokemon = null;
		try {
			PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);

			List<String> ivStamina = ivCalculator(pokemonMetadata.getName(), cp, hp, dust);

			pokemon = new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(),
					pokemonMetadata.getDefense(), Integer.parseInt(ivStamina.get(0)), cp, hp, dust, candy,
					Double.parseDouble(ivStamina.get(1).substring(0, ivStamina.get(1).length() - 1)));
		} catch (PokedexException e) {
			e.printStackTrace();
		}

		return pokemon;
	}

	/**
	 * 
	 * @param name
	 * @param cp
	 * @param hp
	 * @param dust
	 * @return
	 */
	public List ivCalculator(String name, int cp, int hp, int dust) {
		ChromeDriverManager.getInstance().setup();

		WebDriver webDrive = new ChromeDriver();

		webDrive.navigate().to("https://pokeassistant.com/main/ivcalculator?locale=en");

		webDrive.findElement(By.id("search_pokemon_name")).sendKeys(name);

		webDrive.findElement(By.id("search_cp")).sendKeys(Integer.toString(cp));

		webDrive.findElement(By.id("search_hp")).sendKeys(Integer.toString(hp));

		Select dustDropDown = new Select(webDrive.findElement(By.id("search_dust")));

		dustDropDown.selectByValue(Integer.toString(dust));

		webDrive.findElement(By.id("calculatebtn")).click();

		WebElement tableComb = webDrive.findElement(By.id("possiblecombis"));

		List<WebElement> trCollection = tableComb.findElements(By.xpath("id('possiblecombis')/tbody/tr"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<String> result = new ArrayList<String>();

		result.add(trCollection.get(0).findElements(By.xpath("td")).get(3).getText());

		result.add(trCollection.get(0).findElements(By.xpath("td")).get(4).getText());

		webDrive.quit();

		return result;
	}

}
