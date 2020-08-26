package Java_algoRhythms;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Simpletons {
	
	/*
	 * Include System.nanoTime() to time a method's execution before and 
	 * after the method call and printing the difference in returned values.
	 * (will return a value of type "long"). 
	 * 
	 */
	
	/* Characters#
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
		if ((n < 0)) {
			throw new IllegalArgumentException("Invalid input: shift amount 'n' cannot be negative");
		}
		
		if (c >= 'a' && c <= 'z') {
			return (char) positionFinder(c, n, 'z', 'a');
		}
		
		return c;
	}

	/* Integers#
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
	
	/* Characters#
	 * testInput takes String as input and outputs true if the input is 
	 * equal to a user-chosen word. 
	 */
	public static boolean testInput(String input) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please input a word ");
		String chosenWord = userInput.next(); 
		userInput.close(); // Scanner needs to be closed once its used 
		
		if (chosenWord.equals(input)) {
			return true;
		}
		return false;
	}
	
	/* Characters#
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
	
	/* Arrays#
	 * findLargestValue takes an array of integers as input and 
	 * returns the largest value in the array. 
	 */
	public static int findLargestValue(int[] array) { // TODO rewrite this using a sorting algorithm and then just take the last element
		if (array == null) {
			throw new NullPointerException("The input is incorrect; it must be a non-null array of a certain size");
		}
		int currentVal = array[0]; 
		
		for (int val: array) {
			if (val > currentVal) {
				currentVal = val;
			}
		}
		
		return currentVal;
	}
	
	/* Integers#
	 * findPrimes takes a positive integer n as input and returns 
	 * an array containing the first n primes.
	 */
	public static int[] findPrimes(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("You cannot have a negative number of primes"); 
		}
		int[] primes = new int[n]; 
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
	
	/* Integers#
	 * Helper method to determine if a number is prime.
	 */
	public static boolean isPrime(int number) {
		if ((((number == 2) || (number == 3) || (number == 5) || (number == 7)) || 
				((number % 2) != 0) && ((number % 3) != 0) && ((number % 5) != 0) && ((number % 7) != 0))) { 
			return true;
		}
		return false;
	}
	
	/* Arrays#
	 * shiftByOne method takes an array as input and returns an array 
	 * where all the elements have been moved up by one position. The
	 * element at the end of the array should end up at the beginning.
	 * Creating a new array
	 * 
	 * e.g.: 
	 * initial array [2,4,6,8,1,2,3] => [3,2,4,6,8,1,2]
	 */
	public static int[] shiftByOne(int[] array) { // this algorithm is not as efficient b/c I'm creating a new var called arrayCounter and updating it
		int[] newArray = new int[array.length]; // create new array and populate it
		newArray[0] = array[array.length - 1]; 
		int arrayCounter = 0;
		
		for (int newArrayCounter = 1; newArrayCounter <= newArray.length - 1; newArrayCounter++) {
			newArray[newArrayCounter] = array[arrayCounter];
			arrayCounter++;
		}
		return newArray;
	}
	
	/* Arrays#
	 * shiftByOne2 method takes an array as input and returns an array 
	 * where all the elements have been moved up by one position. The
	 * element at the end of the array should end up at the beginning.
	 * Not creating a new array
	 * 
	 * e.g.: 
	 * initial array [2,4,6,8,1,2,3] => [3,2,4,6,8,1,2]
	 */
	public static int[] shiftByOne2(int[] array) {
		int storedLastValue = array[array.length - 1]; 
		
		for (int i = array.length - 1; i >= 0; i--) {
			if ((i - 1) < 0) {
				break;
			}
			array[i] = array[i - 1];
		}
		array[0] = storedLastValue;
		return array;
	}
	
	/* Arrays#
	 * intersection method takes two integer arrays as input and returns
	 * an array corresponding to the intersection of the two arrays.
	 */
	public static int[] intersection(int[] array1, int[] array2) { 
		int[] intersectionArray = new int[0];
		int counter = 0; // TODO you can do binary search
		
		for (int iValue: array1) {
			for (int jValue: array2) {
				if ((iValue == jValue) && (duplicateExists(iValue, intersectionArray) == false)) {
					
					intersectionArray = increaseSize(intersectionArray);
					intersectionArray[counter] = iValue;
					counter++;
					break;
				}
			}
		}
		return intersectionArray;
	}
	
	/* Arrays#
	 * Helper method to increase the size of an array by 1. Since arrays
	 * are immutable, instead of using the ArrayList class this is the 
	 * only way to do this.
	 */
	public static int[] increaseSize(int[] initialArray) {
		int size = initialArray.length;
		int[] newArray = new int[size + 1];
		int counter = 0;
		
		for (int element: initialArray) {
			newArray[counter] = element;
			counter++;
		}
		return newArray;
	}
	
	/* Arrays#
	 * Helper method check for duplicates and remove them. 
	 */
	public static boolean duplicateExists(int value, int[] array) {
		for (int element: array) {
			if (element == value) {
				return true;
			}
		}
		return false;
	}
	
	/* Characters#
	 * isUpperCase takes a char as input and returns true if the char 
	 * represents an upper-case letter of the English alphabet; returns 
	 * false otherwise. 
	 */
	public static boolean isUpperCase(char c) {
		if (c >= 'A' && c <= 'Z') {
			return true;
		}
		return false;
	}
	
	/* Characters# Strings#
	 * countUpper takes a String as input and counts how many characters are 
	 * upper-case letters of the English alphabet. 
	 */
	public static int countUpper(String input) {
		int count = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (isUpperCase(input.charAt(i))) {
				count++;
			}
		}
		return count;
	}
	
	/* Characters# Strings#
	 * toLowerCase takes a String as input and returns a String with the 
	 * same characters, but converted to lower case.
	 */ 
	public static String toLowerCase(String input) {
		String lowerCaseString = ""; 
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (isUpperCase(c)) {
				c = (char) (c + 32); // narrowing because we're going from int => char
				lowerCaseString += c;
			}
			else {
				lowerCaseString += c;
			}
		}
		return lowerCaseString;
	}
	
	/* Characters#
	 * toLowerCase takes an array of chars as input and changes each char 
	 * to lower-case.
	 */
	public static void toLowerCase2(char[] characters) {
		for (int i = 0; i < characters.length; i++) {
			if (isUpperCase(characters[i])) {
				characters[i] = (char) (characters[i] + 32); // narrowing because we're going from int => char
			}
		}
	}
	
	/* Integers#
	 * randomGenerator displays 10 random integers between 0 and 50. Method creates
	 * a random object without a seed.
	 */
	public static void randomGenerator() {
		Random number = new Random();
		int quantity = 10;
		
		while (quantity > 0) {
			System.out.println(number.nextInt(51));
			quantity--;
		}
	}
	
	/* Integers#
	 * randomSeedGenerator that displays 10 random integers between 0 and 50. Method creates
	 * a random object with a seed. 
	 */
	public static void randomSeedGenerator(int seed) {
		Random number = new Random(seed);
		int quantity = 10;
		
		while (quantity > 0) {
			System.out.println(number.nextInt(51));
			quantity--;
		}
	}
	
	/* Arrays# Multidimensional
	 * isMatrix takes a 2D integer array as input and returns a boolean value. 
	 * The method returns true if the 2D array can be read as a matrix, that is, 
	 * each integer array has the same number of elements. The method returns 
	 * false otherwise. 
	 * 
	 * e.g.: 
	 * int[][] num1 = {{1,2,3}, {5,6}, {8}};
	 * int[][] num2 = {{2,2}, {0,6}, {8,9}}; 
	 * isMatrix(num1) returns false
	 * isMatrix(num2) returns true
	 */
	public static boolean isMatrix(int[][] array2D) {
		int length = array2D[0].length;
		
		for (int[] array: array2D) {
			if (length != array.length) {
				return false;
			}
		}
		return true;
	}
	
	/* Arrays#
	 * getColumn takes a 2D integer array representing a matrix and an integer i, 
	 * and returns an integer array with all the elements in the i-th column.
	 * 
	 * e.g.:
	 * int[][] matrix = {{2,3}, {5,6}, {8,9}};
	 * getColumn(matrix, 0) returns {2,5,8}
	 */
	public static int[] getColumn(int[][] array2D, int i) {
		if (i < 0) {
			throw new IndexOutOfBoundsException("Wrong index value");
		}
		int[] ithColumnElements = new int[0];
		int j = 0;
		
		for (int[] array: array2D) {
			try {
				ithColumnElements = increaseSize(ithColumnElements);
				ithColumnElements[j] = array[i];
				j++;
			}
			catch (Exception e) {
				System.out.println("There is no elements in this column");
			}	
		}
		return ithColumnElements;
	}
	
	/* Arrays# Multidimensional
	 * sumMatrix takes two 2D integer arrays as input with the same dimensions.
	 * The method returns a new 2D integer array corresponding to their sum.
	 * 
	 * e.g.: 
	 * int[][] matrix1 = {{2,3}, {5,1}};
	 * int[][] matrix2 = {{-1,5}, {2,-4}};
	 * sumMatrix(matrix1, matrix2) returns {{1,8}, {7,-3}};
	 */
	public static int[][] sumMatrix(int[][] array1, int[][] array2) { 
		if (!(isMatrix(array1) || isMatrix(array2)) || (canAdd(array1) != canAdd(array2))) { 
			throw new IllegalArgumentException("Invalid inputs");
		}
		int[][] addedArray = new int[array1.length][array1[0].length];

		for (int indexRow = 0; indexRow < array1.length; indexRow++) {
			for (int indexColumn = 0; indexColumn < array1[indexRow ].length; indexColumn++) {
				addedArray[indexRow][indexColumn] = array1[indexRow][indexColumn] + array2[indexRow][indexColumn];
			}
		}
		return addedArray;
	}
	
	/* Arrays# Multidimensional
	 * Helper method that checks whether there is an equal amount of elements
	 * inside each element of a 2D array. 
	 * 
	 * e.g.:
	 * int[][] badMatrix1 = {{2,3,4}, {5,1,3}};
	 * int[][] badMatrix2 = {{-1,5}, {2,-4}};
	 * The two matrices above are matrices but cannot be added together because
	 * one has 3 elements in each interior array and the other has 2 elements
	 * in each interior array.
	 */
	public static int canAdd(int[][] array) {
		int quantity = 0;
		
		if (isMatrix(array)) {
			for (int[] row: array) {
				for (quantity = 0; quantity < row.length; quantity++) {
				}
			}
		} 
		return quantity;
		
	}
	
	/* Arrays# Multidimensional
	 * dotProduct takes as input two integer arrays of the same dimension, say m, 
	 * and returns the dot product between the two: sigma(i = 0...m) ai * bi. 
	 *
	 * e.g.:
	 * int[] array1 = {2,4,1};
	 * int[] array2 = {1,5,9};
	 * dotProduct(array1, array2) returns 2*1 + 4*5 + 1*9 = 31
	 */
	public static int dotProduct(int[] array1, int[] array2) {
		if (array1.length != array2.length) {
			throw new IllegalArgumentException("The matrices you entered cannot be dotProduct together, as they are not of the same dimension");
		}
		int product = 0; 
		for (int i = 0; i < array1.length; i++) {
			product += array1[i] * array2[i];
		}
		return product;
	}
	
	/* Arrays# Multidimensional
	 * multiplyMatrix takes two 2D integer arrays as input. The method verifies that 
	 * the two inputs represent matrices and that the number of columns of the first 
	 * one is equal to number of rows of the second one. Then the
	 * method should return a new 2D integer array corresponding to their product. 
	 * Method uses getColumn and dotProduct to compute their product.
	 */
	public static int[][] multiplyMatrix(int[][] array1, int[][] array2) {
		if (!(isMatrix(array1) && (isMatrix(array2)))) {
			throw new IllegalArgumentException("The inputs you entered do not represent matrices"); 
		}
		else if ((array1[0].length) != (getColumn(array2, 0).length)) {
			throw new IllegalArgumentException("The two matrices cannot be multiplied together because the number of columns of the first \n" + 
					"one are not equal to number of rows of the second one."); 
		}
		
		int[][] multipliedMatrix = new int[array1.length][array2[0].length]; // or array1[0].length
		
		for (int row = 0; row < multipliedMatrix.length; row++) {
			for (int col = 0; col < multipliedMatrix[0].length; col++) {
				multipliedMatrix[row][col] = Simpletons.dotProduct(array1[row], getColumn(array2, col));
			}
		}
		return multipliedMatrix;
	}
	
	/* Arrays#
	 * reverse_iterative reverses the elements of an array list, which uses a constant amount 
	 * of additional space. A new array cannot be created, but the elements within the 
	 * original array must be reversed. 
	 */
	public static int[] reverse_iterative(int[] array) {
		for (int i = 0; i < array.length/2; i++) {
			swap(array, i, array.length-1-i);
		}
		return array;
	}
	
	/* Recursion# ArrayLists#
	 * reverse_recursive reverses the elements of an array list, using recursion.
	 */
	public static void reverse_recursive(ArrayList<Integer> array) {
		if (array.size() == 1) {
			return;
		}
		int firstElement = array.remove(0);
		reverse_recursive(array);
		array.add(firstElement);
	}
	
	/* ArrayLists# Integers# Recursion#
	 * sort_recursive sorts the elements of the array in a recursive manner.
	 */
	public static void sort_recursive(ArrayList<Integer> array) {
		if (array.size() == 1) {
			return;
		}
		int minElement = removeMinElement(array);
		sort_recursive(array);
		array.add(0, minElement);
	
	}

	/* ArrayLists# 
	 * removeMinElement removes the smallest element in the list.
	 */
	public static int removeMinElement(ArrayList<Integer> array) {
		int currentSmallest = array.get(0);
		int indexOfSmallest = 0;
		
		for (int i = 1; i < array.size(); i++) {
			if (array.get(i) < currentSmallest) {
				currentSmallest = array.get(i);
				indexOfSmallest = i;
			}
			continue;
		}
		array.remove(array.get(indexOfSmallest));
		return currentSmallest;
	}
	
	/* Integers# Arrays#
	 * removeMinElement finds the smallest element in the array.
	 */
	public static int findMinElement(int[] array) {
		int currentSmallest = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] < currentSmallest) {
				currentSmallest = array[1];
			}
		}
		return currentSmallest;
		
	}
	
	/* Arrays# Integers#
	 * swap switches element positions 
	 * 
	 * e.g.
	 * 5 6 => 6 5 
	 */
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	
	/* Arrays# Integers#
	 * remove removes the first instance of a given object e in a list/array, 
	 * assuming the list is represented as an array list and the size of the 
	 * list is N (meaning the array is completely full).
	 */
	public static int[] remove(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				shiftUp(array, i);
				break;
			}
		}
		return newArray(array);
	 }
	 
	 /* Arrays# Integers#
	  * Helper method shiftUp shifts the elements to remove an unwanted element and enforce
	  * that there is no empty spots.
	  */
	 public static void shiftUp(int[] array, int elementID) {
		 if (elementID >= 0) {
			 if (elementID < array.length-1) {
				 for (int i = elementID; i < array.length-1; i++) {
					 array[i] = array[i+1];
				 }
				 array[array.length-1 ] = 0;
			 }
			 else {
				 array[elementID] = 0; // case when elementID is at the final element in the array
			 }
		 }
	 }
	 
	 /* Arrays# Integers#
	  * Helper method newArray makes a new smaller array 
	  */
	 public static int[] newArray(int[] array) {
		 int[] newArray = new int[array.length - 1];
		 
		 for (int i = 0; i < newArray.length; i++) {
			 newArray[i] = array[i];
		 }
		 return newArray;
	 }
	 
	 /* Arrays# Integers#
	  * add method creates a bigger array twice as large, and adds an 
	  * element to it while copying all the previous array elements at 
	  * at the same time. Assuming that the array is full 
	  * (size == array.length).
	  */
	 public static int[] add(int[] array, int elementID, int element) {
		 int[] newArray = new int[array.length * 2];
		 
		 if (elementID < array.length) {
			 for (int i = 0, j = 0; i < array.length; i++, j++) {
				 if (i == elementID) {
					 newArray[i] = element;
					 j++;
				 }
				 newArray[j] = array[i];
			 }
		 }
		 return newArray;
	 }
	 
	 /* Arrays# Integers#
	  * addToEnd method adds an element to the end of a list/array. 
	  * Assuming that the array is full (size == array.length). 
	  */
	 public static int[] addToEnd(int[] array, int element) {
		 int[] newArray = new int[array.length * 2];
		 
		 for (int i = 0; i < array.length; i++) {
			 newArray[i] = array[i];
		 }
		 newArray[array.length] = element;
		 return newArray;
	 }
	 
	 /* Recursion# Integers#
	  * countDown uses iteration to count down from an input value. 
	  */
	 public static void countDown_iterative(int n) {
		for (int i = n; i >= 0; i--) {
			if (i == 0) {
				System.out.println("Go!");
			}
			else  {
				if (i == 0) {
					continue;
				}
				else {				
					System.out.println(i);
				}
			}
		}
	 }
	 
	 /* Recursion# Integers#
	  * countDown uses recursion to count down from an input value. 
	  */
	 public static void countDown_recursive(int n) {
		 if (n == 0) {
			 System.out.println("Go!");
		 }
		 else {
			 System.out.println(n);
			 countDown_recursive(n-1);
		 }
	 }
	 
	 /* Integers#
	  * factorial_iterative calculates the factorial of a number in an 
	  * iterative manner.
	  */
	 public static int factorial_iterative(int n) {
		 int result = 1;
		 for (int i = 2; i <= n; i++) {
			 result = result * i; 
		 }
		 return result;
	 }
	
	 /* Recursion# Integers#
	  * factorial_recursive calculates the factorial of a number in an 
	  * iterative manner.
	  */
	 public static int factorial_recursive(int n) {
		 if (n == 0) {
			 return 1;
		 }
		 else {
			 return n * factorial_recursive(n-1);
		 }
	 }
	 
	 /* Integers#
	  * fibonacci_iterative calculates the sum of a fibonacci number in an 
	  * iterative manner. Such that fn = fn-1 + fn-2 where the base case f1,f2 = 1.
	  * 
	  * Fibonacci sequence: 1,1,2,3,5,8,13,21,34,55,89,144
	  */
	 public static int fibonacci_iterative(int n) {
		 int fib1 = 1;
		 int fib2 = 1;
		 int fibn = 0;
		 
		 if (n == 0 || n == 1) {
			 return 1;
		 }
		 for (int i = 2; i <= n; i++) {
			 fibn = fib2 + fib1;
			 fib1 = fib2;
			 fib2 = fibn;
		 }
		 return fibn;		  
	 }
	 
	 /* Recursive# Integers#
	  * fibonacci_iterative calculates the sum of a fibonacci number in an 
	  * recursive manner. Such that fn = fn-1 + fn-2 where the base case f1,f2 = 1.
	  * 
	  * Considering bigger numbers of n, this algorithm becomes highly inefficient 
	  * as it forms a tree like structure during execution and performs calculations
	  * in several branches at a time (2^n) which increases time complexity. 
	  * 
	  * Fibonacci sequence: 1,1,2,3,5,8,13,21,34,55,89,144,233 (starting on index 0)
	  */
	 public static int fibonacci_recursive(int n) {
		 if (n == 0 || n == 1) {
			 return 1;
		 }
		 return fibonacci_recursive(n-1) + fibonacci_recursive(n-2);
	  
	 }
}
