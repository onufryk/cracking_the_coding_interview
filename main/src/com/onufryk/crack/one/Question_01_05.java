package com.onufryk.crack.one;

/*
 * 1.5 Write a method to replace all spaces in a string with ‘%20’.
 */
public class Question_01_05 {
	
	public static String replaceSpaces(String str) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i)== ' ') {
				spaceCount++;
			}
		}
		newLength = str.length() + spaceCount * 2;
		char newStr[] = new char[newLength];
		for (i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				newStr[newLength - 1] = '0';
				newStr[newLength - 2] = '2';
				newStr[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				newStr[newLength - 1] = str.charAt(i);
				newLength = newLength - 1;
			}
		}
		
		StringBuffer newString = new StringBuffer();
		for (i = 0; i < newStr.length; i++) {
			newString.append(newStr[i]);
		}
		
		return newString.toString();
	}

	public static void main(String[] args) {
		String str = "Write a method to replace.";
		
		System.out.println(replaceSpaces(str));
	}

}
