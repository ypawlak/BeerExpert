package com.beerExpert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Answer {
	public String AnswerTxt;
	public BufferedImage AnswerImage;
	private final String imgPath = "src\\images\\";
	
	public void SetImage(String name){
		String fullPath = imgPath + name;
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("src\\images\\Eurolager.jpg"));
		    AnswerImage = img;
		} catch (IOException e) {
			System.out.println("Nie znaleziono obrazu!");
		}
	}

}
