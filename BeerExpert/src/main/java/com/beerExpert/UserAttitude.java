package com.beerExpert;

public class UserAttitude {
	public String Requirements;
	
	public UserAttitude Populate(){
		UserAttitude newObj = new UserAttitude();
		newObj.Requirements = this.Requirements;
		return newObj;
	}
}
