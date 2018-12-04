package com.newer.Calculate;

import java.math.BigDecimal;

import com.newer.Calculate.CalView.Callback;

public class CalController  implements Callback{

	CalModel calmodel;

	String f;
	
	protected CalController(CalModel calmodel) {
		super();
		this.calmodel = calmodel;
	}

	@Override
	public BigDecimal setString(String s) {
		return calmodel.setS(s);
		
	}
	
//	public static void main(String[] args) {
//		
//	}
	
	

	

		
}
