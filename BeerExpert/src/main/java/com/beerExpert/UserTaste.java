package com.beerExpert;

public class UserTaste {
	public String Desire;
	public String FlavorRelevancy;
	public boolean KnownFlavorRelevancy;
	public String Flavor;
	public String Hop;
	public String Aroma;
	public String HopBeer;
	public String Coffee;
	public String Bitters;
	public String Sour;
	
	public UserTaste Populate()
	{
		UserTaste newObj = new UserTaste();
		newObj.Desire = this.Desire;
		newObj.FlavorRelevancy = this.FlavorRelevancy;
		newObj.KnownFlavorRelevancy = this.KnownFlavorRelevancy;
		newObj.Flavor = this.Flavor;
		newObj.Hop = this.Hop;
		newObj.Aroma = this.Aroma;
		newObj.HopBeer = this.HopBeer;
		newObj.Coffee = this.Coffee;
		newObj.Bitters = this.Bitters;
		newObj.Sour = this.Sour;
		return newObj;
	}
	
}
