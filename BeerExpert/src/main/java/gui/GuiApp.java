package gui;

import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

import com.beerExpert.Question;

public class GuiApp extends Application {

	@Override
    public void start(Stage primaryStage) throws Exception {
    
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogWindow.fxml"));
        Parent root = (Parent)loader.load();
        DialogWindowController controller = (DialogWindowController)loader.getController();
        
        Scene scene = new Scene(root, 300, 200, Color.BURLYWOOD);
        
        primaryStage.setTitle("Super barman");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Question simpleYesNo = new Question();
        simpleYesNo.QuestionTxt = "Czy chcesz wypiæ piwo?";
        List<String> options = new ArrayList<String>();
        options.add("Tak");
        options.add("Nie");
        simpleYesNo.Answers = options;
    	controller.ShowQuestion(simpleYesNo);
    }

    public void fire(String[] args)
    {
        launch(args);
    }

}
