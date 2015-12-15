package com.beerExpert;

import java.util.Map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Question {
	public String QuestionTxt;
	public Map<String, Object> Answers;
	public String SelectedAnswer;
	
	public Object GetSelectedState() throws NotImplementedException
	{
		if(SelectedAnswer != null && Answers.containsKey(SelectedAnswer))
			return Answers.get(SelectedAnswer);
		throw new NotImplementedException();
	}
}
