package com.beerExpert;

public class Food {
	public String Kind;
	public String DishType;
	
	public Food Populate(){
		Food newObj = new Food();
		newObj.Kind = this.Kind;
		newObj.DishType = this.DishType;
		return newObj;
	}
}
