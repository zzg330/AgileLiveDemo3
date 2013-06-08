package com.autodesk.agiledemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWearingAdvice {
	Weather weather = new Weather();
	
	@Test
	public void return_shirts_when_temperature_60_and_condition_sunny() {
		assertExpectedWearingAdviceEquals("Sunny", 60d, "Shirts");
	}
	
	@Test
	public void return_raincoat_when_temperature_60_and_condition_raining() {
		assertExpectedWearingAdviceEquals("Raining", 60d, "Raincoat");
	}
	
	@Test
	public void return_tshirt_when_temperature_70_and_condition_sunny() {
		assertExpectedWearingAdviceEquals("Sunny", 70d, "T-shirt");
	}
	
	@Test
	public void return_umbrella_and_tshirt_when_temperature_70_and_condition_raining() {
		assertExpectedWearingAdviceEquals("Raining", 70d, "Umbrella, T-shirt");
	}
	
	@Test
	public void return_noadvice_when_temperature_out_of_range() {
		assertExpectedWearingAdviceEquals("Sunny", 80d, "No Advice");
		assertExpectedWearingAdviceEquals("Raining", 59d, "No Advice");
		
	}
	
	
	@Test
	public void return_noadvice_when_condition_uncovered() {
		assertExpectedWearingAdviceEquals("Cloudy", 60d, "No Advice");
		assertExpectedWearingAdviceEquals("Fair", 79d, "No Advice");
	}
	
	private void assertExpectedWearingAdviceEquals(String condition, double temperature, String expectedWearingAdvice) {
		weather.setCondition(condition);
		weather.setTemperature(temperature);
		assertEquals(expectedWearingAdvice, weather.getWearingAdvice());
	}
}
