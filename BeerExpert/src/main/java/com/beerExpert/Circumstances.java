package com.beerExpert;

public class Circumstances {
	public String Location;
	public String Weather;
	
	public Circumstances Populate() {
		Circumstances newObj = new Circumstances();
		newObj.Location = this.Location;
		newObj.Weather = this.Weather;
		return newObj;
	}
}
