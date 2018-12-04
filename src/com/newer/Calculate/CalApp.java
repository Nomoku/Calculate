package com.newer.Calculate;

public class CalApp {
	public static void main(String[] args) {
		
		CalModel calmodel = new CalModel();
		CalController calcontroller = new CalController(calmodel);
		
		CalView calview = new CalView();
		calview.setCallback(calcontroller);
	}
	
}
