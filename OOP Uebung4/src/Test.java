class Test {
    public static void main(String[] args) {
		//Box
		System.out.println("Box");
		System.out.println("----------");
		Box box = new Box(0.6, 0.6, 'x', 'o');
		System.out.println(box.toString());
		box.scale(2.0);
		System.out.println("----------");
		System.out.println(box.toString());
		box.scale(5.0);
		System.out.println("----------");
		System.out.println(box.toString());
		System.out.println();
	
		//ClearBox
		System.out.println("ClearBox");
		System.out.println("----------");
		ClearBox clearBox = new ClearBox(0.6, 0.6);
		System.out.println(clearBox.toString());
		System.out.println("Ratio: " + clearBox.getRatio());
		clearBox.scale(3.0);
		System.out.println("----------");
		System.out.println(clearBox.toString());
		System.out.println("Ratio: " + clearBox.getRatio());
		clearBox.scale(4.5);
		System.out.println("----------");
		System.out.println(clearBox.toString());
		System.out.println("Ratio: " + clearBox.getRatio());
		System.out.println();
	
		//DarkBox
		System.out.println("DarkBox");
		System.out.println("----------");
		DarkBox darkBox = new DarkBox(1.5, 2.5, 'O');
		System.out.println(darkBox.toString());
		darkBox.scale(3.0);
		darkBox.setBorder('X');
		System.out.println("----------");
		System.out.println(darkBox.toString());
		System.out.println();
	
		//FreeBox
		System.out.println("FreeBox");
		System.out.println("----------");
		FreeBox freeBox = new FreeBox("123\n123\nabc\nooo\n123");
		System.out.println(freeBox.toString());
		System.out.println("----------");
		freeBox.scale(1.5);
		System.out.println(freeBox.toString());
		System.out.println("----------");
		//scale back
		freeBox.scale(0.5);
		System.out.println(freeBox.toString());
		System.out.println("----------");
		freeBox.scale(0.5);
		System.out.println(freeBox.toString());
		System.out.println("----------");
		//scale back
		freeBox.scale(2.0);
		System.out.println(freeBox.toString());
		System.out.println();
	
		//Repeated
		System.out.println("Repeated");
		System.out.println("----------");
		String[][] test = { {"hello","test", "xyz"}, {"hello2", "test2", "..."}, {"123", "abc", "'''"} };
		Repeated<String> repeatedString = new Repeated<String>(test);
		System.out.println(repeatedString.toString());
		System.out.println("----------");
		repeatedString.scale(3.5);
		System.out.println(repeatedString.toString());
		System.out.println("----------");
		DarkBox[][] darkBoxTest1 = { {darkBox} };
		Repeated<DarkBox> repeatedDarkBox1 = new Repeated<DarkBox>(darkBoxTest1);
		System.out.println(repeatedDarkBox1.toString());
		System.out.println("----------");
		DarkBox darkBox1 = new DarkBox(2.0, 2.0, 'O');
		DarkBox darkBox2 = new DarkBox(1.0, 3.0, 'X');
		DarkBox darkBox3 = new DarkBox(3.0, 5.0, 'I');
		DarkBox[][] darkBoxTest = { {darkBox1, darkBox2}, {darkBox2, darkBox3} };
		Repeated<DarkBox> repeatedDarkBox = new Repeated<DarkBox>(darkBoxTest);
		System.out.println(repeatedDarkBox.toString());
		System.out.println("----------");
		ClearBox[][] clearBoxTest = { {clearBox, clearBox}, {clearBox, clearBox} };
		Repeated<ClearBox> repeatedClearBox = new Repeated<ClearBox>(clearBoxTest);
		System.out.println(repeatedClearBox.toString());
		System.out.println("----------");
		repeatedClearBox.scale(2.0);
		System.out.println(repeatedClearBox.toString());
		System.out.println("----------");
		repeatedClearBox.scale(0.1);
		System.out.println(repeatedClearBox.toString());
		System.out.println();
		
		//Scaled
		System.out.println("Scaled");
		System.out.println("----------");
		ClearBox[][] clearBoxScale = { {clearBox}, {clearBox} };
		Scaled<ClearBox> scaledClearBox = new Scaled<ClearBox>(clearBoxScale);
		System.out.println(scaledClearBox.toString());
		System.out.println("----------");
		//clearBoxScale is filled multiple times with the same object
		//remember that the same object is scaled multiple times
		scaledClearBox.scale(2.0);
		System.out.println(scaledClearBox.toString());
	
		//FreeBox < Box
		System.out.println("FreeBox < Box");
		System.out.println("----------");
		FreeBox freeBox1 = new Box(3, 4, 'a', 'b');
		System.out.println(freeBox1.toString());
		System.out.println("----------");
		freeBox1.scale(2.0);
		System.out.println(freeBox1.toString());
		System.out.println();
		
		//Box < ClearBox
		System.out.println("Box < ClearBox");
		System.out.println("----------");
		Box clearBox1 = new ClearBox(4, 3);
		System.out.println(clearBox1.toString());
		System.out.println("----------");
		clearBox1.scale(2.0);
		System.out.println(clearBox1.toString());
		System.out.println();
		
		//FreeBox < ClearBox
		System.out.println("FreeBox < ClearBox");
		System.out.println("----------");
		FreeBox freeBox2 = new ClearBox(6, 4);
		System.out.println(freeBox2.toString());
		System.out.println("----------");
		freeBox2.scale(2.0);
		System.out.println(freeBox2.toString());
		System.out.println();
		
		//FreeBox < Repeated<String>
		System.out.println("FreeBox < Repeated<String>");
		System.out.println("----------");
		FreeBox freeBox3 = new Repeated<String>(test);
		System.out.println(freeBox3.toString());
		System.out.println("----------");
		freeBox3.scale(2.0);
		System.out.println(freeBox3.toString());
		System.out.println();
		
		//FreeBox < Repeated<DarkBox>
		System.out.println("FreeBox < Repeated<DarkBox>");
		System.out.println("----------");
		FreeBox freeBox4 = new Repeated<DarkBox>(darkBoxTest);
		System.out.println(freeBox4.toString());
		System.out.println("----------");
		freeBox4.scale(1.3);
		System.out.println(freeBox4.toString());
		
		
    }
}
/**
 * Box child of?
 * ClearBox, NO -> weaker invariants
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, YES
 * Repeated<Char>, YES
 * Repeated<P>, YES
 * Repeated<Box>, YES
 * Repeated<ClearBox>, YES
 * Repeated<DarkBox>, YES
 * Repeated<FreeBox>, YES
 * Repeated<Repeated<P>>, YES
 * Repeated<Scaled<P>>, YES
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, -> NO different functionality in scale(..)
 * Scaled<Scaled<P>>, -> NO different functionality in scale(..)
 */



