package com.newer.Calculate;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalModel {
	
	//传入的字符串
	private String s;
	
	//分解得到的运算符
	private char f;
	
	//运算的参数
	private String s1;
	private String s2;
	
	protected CalModel() {
		
	}

	public BigDecimal setS(String s) {
		//System.out.println("setS");
		this.s = s;
		for (int i = 0;i < s.length(); i++) {
			if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/') {
				s1 = s.substring(0, i);
				s2 = s.substring(i+1, s.length()-1);
				f = s.charAt(i);
				
//				System.out.println(s1);
//				System.out.println(s2);
//				System.out.println(f);
			}
		}
		switch (f) {
		case '+':
			return CalAdd();
		case '-':
			return CalSub();
		case '*':
			return CalMul();
		case '/':
			return CalDiv();
		default:
			break;
		}
		return null;
	}

	public BigDecimal CalAdd() {
		
		BigDecimal addend1 = new BigDecimal(s1);
		BigDecimal addend2 = new BigDecimal(s2);
//		System.out.println(String.valueOf(addend1+addend2));
		return addend1.add(addend2);	
		
	}
	
	public BigDecimal CalSub() {
		
		BigDecimal subend1 = new BigDecimal(s1);
		BigDecimal subend2 = new BigDecimal(s2);
		
		return subend1.subtract(subend2);	
		
	}
	
	public BigDecimal CalMul() {
		
		BigDecimal mulend1 = new BigDecimal(s1);
		BigDecimal mulend2 = new BigDecimal(s2);
		
		return mulend1.multiply(mulend2);		
	}
	
	public BigDecimal CalDiv() {
		
		BigDecimal muldiv1 = new BigDecimal(s1);
		BigDecimal muldiv2 = new BigDecimal(s2);
		
		return muldiv1.divide(muldiv2,MathContext.DECIMAL128);
		
	}
	
//	public static void main(String[] args) {
//		String s = "123+321";
//		CalModel calModel = new CalModel();
//		calModel.setS(s);
//		BigDecimal end1 = new BigDecimal(6);
//		BigDecimal end2 = new BigDecimal(7);
//		s = s+calModel.CalSub();
//		System.out.println(end1.subtract(end2));
//	}
	
}
