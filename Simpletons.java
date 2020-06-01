package Java_algoRhythms;

public class Simpletons {
	
	/* 
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
//		if (n < 0) // do a try-catch for this or throw exception
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
		 * We need to now split delta into 2 "equals" parts; if value is in lower range then we shift right, otherwise 
		 * shift left. Algorithm is more efficient if the full range is split into multiple parts. 
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

}
