package Java_algoRhythms;

public class SimpletonsTester {

	public static void main(String[] args) {
		// positionFinder Tester
		System.out.println(Simpletons.positionFinder(1, 11, 4, 0)); // returns 2
		System.out.println(Simpletons.positionFinder(1, 3, 4, 0)); // returns 4

		// charRightShift Tester 
		System.out.println(Simpletons.charRightShift('g', 2)); // returns 'i'
		System.out.println(Simpletons.charRightShift('#', 2)); // returns '#'
		System.out.println(Simpletons.charRightShift('z', 27)); // returns 'a'
//		System.out.println(Simpletons.charRightShift('g', -2)); // throws an exceptions
	}

}
