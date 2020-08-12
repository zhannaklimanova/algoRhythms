package Java_Rhythms;

import java.util.Arrays;

public class SimpletonsTester {

	public static void main(String[] args) {
		// positionFinder Tester
//		System.out.println(Simpletons.positionFinder(1, 11, 4, 0)); // returns 2
//		System.out.println(Simpletons.positionFinder(1, 3, 4, 0)); // returns 4
//
		// charRightShift Tester 
//		System.out.println(Simpletons.charRightShift('g', 2)); // returns 'i'
//		System.out.println(Simpletons.charRightShift('#', 2)); // returns '#'
//		System.out.println(Simpletons.charRightShift('z', 27)); // returns 'a'
//		System.out.println(Simpletons.charRightShift('g', -2)); // throws an exceptions
//		System.out.println(Simpletons.charRightShift('G', 2)); // returns 'G'
		
		// testInput Tester
//		System.out.println(Simpletons.testInput("bunny"));
//		System.out.println(Simpletons.testInput("turtle"));
		
		// testInput 2 Tester
//		System.out.println(Simpletons.testInput("pumpkin", 0));
//		System.out.println(Simpletons.testInput("pumpkin", 1));
		
		// findLargestValue Tester
//		int[] array = {3, 100, 25, 7, 800, 20000};
//		int[] nullArray = null;
//		System.out.println(Simpletons.findLargestValue(nullArray));
		
		// isPrime Tester 
//		System.out.println("prime " + Simpletons.isPrime(2));
//		System.out.println("prime " + Simpletons.isPrime(19));
//		System.out.println("prime " + Simpletons.isPrime(97));
//		System.out.println("prime " + Simpletons.isPrime(6));
//		System.out.println("prime " + Simpletons.isPrime(80));
//		System.out.println("prime " + Simpletons.isPrime(100));
		
		// findPrimes Tester
//		System.out.println((Arrays.toString(Simpletons.findPrimes(5)))); // returns [2, 3, 5, 7, 11]
	
		// shiftByOne Tester
//		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,1666666};
//	    System.out.println((Arrays.toString(Simpletons.shiftByOne(array)))); // returns [1666666, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
	
		// shiftByOne2 Tester
//		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,1666666};
//	    System.out.println((Arrays.toString(Simpletons.shiftByOne2(array)))); // returns [1666666, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
		
		// increaseSize Tester
//		int[] test2 = {2,2,4,5,9,1,3};
//		System.out.println(Simpletons.increaseSize(test2).length); // returns 6 
		
		// intersection Tester 
//		int[] array = {2,2,4,5,9,1,3};
//		int[] array2 = {3,2,4,5,10,1,4,};
//		int[] a = {1,2,3,4}; 
//		int[] b = {4,3,2,1};
//		System.out.println(Arrays.toString(Simpletons.intersection(array, array2))); // returns {2,4,5,1,3}
//		System.out.println(Arrays.toString(Simpletons.intersection(a, b)));
		
		// isUpperCase Tester
//		char c = 'L';
//		char q = 'A';
//		char i = 'z';
//		System.out.println(Simpletons.isUpperCase(c)); // returns true
//		System.out.println(Simpletons.isUpperCase(q)); // returns true
//		System.out.println(Simpletons.isUpperCase(i)); // returns false 
		
		// countUpper Tester
//		String myString = "HELLO";
//		System.out.println(Simpletons.countUpper(myString)); // returns 5
		
		// toLowerCase Tester
//		String string = "HELLO";
//		System.out.println(Simpletons.toLowerCase(string));
		
		// randomGenerator Tester
//		Simpletons.randomGenerator();
//		Simpletons.randomSeedGenerator(1); // Outputs the same values every time until input seed is changed
		
		// isMatrix Tester
//		int[][] num1 = {{1,2,3}, {5,6}, {8}};
//		int[][] num2 = {{2,2}, {0,6}, {8,9}}; 
//		System.out.println(Simpletons.isMatrix(num1)); // returns false
//		System.out.println(Simpletons.isMatrix(num2)); // returns true
		
		// getColumn Tester
//		int[][] matrix = {{2,3}, {5,6}, {8,9}};
//		System.out.println(Arrays.toString(Simpletons.getColumn(matrix, -2))); // returns {2,5,8}
		 
		// sumMatrix Tester 
//		int[][] matrix1 = {{2,3}, {5,1}};
//		int[][] matrix2 = {{-1,5}, {2,-4}};
//		int[][] badMatrix1 = {{2,3,4}, {5,1,3}};
//		int[][] badMatrix2 = {{-1,5}, {2,-4}};
//		int[][] kk = {{0,0}, {0,0}, {0,0}};
//		int[][] jj = {{0,0}, {0,0}, {0,0}};
//		System.out.println(Arrays.deepToString(Simpletons.sumMatrix(matrix1, matrix2))); // returns {{1,8}, {7,-3}}
//		System.out.println(Arrays.deepToString(Simpletons.sumMatrix(kk,jj)));

		// dotProduct Tester
//		int[] matx1 = {2,4,1}; 
//		int[] matx2 = {1,5,9}; 
//		System.out.println(Simpletons.dotProduct(matx1, matx2)); // returns 31
		
		// multiplyMatrix Tester 
//		int[][] a = {{1,4,6,10},{2,7,5,3}};
//		int[][] b = {{1,4,6},{2,7,5},{9,0,11},{3,1,0}};
//		int[][] test1 = {{1,2,3}, {4,5,6}};
//		int[][] test2 = {{6,3}, {5,2}, {4,1}};
//		int[][] zero1 = {{0,0}, {0,0}};
//		int[][] zero2 = {{0,0}, {0,0}};
//		System.out.println(Arrays.deepToString(Simpletons.multiplyMatrix(test1, test2)));
//		System.out.println(Arrays.deepToString(Simpletons.multiplyMatrix(a, b)));
//		System.out.println(Arrays.deepToString(Simpletons.multiplyMatrix(zero1, zero2)));
		
		// reverse Tester
//		int[] a = {1, 2, 3, 4};
//		int[] b = {6,5,4,3,2,1,0};
//		System.out.println(Arrays.toString(Simpletons.reverse(a)));
//		System.out.println(Arrays.toString(Simpletons.reverse(b)));
		
		// remove Tester 
//		int[] i = {1,2,3,4,5};
//		int[] j = {1,2,3,4,5};
//		System.out.println(Arrays.toString(Simpletons.remove(i, 2))); // returns 1,3,4,5
//		System.out.println(Arrays.toString(Simpletons.remove(j, 5))); // returns 1,2,3,4
		
		// add Tester
//		int[] u = {1,2,3,4,5};
//		System.out.println(Arrays.toString(Simpletons.add(u, 1, 99)));
//		System.out.println(Arrays.toString(Simpletons.add(u, 4, 99)));
		
		// addToEnd Tester 
//		int[] o = {1,2,3,4,5};
//		System.out.println((Arrays.toString(Simpletons.addToEnd(o, 99))));
	
	}
	
}
