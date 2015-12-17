package com.beerExpert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;

public class Answer {
	public String AnswerTxt;
	public Image AnswerImage;
	public Question AdditionalQuestion;
	private final String imgPath = "src\\images\\";
	
	public void SetImage(String name){
		String fullPath = imgPath + name;
		File imFile = new File(fullPath);
		AnswerImage = new Image(imFile.toURI().toString());
	}

}
