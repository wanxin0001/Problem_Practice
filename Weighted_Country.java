/*
randomly generate countries by the weighted
USA 3;
France 2;
China 4;
Spain 1;

Notice: it introduces the random by the weight;
*/

import java.util.*;

public class Weighted_Country {
	private static class Country{
		String country;
		int weight;

		public Country(String country, int weight) {
			this.country = country;
			this.weight = weight;
		}

	}
	public static void main(String[] str) {
		Country[] countries = { new Country("USA", 3), new Country("France", 2), new Country("China", 4), new Country("Spain", 1) };
		int total = 0;
		for (Country country : countries) {
			total += country.weight;
		}

		for (int i = 0; i < 10; i++) {
			generateRandomCountry(total, countries);
		}
		

	}

	private static void generateRandomCountry(int total, Country[] countries) {
		int index = -1;
		double random = Math.random() * total; //Notice
		for (int i = 0; i < countries.length; i++) {
			random -= countries[i].weight;
			if (random <= 0) {
				index = i;
				System.out.println(countries[i].country);
				return;
			}
		}
	}
}