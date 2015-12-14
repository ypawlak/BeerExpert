package gui;

import java.net.URL;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import com.beerExpert.Question;
import com.beerExpert.BeerExpertMain;

public class DialogWindowController extends Observable implements Initializable {

	@FXML
	private Label questionLbl;
	@FXML
	private VBox mainBox;
	@FXML
	private Button okBtn;
	
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	public void ShowQuestion (Question question) {
		questionLbl.setText(question.QuestionTxt);
		ToggleGroup questionGroup = new ToggleGroup();
		for(Map.Entry <String, Object> ans : question.Answers.entrySet()) {
			RadioButton option = new RadioButton(ans.getKey());
			option.setToggleGroup(questionGroup);
			option.setUserData(ans);
			mainBox.getChildren().add(option);
		}
	}
	
	 @FXML
	 private void okButtonClicked(ActionEvent event) {
	     setChanged();
         notifyObservers();
         BeerExpertMain.getKsession().fireAllRules();
         ShowQuestion(BeerExpertMain.ActiveQuestion);
	 }

}
