package com.beerExpert;

import java.util.Observer;

import gui.GuiApp;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.beerExpert.Question;

/**
 * This is a sample class to launch a rule.
 */
public class BeerExpertMain {
	private static GuiApp gui;
	private static KnowledgeBase kbase;
	private static StatefulKnowledgeSession ksession;
	public static Question ActiveQuestion;
	public static Answer SelectedAnswer;

	public static StatefulKnowledgeSession getKsession() {
		return ksession;
	}

	public static void setKsession(StatefulKnowledgeSession ksession) {
		BeerExpertMain.ksession = ksession;
	}
	
	public static void SetGui(GuiApp val) {
		gui = val;
	}

	private static KnowledgeRuntimeLogger logger;


	public static final void main(String[] args) {
		try {
			System.out.println("main()");
			initializeKnowledgeBase();
			ksession.fireAllRules();
			initializeGui(args);
			//logger.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	private static void initializeGui(String[] args){
		new GuiApp().fire(args);
	}
	
	private static void initializeKnowledgeBase() throws Exception{
		kbase = readKnowledgeBase();
		ksession = kbase.newStatefulKnowledgeSession();
		logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
	}

	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"),
				ResourceType.DRL);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

	public static void update() {
		try {
			StatefulKnowledgeSession session = getKsession();
			session.insert(ActiveQuestion.GetSelectedState());
			session.fireAllRules();
			gui.getController().ShowQuestion();
		} catch(NotImplementedException ex) {
			System.err.println("FATAL ERROR");
		}
		
	}
}
