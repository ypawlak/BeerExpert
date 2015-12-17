package gui;

import gui.DialogWindowController;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

import org.drools.runtime.StatefulKnowledgeSession;

import com.beerExpert.ImageHelper;
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

        
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(ImageHelper.getImage("icon_beer.gif"));
        primaryStage.setTitle("Super barman");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.sizeToScene();
        
    
    	controller.update();
    	BeerExpertMain.SetGui(this);
    }

    public void fire(String[] args)
    {
        launch(args);
    }

}
