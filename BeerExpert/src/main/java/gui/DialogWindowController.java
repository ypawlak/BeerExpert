package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import com.beerExpert.Question;

public class DialogWindowController implements Initializable {

	@FXML
	private Label questionLbl;
	@FXML
	private VBox mainBox;
	
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	public void ShowQuestion (Question question) {
		questionLbl.setText(question.QuestionTxt);
		ToggleGroup questionGroup = new ToggleGroup();
		for(String ans : question.Answers) {
			RadioButton option = new RadioButton(ans);
			option.setToggleGroup(questionGroup);
			option.setUserData(ans);
			mainBox.getChildren().add(option);
		}
	}

}
