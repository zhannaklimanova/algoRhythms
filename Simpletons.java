package Java_algoRhythms;

import java.util.Scanner;

public class Simpletons {
	
	/* 
	 * Characters
	 * charRightShift takes a character c and an integer n as inputs, 
	 * and returns a character. If the character received as input
	 * is a lower case letter of the English alphabet, the method
	 * returns the letter which is n positions to the right in 
	 * the alphabet. If the character received as input is not a lower
	 * case letter of the English alphabet, then the method returns 
	 * the character itself with no modifications.
	 * 
	 * e.g.:
	 * charRightShift('g', 2) returns 'i',
	 * charRightShift('#', 2) returns '#',
	 * charRightShift('z', 27) returns 'a'.
	 */
	public static char charRightShift(char c, int n) {
//		if (n < 0) // TODO a try-catch for this or throw exception
		if (c >= 'a' && c <= 'z') {
			return (char) positionFinder(c, n, 'z', 'a');
		}
		return c;
	}

	/*
	 * Helper method that can find a particular value in an interval of 
	 * numbers e.g. [1,4]. The method will count backwards or forwards
	 * in the range to find a specific value away from current value.
	 */
	public static int positionFinder(int currentValue, int shiftValue, int upperBound, int lowerBound) {
		int delta = upperBound - (lowerBound - 1);
		int counter = 0; 
		int newCounter = 0;
		int halfPoint = delta / 2;
			
		if (shiftValue >= delta) {
			counter = shiftValue % delta; // remainder will tell us how many values we need to move from current position
		} 
		else {
			counter = shiftValue; 
		}
		// if algorithms goes up delta number of values, it will end up where it started; counter is 0
		if (counter == 0) return currentValue; 
		
		/*
		 * We need to now split delta into 2 "equals" parts; if counter value is in lower range then we shift right, 
		 * otherwise, shift left. Algorithm is more efficient if the full range is split into multiple parts. 
		 */
		
		if (counter > 0 && counter <= (halfPoint)) {
			while (counter != 0) {
				if (currentValue == upperBound) {
					currentValue = lowerBound; 
					counter--; 
				}
				else {
					currentValue++; 
					counter--; 
				}
			}
		}
		else if (counter > (halfPoint) && counter <= delta) {
			newCounter = delta - counter; 
			while (newCounter != 0) {
				if (currentValue == lowerBound) {
					currentValue = upperBound; 
					newCounter--;
				}
				else {
					currentValue--; 
					newCounter--; 
				}
			}
		}
		
		return currentValue;
		
	}
	
	/*
	 * Characters
	 * testInput takes String as input and outputs true if the input is 
	 * equal to a user-chosen word. 
	 */
	public static boolean testInput(String input) {
//		Scanner userInput = new Scanner(System.in);
//		String userWord = userInput.next(); // TODO a scanner class thing later
		String chosenWord = "turtle";
		if (chosenWord.equals(input)) {
			return true;
		}
		return false;
	}
	
	/* 
	 * Characters
	 * testInput overloaded with inputs String s and int i; returns true if the
	 * character at index i is a vowel, false otherwise.
	 */
	public static boolean testInput(String s, int i) {
		char letter = s.charAt(i); 
		switch (letter) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		default: 
			return false;
		}
	}
	
	/* Arrays
	 * findLargestValue takes an array of integers as input and 
	 * returns the largest value in the array. 
	 */
	public static int findLargestValue(int[] array) { // TODO rewrite this using a sorting algorithm and then just take the last element
		int currentVal = array[0]; // TODO for this algorithm throw exception if the array is null and its length is null
		
		for (int val: array) {
			if (val > currentVal) {
				currentVal = val;
			}
		}
		return currentVal;
	}
	
	/*
	 * findPrimes takes a positive integer n as input and returns 
	 * an array containing the first n primes.
	 */
	public static int[] findPrimes(int n) {
		int[] primes = new int[n]; // TODO check for possible exceptions
		int counter = 0;
		int primeCounter = 2; 
		
		while (counter < n) {
			if (isPrime(primeCounter)) {
				primes[counter] = primeCounter;
				counter++;
			}
			primeCounter++;
		}
		
		return primes;
	}
	
	/*
	 * Helper method to determine if a number is prime.
	 */
	public static boolean isPrime(int number) {
		if ((((number == 2) || (number == 3) || (number == 5) || (number == 7)) || 
				((number % 2) != 0) && ((number % 3) != 0) && ((number % 5) != 0) && ((number % 7) != 0))) { 
			return true;
		}
		return false;
	}
	
	/*
	 * shiftByOne method takes an array as input and returns an array 
	 * where all the elements have been moved up by one position. The
	 * element at the end of the array should end up at the beginning.
	 * Creating a new array
	 * 
	 * e.g.: 
	 * initial array [2,4,6,8,1,2,3] => [3,2,4,6,8,1,2]
	 */
	public static int[] shiftByOne(int[] array) {
		int[] newArray = new int[array.length]; // create new array and populate it
		newArray[0] = array[array.length - 1];
		
		for (int i = 1; i < newArray.length - 1; i++) {
//			newArray[i] = 
		}
		return newArray;
	}
	
	/*
	 * shiftByOne2 method takes an array as input and returns an array 
	 * where all the elements have been moved up by one position. The
	 * element at the end of the array should end up at the beginning.
	 * Not creating a new array
	 * 
	 * e.g.: 
	 * initial array [2,4,6,8,1,2,3] => [3,2,4,6,8,1,2]
	 */
	
	/*
	 * intersection method takes two integer arrays as input and returns
	 * an array corresponding to the intersection of the two arrays.
	 */
	
	/*
	 * isUpperCase takes a char as input and returns true if the char 
	 * represents an upper-case letter of the English alphabet; returns 
	 * false otherwise. 
	 */
	
	/*
	 * countUpper takes a String as input and counts how many characters are 
	 * upper-case letters of the English alphabet. 
	 */
	
	/*
	 * toLowerCase takes a String as input and returns a String with the 
	 * same characters, but converted to lower case.
	 */
	
	/*
	 * toLowerCase takes an array of chars as input and changes each char 
	 * to lower-case.
	 */
}
