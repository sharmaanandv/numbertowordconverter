package com.converter.impl;

public class NumberToWordsConverter {

	// string[] to get values till 19
	private static final String[] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	// string array to get values above 20
	private static final String[] tens = { "", // 0
			"", // 1
			"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	
	 private static final String[] thousands = { ""," thousand"," million"," billion"," trillion"};

	public static void main(String[] args) {
		NumberToWordsConverter n = new NumberToWordsConverter();
		System.out.println(n.convert(0));
		System.out.println(n.convert(-100));
		System.out.println(n.convert(100));
		System.out.println(n.convert(105));
		System.out.println(n.convert(5945781));
		System.out.println(n.convert(56945781));
		System.out.println(n.convert(999999999));
	}
	
	public String convert(int num) {
		if(num==0) {
			return "zero";
		}else if(num>999999999) {
			return "Number is too high";
		}
		return convertNum(num);
		
	}
	
	private String convertNum(final int n) {
		try {
			if (n < 0) {
				return "minus " + convertNum(-n);
			}else if (n < 20) {
				return units[n];
			}else if (n < 100) {
				return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
			}else if (n < 1000) {
				return units[n / 100] + " hundred" + ((n % 100 != 0) ? " and " : "") + convertNum(n % 100);
			}else if (n < 1000000) {
				return convertNum(n / 1000) + " thousand" + ((n % 10000 != 0) ? " " : "") + convertNum(n % 1000);
			}else if (n < 1000000000) {
				return convertNum(n / 1000000) + " million" + ((n % 1000000 != 0) ? " " : "") + convertNum(n % 1000000);
			}else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}

}