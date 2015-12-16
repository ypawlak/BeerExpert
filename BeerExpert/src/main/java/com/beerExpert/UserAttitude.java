package com.beerExpert;

public class UserAttitude {
	public String Requirements;
	public String Strength;
	
	public UserAttitude Populate(){
		UserAttitude newObj = new UserAttitude();
		newObj.Requirements = this.Requirements;
		newObj.Strength = this.Strength;
		return newObj;
	}
}
