package com.beerExpert;

import java.io.File;

import javafx.scene.image.Image;

public class ImageHelper {
	private final static String imgPath = "src\\images\\";
	
	public static Image getImage(String fileName) {
		String fullPath = imgPath + fileName;
		File imFile = new File(fullPath);
		return new Image(imFile.toURI().toString());
	}
}
