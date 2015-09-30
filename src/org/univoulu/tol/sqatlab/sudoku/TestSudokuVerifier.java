package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSudokuVerifier {

	String correctSudoku ="417369825632158947958724316825437169791586432346912758289643571573291684164875293";	

	@Test
	public void testChangeStringToIntArray() {
		int[] numbers = SudokuVerifier.changeStringToIntArray(correctSudoku);
		
		assertEquals(numbers[0], 4);
		assertEquals(numbers[1], 1);
		assertEquals(numbers[2], 7);
		assertEquals(numbers[80], 3);
	}

}
