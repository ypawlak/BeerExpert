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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

import org.drools.runtime.StatefulKnowledgeSession;

import com.beerExpert.Question;
import com.beerExpert.BeerExpertMain;

public class GuiApp extends Application{
	
	private DialogWindowController controller;

	public DialogWindowController getController() {
		return controller;
	}

	public void setController(DialogWindowController controller) {
		this.controller = controller;
	}

	@Override
    public void start(Stage primaryStage) throws Exception {
    
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogWindow.fxml"));
        Parent root = (Parent)loader.load();
        controller = (DialogWindowController)loader.getController();
        
//        AnchorPane anchorPane = new AnchorPane();
//        AnchorPane.setTopAnchor(root, 3.0);
//        AnchorPane.setBottomAnchor(root, 3.0);
//        AnchorPane.setLeftAnchor(root, 10.0);
//        AnchorPane.setRightAnchor(root, 3.0);
//        anchorPane.getChildren().add(root);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Super barman");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.sizeToScene();
        
    	controller.ShowQuestion();
    	BeerExpertMain.SetGui(this);
    }

    public void fire(String[] args)
    {
        launch(args);
    }

}