/** 
 * ClearBox child of?
 * Box, YES
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, YES
 * Repeated<Char>, YES
 * Repeated<P>, YES
 * Repeated<Box>, YES
 * Repeated<ClearBox>, YES
 * Repeated<DarkBox>, YES
 * Repeated<FreeBox>, YES
 * Repeated<Repeated<P>>, YES
 * Repeated<Scaled<P>>, YES
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, -> NO different functionality in scale(..)
 */


/** 
 * DarkBox child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox, NO -> weaker invariants and postconditions
 * FreeBox, NO, -> weaker invariants
 * Repeated<Char>, NO -> weaker invariants 
 * Repeated<P>, NO, -> weaker invariants 
 * Repeated<Box>, NO, -> weaker invariants 
 * Repeated<ClearBox>, NO -> weaker invariants 
 * Repeated<DarkBox>, NO -> weaker invariants 
 * Repeated<FreeBox>, NO -> weaker invariants 
 * Repeated<Repeated<P>>, NO -> weaker invariants 
 * Repeated<Scaled<P>>, NO -> weaker invariants 
 * Scaled<P>, NO -> weaker invariants, different functionality in scale(..)
 * Scaled<Box>, NO -> weaker invariants, different functionality in scale(..) 
 * Scaled<ClearBox>, NO -> weaker invariants, different functionality in scale(..) 
 * Scaled<DarkBox>, NO -> weaker invariants, different functionality in scale(..) 
 * Scaled<FreeBox>, NO -> weaker invariants, different functionality in scale(..) 
 * Scaled<Repeated<P>>, NO -> weaker invariants, different functionality in scale(..) 
 * Scaled<Scaled<P>>, NO -> weaker invariants, different functionality in scale(..)
 */



