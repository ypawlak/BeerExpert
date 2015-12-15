package com.beerExpert;

public class UserTaste {
	public boolean WantsBeer;
	public boolean IsFlavorRelevant;
	
	public UserTaste Populate()
	{
		UserTaste newObj = new UserTaste();
		newObj.WantsBeer = this.WantsBeer;
		newObj.IsFlavorRelevant = this.IsFlavorRelevant;
		return newObj;
	}
	
}
