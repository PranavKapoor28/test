package edu.neu.csye6200;

import java.util.Arrays;
import java.util.Collections;

/**
 * 100 TOTAL POINTS FINAL EXAM
 * 
 * DEDUCTIONS: 40 POINTS DEDUCTED IF LATE or incorrectly submitted 20 POINTS
 * DEDUCTED IF INCORRECT OUTPUT 20 POINTS DEDUCTED IF NOT using Threads as
 * specified 20 POINTS DEDUCTED IF NOT COORDINATING and managing Threads
 * correctly 10 POINTS DEDUCTED IF NOT using Enum
 * 
 * REQUIREMENTS (Monday CSYE6200 03 CRN 13768):
 * 
 * output to console (stdout) ALL SUPPLIED K_A_CHAR_DATA (in SPECIFIC alphabetic
 * order NO EXTRA SPACES):
 * 
 * lower case letter (a) followed by upper case letter (A)
 * 
 * for example: aAbBcC ... yYzZ
 *
 * THEN REPEAT 2nd time BUT, in REVERSE alphabetic order: for example: zZyY...
 * cCbBaA
 *
 * THEN REPEAT 3rd time, again in alphabetic order: for example: aAbBcC ... yYzZ
 * 
 * USING: Enum (enumerated type) coordinated threads that take turns ALTERNATING
 * output: - Thread #1 lowerCaseThread outputs only lower case letter - Thread
 * #2 upperCaseThread outputs only upper case letter
 * 
 * @author dpeters
 *
 */
public class AlphaNumbers {
	
	Enum status = Status.True;
	
	enum Status {
		  True,
		  False
	}

	public static boolean lowerStatus = true;
	public static final int MAJOR_VERSION = 5;
	public static final int MINOR_VERSION = 0;
	public static final String REVISION = Integer.valueOf(MAJOR_VERSION) + "." + Integer.valueOf(MINOR_VERSION);
	/**
	 * supplies data for all threads
	 * 
	 * @author dpeters
	 *
	 */
	public final static Character[] K_A_CHAR_DATA = { Character.valueOf('c'), Character.valueOf('a'),
			Character.valueOf('b'), Character.valueOf('f'), Character.valueOf('e'), Character.valueOf('d'),
			Character.valueOf('z'), Character.valueOf('j'), Character.valueOf('i'), Character.valueOf('m'),
			Character.valueOf('n'), Character.valueOf('o'), Character.valueOf('g'), Character.valueOf('p'),
			Character.valueOf('l'), Character.valueOf('u'), Character.valueOf('k'), Character.valueOf('y'),
			Character.valueOf('s'), Character.valueOf('t'), Character.valueOf('r'), Character.valueOf('v'),
			Character.valueOf('w'), Character.valueOf('x'), Character.valueOf('h'), Character.valueOf('q') };

	/**
	 * STUDENT TODO: LOWERCASE char to console (stdout)
	 */
	private void outCharLowerCase(int ptr) {

		System.out.print(K_A_CHAR_DATA[ptr]);
	}

	/**
	 * STUDENT TODO: UPPERCASE char to console stdout
	 */
	private void outCharUpperCase(int ptr) {

		System.out.print(Character.toUpperCase(K_A_CHAR_DATA[ptr]));
	}

	/**
	 * STUDENT TODO: execute coordinated threads
	 */
	private void execute() {
		
		System.out.println();

		Runnable lowerPrinter = () -> {
			int ptr = 0;
			while (true) {
				if (status == Status.True) {
					outCharLowerCase(ptr++);
					status = Status.False;
				}
				if (ptr >= K_A_CHAR_DATA.length) {
					break;
				}
			}
		};
		
		Runnable upperPrinter = () -> {
			int ptr = 0;
			while (true) {
				if (status == Status.False) {
					outCharUpperCase(ptr++);
					status = Status.True;
				}
				if (ptr >= K_A_CHAR_DATA.length) {
					break;
				}
			}
		};

		/**
		 * STUDENT TODO: start Threads
		 */
		Thread threadForLower = new Thread(lowerPrinter);

		Thread threadForUpper = new Thread(upperPrinter);

		System.out.println("2 threads created, printing lowercase in one and uppercase in the other:");
		threadForLower.start();
		threadForUpper.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");

		System.out.println();
	}

	/**
	 * STUDENT TODO: (uppercase, lowercase) REQUIREMENTS (Monday CSYE6200 03 CRN
	 * 13768):
	 */
	private static void demoSolutionMondayCSYE6200_03_13768() {
		System.out.println(AlphaNumbers.class.getSimpleName() + " REQUIREMENTS (Monday CSYE6200 03 CRN 13768)");
		/**
		 */
		AlphaNumbers obj = new AlphaNumbers();

		Arrays.sort(obj.K_A_CHAR_DATA);

		obj.execute();
		
		Arrays.sort(obj.K_A_CHAR_DATA, Collections.reverseOrder());
		
		obj.execute();
		
		Arrays.sort(obj.K_A_CHAR_DATA);
		
		obj.execute();

//		Character[] inputArr = obj.K_A_CHAR_DATA;

//	    Arrays.stream(obj.K_A_CHAR_DATA).forEach(a -> System.out.println(a));

//	    Arrays.stream(obj.K_A_CHAR_DATA).forEach(a -> System.out.println(a));

		/**
		 * STUDENT TODO: output in alphabetical order
		 */

		// 1.Sort the character array in alphabetical order

		/**
		 * STUDENT TODO: output in reverse alphabetical order
		 */

		/**
		 * STUDENT TODO: output in alphabetical order again
		 */

	}

	/**
	 * demonstrate use of this class
	 */
	public static void demo() {
		demoSolutionMondayCSYE6200_03_13768(); // STUDENT TODO:
	}
}
