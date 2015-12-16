package com.beerExpert;

import java.util.ArrayList;
import java.util.List;

public final class AnswersSet {

	public static final String Yes = "Tak";
	public static final String No = "Nie";
	
	public static final List<String> YesNoAnswers = new ArrayList<String> () {
				{
					add(Yes);
					add(No);
				}
			};
}