/** 
 * FreeBox child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox,  NO -> weaker invariants and postconditions
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * Repeated<Char>, EQUIVALENT
 * Repeated<P>, EQUIVALENT
 * Repeated<Box>, EQUIVALENT
 * Repeated<ClearBox>, EQUIVALENT
 * Repeated<DarkBox>, EQUIVALENT
 * Repeated<FreeBox>, EQUIVALENT
 * Repeated<Repeated<P>>, EQUIVALENT
 * Repeated<Scaled<P>>, EQUIVALENT
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, NO -> different functionality in scale(..)
 */ 


/** 
 * Repeated<Char> child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox, NO -> weaker invariants and postconditions
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, EQUIVALENT
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, NO -> different functionality in scale(..)
 */

/** 
 * Repeated<P> child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox, NO -> weaker invariants and postconditions
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, EQUIVALENT
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, NO -> different functionality in scale(..)
 */

/** 
 * Repeated<Box> child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox, NO -> weaker invariants and postconditions
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, EQUIVALENT
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, NO -> different functionality in scale(..)
 */

/** 
 * Repeated<ClearBox> child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox, NO -> weaker invariants and postconditions
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, EQUIVALENT
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, NO -> different functionality in scale(..)
 */

/** 
 * Repeated<DarkBox> child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox, NO -> weaker invariants and postconditions
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, EQUIVALENT
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, NO -> different functionality in scale(..)
 */

/** 
 * Repeated<FreeBox> child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox, NO -> weaker invariants and postconditions
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, EQUIVALENT
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, NO -> different functionality in scale(..)
 */
 
/** 
 * Repeated<Repeated<P>> child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox, NO -> weaker invariants and postconditions
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, EQUIVALENT
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, NO -> different functionality in scale(..)
 */
 
/** 
 * Repeated<Scaled<P>> child of?
 * Box, NO -> weaker invariants and postconditions
 * ClearBox, NO -> weaker invariants and postconditions
 * DarkBox, NO -> because the method setContent of DarkBox violates a invariant
 * FreeBox, EQUIVALENT
 * Scaled<P>, NO -> different functionality in scale(..)
 * Scaled<Box>, NO -> different functionality in scale(..)
 * Scaled<ClearBox>, NO -> different functionality in scale(..)
 * Scaled<DarkBox>, NO -> different functionality in scale(..)
 * Scaled<FreeBox>, NO -> different functionality in scale(..)
 * Scaled<Repeated<P>>, NO -> different functionality in scale(..)
 * Scaled<Scaled<P>>, NO -> different functionality in scale(..)
 */

/**
 * Scaled<P> child of?
 * Box, NO -> different functionality in scale(..)
 * ClearBox, NO -> different functionality in scale(..)
 * DarkBox, NO -> different functionality in scale(..)
 * FreeBox, NO -> different functionality in scale(..)
 * Repeated<Char>, NO -> different functionality in scale(..)
 * Repeated<P>, NO -> different functionality in scale(..)
 * Repeated<Box>, NO -> different functionality in scale(..)
 * Repeated<ClearBox>, NO -> different functionality in scale(..)
 * Repeated<DarkBox>, NO -> different functionality in scale(..)
 * Repeated<FreeBox>, NO -> different functionality in scale(..)
 * Repeated<Repeated<P>>, NO -> different functionality in scale(..)
 * Repeated<Scaled<P>>, NO -> different functionality in scale(..)
 */

/** 
 * Scaled<Box> child of?
 * Box, NO -> different functionality in scale(..)
 * ClearBox, NO -> different functionality in scale(..)
 * DarkBox, NO -> different functionality in scale(..)
 * FreeBox, NO -> different functionality in scale(..)
 * Repeated<Char>, NO -> different functionality in scale(..)
 * Repeated<P>, NO -> different functionality in scale(..)
 * Repeated<Box>, NO -> different functionality in scale(..)
 * Repeated<ClearBox>, NO -> different functionality in scale(..)
 * Repeated<DarkBox>, NO -> different functionality in scale(..)
 * Repeated<FreeBox>, NO -> different functionality in scale(..)
 * Repeated<Repeated<P>>, NO -> different functionality in scale(..)
 * Repeated<Scaled<P>>, NO -> different functionality in scale(..)
 */

