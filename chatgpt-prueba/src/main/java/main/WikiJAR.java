package main;

import Jwiki.Jwiki;

public class WikiJAR {

	public static void main(String[] args) {
		Jwiki jwiki = new Jwiki("Potasium");
		System.out.println("Title :" + jwiki.getDisplayTitle()); // get title
		System.out.println("Text : " + jwiki.getExtractText()); // get summary text
		System.out.println("Image : " + jwiki.getImageURL());

	}

}
