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
}
