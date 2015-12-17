package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.text.DefaultEditorKit.BeepAction;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import com.beerExpert.Question;
import com.beerExpert.BeerExpertMain;
import com.beerExpert.UserTaste;

public class DialogWindowController implements Initializable {

	@FXML
	private Label questionLbl;
	@FXML
	private Label beerAnswerLbl;
	@FXML
	private ImageView answerImage;
	@FXML
	private VBox mainPane;
	@FXML
	private VBox answerBox;
	@FXML
	private GridPane questionGrid;
	@FXML
	private VBox optionsBox;
	@FXML
	private Button okBtn;
	
	private final double AnswerHeight = 430;
	private final double AnswerWidth = 450;

	public void initialize(URL arg0, ResourceBundle arg1) {
		answerBox.managedProperty().bind(answerBox.visibleProperty());
		questionGrid.managedProperty().bind(questionGrid.visibleProperty());
		beerAnswerLbl.managedProperty().bind(beerAnswerLbl.visibleProperty());
		answerImage.managedProperty().bind(answerImage.visibleProperty());
		answerBox.setVisible(false);
		beerAnswerLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		mainPane.setFillWidth(true);
	}
	
	public void update () {
		optionsBox.getChildren().clear();
		if (BeerExpertMain.SelectedAnswer != null) {
			questionGrid.setVisible(false);
			answerBox.setVisible(true);
			beerAnswerLbl.setText(BeerExpertMain.SelectedAnswer.AnswerTxt);
			answerImage.setImage(BeerExpertMain.SelectedAnswer.AnswerImage);
			answerImage.setPreserveRatio(true);
			answerImage.setFitHeight(300);
			
			answerImage.getScene().getWindow().setHeight(AnswerHeight);
			answerImage.getScene().getWindow().setWidth(AnswerWidth);
			
			if(BeerExpertMain.ActiveQuestion != null) {
				questionGrid.setVisible(true);
				showQuestion(BeerExpertMain.ActiveQuestion);
				double newHeight = AnswerHeight + optionsBox.getChildren().size()*30 + 100;
				answerImage.getScene().getWindow().setHeight(newHeight);
			}
			answerImage.getScene().getWindow().centerOnScreen();
		}
		else if(BeerExpertMain.ActiveQuestion != null) {
			answerBox.setVisible(false);
			showQuestion(BeerExpertMain.ActiveQuestion);
			answerImage.getScene().getWindow().setHeight(optionsBox.getChildren().size()*30 + 100);
		}
	}
	
	private void showQuestion(Question value) {
		questionLbl.setText(value.QuestionTxt);
		ToggleGroup questionGroup = new ToggleGroup();
		for (Map.Entry<String, Object> ans : value.Answers.entrySet()) {
			RadioButton option = new RadioButton(ans.getKey());
			option.setToggleGroup(questionGroup);
			option.setUserData(ans);
			optionsBox.getChildren().add(option);
		}
	}

	@FXML
	private void okButtonClicked(ActionEvent event) {
		
		for (Node child : optionsBox.getChildren()) {
			if (child instanceof RadioButton
					&& ((RadioButton) child).isSelected()) {
				BeerExpertMain.ActiveQuestion.SelectedAnswer = ((RadioButton) child).getText();
			}
		}
		
		BeerExpertMain.update();
	}

}
