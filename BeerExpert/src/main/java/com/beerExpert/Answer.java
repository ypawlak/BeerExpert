package com.beerExpert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;

public class Answer {
	public String AnswerTxt;
	public Image AnswerImage;
	
	
	public void SetImage(String name){
		AnswerImage = ImageHelper.getImage(name);
	}

}
