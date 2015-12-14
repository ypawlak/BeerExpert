package gui;

import gui.DialogWindowController;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

import org.drools.runtime.StatefulKnowledgeSession;

import com.beerExpert.Question;
import com.beerExpert.BeerExpertMain;

public class GuiApp extends Application implements Observer{
	//private Question activeQuestion;
	private DialogWindowController controller;

	public DialogWindowController getController() {
		return controller;
	}

	public void setController(DialogWindowController controller) {
		this.controller = controller;
	}
/*
	public Question getActiveQuestion() {
		return activeQuestion;
	}

	public void setActiveQuestion(Question activeQuestion) {
		this.activeQuestion = activeQuestion;
		//controller.ShowQuestion(activeQuestion);
	}
*/
	@Override
    public void start(Stage primaryStage) throws Exception {
    
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogWindow.fxml"));
        Parent root = (Parent)loader.load();
        controller = (DialogWindowController)loader.getController();

        controller.addObserver((Observer) this);
        
        Scene scene = new Scene(root, 300, 200, Color.BURLYWOOD);
        
        primaryStage.setTitle("Super barman");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    	//controller.ShowQuestion(activeQuestion);
    }

    public void fire(String[] args)
    {
        launch(args);
    }

	public void update(Observable arg0, Object arg1) {
		//BeerExpertMain.getKsession().fireAllRules();
	}

}
