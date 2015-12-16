package com.beerExpert;

public class UserTaste {
	public String Desire;
	public String FlavorRelevant;
	public String Flavor;
	public String Hop;
	public String Aroma;
	
	public UserTaste Populate()
	{
		UserTaste newObj = new UserTaste();
		newObj.Desire = this.Desire;
		newObj.FlavorRelevant = this.FlavorRelevant;
		newObj.Flavor = this.Flavor;
		newObj.Hop = this.Hop;
		newObj.Aroma = this.Aroma;
		return newObj;
	}
	
}
