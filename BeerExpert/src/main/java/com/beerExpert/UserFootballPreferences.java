package com.beerExpert;

public class UserFootballPreferences {
	public String FavoriteFootballClub;
	public String PolishFootballFan;
	
	public UserFootballPreferences Populate() {
		UserFootballPreferences newObj = new UserFootballPreferences();
		newObj.FavoriteFootballClub = this.FavoriteFootballClub;
		newObj.PolishFootballFan = this.PolishFootballFan;
		return newObj;
	}
}
