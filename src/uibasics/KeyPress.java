package uibasics;

import java.util.Observable;

public class KeyPress extends Observable{
	
	String myString;
	
	public KeyPress(String name){
		myString = name;
	}
	
	public String toString(){
		return myString;
	}
}
