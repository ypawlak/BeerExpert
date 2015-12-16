package com.beerExpert;

import java.util.ArrayList;

public final class QuestionsSet {
	public static final String InitializeQuestionTxt = "Czy chcesz wypiæ piwo?";
	public static final String OvertureQuestionTxt = "Czy smak piwa jest Ci obojêtny?";
	public static final String ThinkItOverTxt = "Przemyœl to";
	
	public static final Question InitQuestion = new Question(InitializeQuestionTxt, AnswersSet.YesNoAnswers);
	public static final Question OvertureQuestion = new Question(OvertureQuestionTxt, AnswersSet.YesNoAnswers);
	public static final Question ThinkItOverQuestion = new Question(ThinkItOverTxt, new ArrayList<String>());
}
