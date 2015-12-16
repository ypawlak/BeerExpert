package com.beerExpert;

public class Circumstances {
	public String Location;
	public String Weather;
	public String Movement;
	public String Destination;
	public String SituationOutside;
	
	public Circumstances Populate() {
		Circumstances newObj = new Circumstances();
		newObj.Location = this.Location;
		newObj.Weather = this.Weather;
		newObj.Movement = this.Movement;
		newObj.Destination = this.Destination;
		newObj.SituationOutside = this.SituationOutside;
		return newObj;
	}
}
