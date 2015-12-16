package com.beerExpert;

public class UserTaste {
	public String Desire;
	public String FlavorRelevancy;
	public boolean KnownFlavorRelevancy;
	public String Flavor;
	
	public UserTaste Populate()
	{
		UserTaste newObj = new UserTaste();
		newObj.Desire = this.Desire;
		newObj.FlavorRelevancy = this.FlavorRelevancy;
		newObj.KnownFlavorRelevancy = this.KnownFlavorRelevancy;
		newObj.Flavor = this.Flavor;
		return newObj;
	}
	
}
