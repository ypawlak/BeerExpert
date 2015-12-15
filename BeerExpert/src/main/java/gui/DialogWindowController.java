package gui;

import java.net.URL;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import com.beerExpert.Question;
import com.beerExpert.BeerExpertMain;
import com.beerExpert.UserTaste;

public class DialogWindowController extends Observable implements Initializable {

	@FXML
	private Label questionLbl;
	@FXML
	private GridPane mainPane;
	@FXML
	private VBox optionsBox;
	@FXML
	private Button okBtn;

	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	public void ShowQuestion (Question question) {
		optionsBox.getChildren().clear();
		questionLbl.setText(question.QuestionTxt);
		ToggleGroup questionGroup = new ToggleGroup();
		for (Map.Entry<String, Object> ans : question.Answers.entrySet()) {
			RadioButton option = new RadioButton(ans.getKey());
			option.setToggleGroup(questionGroup);
			option.setUserData(ans);
			optionsBox.getChildren().add(option);
		}
	}

	@FXML
	private void okButtonClicked(ActionEvent event) {
		setChanged();
		notifyObservers();
		for (Node child : optionsBox.getChildren()) {
			if (child instanceof RadioButton
					&& ((RadioButton) child).isSelected()) {
				BeerExpertMain.getKsession().insert(
						BeerExpertMain.ActiveQuestion.Answers
								.get(((RadioButton) child).getText()));

			}
		}
		BeerExpertMain.getKsession().fireAllRules();
		ShowQuestion(BeerExpertMain.ActiveQuestion);

	}

}
