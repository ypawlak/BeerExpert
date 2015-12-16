package com.beerExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Question {
	
			
	public String QuestionTxt;
	public List<String> Answers;
	public List<String> SelectedAnswers = new ArrayList<String>();
	public SelectionMode SelMode = SelectionMode.SINGLE;
	
	public Question(String text, List<String> answers) {
		QuestionTxt = text;
		Answers = answers;
	}
	
	public Question(String text, List<String> answers, SelectionMode selMode) {
		QuestionTxt = text;
		Answers = answers;
		SelMode = selMode;
	}
}
