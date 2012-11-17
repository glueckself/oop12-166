class Test {
    /* Box can not be child of Clearbox, because the invariants of Box are
     * weaker than the invariants of Clearbox */

    /* DarkBox can not be child of Box, because the invariants and postconditions
    * of DarkBox are weaker than the invariants and postconditions of Box */

    /* Box can not be child of DarkBox, because the method setContent of DarkBox
     * violates a invariant of Box */

    /* FreeBox can not be child of Box, because the postconditions of FreeBox
     * are weaker than the postconditions of Box */

    /* DarkBox can not be child of ClearBox, because the invariants and postconditions
    * of DarkBox are weaker than the invariants and postconditions of ClearBox */

    /* ClearBox can not be child of DarkBox, because the method setContent of DarkBox
     * violates a invariant of ClearBox */

    /* FreeBox can not be child of Clearbox, because the invariants of FreeBox
     * are weaker than the invariants of Clearbox */

    /* FreeBox can not be child of DarkBox, because the method setContent of DarkBox
     * violates a invariant of FreeBox */

    /* DarkBox can not be child of FreeBox, because the invariants of DarkBox
     * are weaker than the invariants of FreeBox */

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

	//Box < ClearBox
	System.out.println("Box < ClearBox");
	System.out.println("----------");
	Box clear = new ClearBox(1.5, 1.5);
	System.out.println(clear.toString());
	System.out.println();

	//DarkBox
	System.out.println("DarkBox");
	System.out.println("----------");
	DarkBox darkBox = new DarkBox(1.5, 2.5, 'O');
	System.out.println(darkBox.toString());
	darkBox.scale(3.0);
	darkBox.setContent('X');
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
    }
}
