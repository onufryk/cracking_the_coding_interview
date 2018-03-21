package com.onufryk.crack.one;

/*
 * Write code to reverse a C-Style String. 
 * (C-String means that “abcd” is represented as five characters, including the null character.)
 */
public class Question_01_02 {
	
	public static Character[] reverse_dummy(Character str[]) {
		Character[] reversed = new Character[str.length];
		
		reversed[str.length - 1] = str[str.length - 1];
		
		for (int ii = 0; ii < str.length - 1; ii++) {
			reversed[(str.length - 1) - ii - 1] = str[ii];
		}
		
		return reversed;
	}
	
	public static void reverse(Character str[], int index) {
		if (str[index] == '\0') {
			return;
		}
		reverse(str, index + 1);
		System.out.print(str[index]);
	}

	public static void main(String[] args) {
		Character str[] = {'a', 'b', 'c', 'd', '\0'};
		
		Character reversed[] = reverse_dummy(str);
		
		for (int ii = 0; ii < reversed.length; ii++) {
			System.out.print(reversed[ii]);
		}
		System.out.println();
		
		reverse(str, 0);
		System.out.println();
	}

}