/** 
 * Scaled<ClearBox> child of?
 * Box, NO -> different functionality in scale(..)
 * ClearBox, NO -> different functionality in scale(..)
 * DarkBox, NO -> different functionality in scale(..)
 * FreeBox, NO -> different functionality in scale(..)
 * Repeated<Char>, NO -> different functionality in scale(..)
 * Repeated<P>, NO -> different functionality in scale(..)
 * Repeated<Box>, NO -> different functionality in scale(..)
 * Repeated<ClearBox>, NO -> different functionality in scale(..)
 * Repeated<DarkBox>, NO -> different functionality in scale(..)
 * Repeated<FreeBox>, NO -> different functionality in scale(..)
 * Repeated<Repeated<P>>, NO -> different functionality in scale(..)
 * Repeated<Scaled<P>>, NO -> different functionality in scale(..)
 */

/** 
 * Scaled<DarkBox> child of?
 * Box, NO -> different functionality in scale(..)
 * ClearBox, NO -> different functionality in scale(..)
 * DarkBox, NO -> different functionality in scale(..)
 * FreeBox, NO -> different functionality in scale(..)
 * Repeated<Char>, NO -> different functionality in scale(..)
 * Repeated<P>, NO -> different functionality in scale(..)
 * Repeated<Box>, NO -> different functionality in scale(..)
 * Repeated<ClearBox>, NO -> different functionality in scale(..)
 * Repeated<DarkBox>, NO -> different functionality in scale(..)
 * Repeated<FreeBox>, NO -> different functionality in scale(..)
 * Repeated<Repeated<P>>, NO -> different functionality in scale(..)
 * Repeated<Scaled<P>>, NO -> different functionality in scale(..)
 */

/** 
 * Scaled<FreeBox> child of?
 * Box, NO -> different functionality in scale(..)
 * ClearBox, NO -> different functionality in scale(..)
 * DarkBox, NO -> different functionality in scale(..)
 * FreeBox, NO -> different functionality in scale(..)
 * Repeated<Char>, NO -> different functionality in scale(..)
 * Repeated<P>, NO -> different functionality in scale(..)
 * Repeated<Box>, NO -> different functionality in scale(..)
 * Repeated<ClearBox>, NO -> different functionality in scale(..)
 * Repeated<DarkBox>, NO -> different functionality in scale(..)
 * Repeated<FreeBox>, NO -> different functionality in scale(..)
 * Repeated<Repeated<P>>, NO -> different functionality in scale(..)
 * Repeated<Scaled<P>>, NO -> different functionality in scale(..)
 */
 
/** 
 * Scaled<Repeated<P>> child of?
 * Box, NO -> different functionality in scale(..)
 * ClearBox, NO -> different functionality in scale(..)
 * DarkBox, NO -> different functionality in scale(..)
 * FreeBox, NO -> different functionality in scale(..)
 * Repeated<Char>, NO -> different functionality in scale(..)
 * Repeated<P>, NO -> different functionality in scale(..)
 * Repeated<Box>, NO -> different functionality in scale(..)
 * Repeated<ClearBox>, NO -> different functionality in scale(..)
 * Repeated<DarkBox>, NO -> different functionality in scale(..)
 * Repeated<FreeBox>, NO -> different functionality in scale(..)
 * Repeated<Repeated<P>>, NO -> different functionality in scale(..)
 * Repeated<Scaled<P>>, NO -> different functionality in scale(..)
 */
 
/** 
 * Scaled<Scaled<P>> child of?
 * Box, NO -> different functionality in scale(..)
 * ClearBox, NO -> different functionality in scale(..)
 * DarkBox, NO -> different functionality in scale(..)
 * FreeBox, NO -> different functionality in scale(..)
 * Repeated<Char>, NO -> different functionality in scale(..)
 * Repeated<P>, NO -> different functionality in scale(..)
 * Repeated<Box>, NO -> different functionality in scale(..)
 * Repeated<ClearBox>, NO -> different functionality in scale(..)
 * Repeated<DarkBox>, NO -> different functionality in scale(..)
 * Repeated<FreeBox>, NO -> different functionality in scale(..)
 * Repeated<Repeated<P>>, NO -> different functionality in scale(..)
 * Repeated<Scaled<P>>, NO -> different functionality in scale(..)
 */
