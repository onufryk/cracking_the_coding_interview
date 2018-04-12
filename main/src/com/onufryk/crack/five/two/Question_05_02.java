/*
 * Given a (decimal - e.g. 143.7287) number that is passed in as a string, print the binary representation. 
 * 
 * If the number can not be represented accurately in binary, print “ERROR”
 */
package com.onufryk.crack.five.two;

public class Question_05_02 {

	public static void main(String[] args) {
		String input = "4.72";
		
		Long intPart = Long.parseLong(input.substring(0, input.indexOf(".")));
		Double decPart  = Double.parseDouble(input.substring(input.indexOf(".")));

		StringBuffer intString = new StringBuffer();
		while (intPart > 0) {
			long r = intPart % 2;
			intString.insert(0, r);
			intPart = intPart >> 1;
		}
		intString.append(".");

		Boolean error = false;
		StringBuffer decString = new StringBuffer();
		while (decPart > 0) {
			if (decString.length() > 32) {
				System.out.println("OVERFLOW");
				break;
			}
			if (decPart == 1) {
				decString.append("1");
				break;
			}
			decPart = decPart * 2;
			if (decPart >= 1) {
				decString.append("1");
				decPart = decPart - 1;
			} else {
				decString.append("0");
			}
		}
		if (!error) {
			System.out.println(intString.append(decString));
		}
	}

}
