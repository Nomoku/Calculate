package com.newer.BigNumAdd;

public class NumAdd {
	
	String s1 = "15432";
	String s2 = "654321";
	
	StringBuffer sb1 = new StringBuffer(s1);
	StringBuffer sb2 = new StringBuffer(s2);
	
	public static void main(String[] args) {
		
		String s1 = "15432";
		String s2 = "654321";
		
		int i,j;
		
		StringBuffer sb1 = new StringBuffer(s1);
		StringBuffer sb2 = new StringBuffer(s2);
		
		if(sb1.length()>sb2.length()) {
			i = sb1.length();
			j = sb2.length();
		}else {
			i = sb2.length();
			j = sb1.length();
		}
		
//		StringBuffer sb3 = new StringBuffer(j);
		int flag = 0;
		
		for(;j>0;i--,j--) {
			
			int sum = Integer.valueOf(sb2.charAt(i-1))+Integer.valueOf(sb1.charAt(j-1))+flag;
			
			if(sum>=10) {				
				sum = sum%10;
				sb2.setCharAt(j-1,String.valueOf(sum).charAt(0));
				flag = 1;
			}else{
				sb2.setCharAt(j-1,String.valueOf(sum).charAt(0));
				flag = 0;
			}
			
		}
		
		System.out.println(sb2);
	}
	
	
	
}
