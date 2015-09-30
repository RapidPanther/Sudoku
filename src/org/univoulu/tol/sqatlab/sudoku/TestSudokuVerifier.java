package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSudokuVerifier {

	SudokuVerifier sudokuVerifier;
	String correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";	
	String wrongSudoku = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	String failRuleOne = "-417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	String failRuleTwo = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
	
	@Test
	public void testChangeStringToIntArray() {
		sudokuVerifier = new SudokuVerifier();
		int[] numbers = sudokuVerifier.changeStringToIntArray(correctSudoku);
		
		assertEquals(numbers[0], 4);
		assertEquals(numbers[1], 1);
		assertEquals(numbers[2], 7);
		assertEquals(numbers[80], 3);
	}
	
	@Test
	public void testVerify_CorrectString_ReturnsZero(){
		sudokuVerifier = new SudokuVerifier();
		int validity = sudokuVerifier.verify(correctSudoku);
		assertEquals(0, validity);
	}
	
	
	@Test
	public void testVerify_WrongString_ReturnsMinusOne(){
		sudokuVerifier = new SudokuVerifier();
		int validity = sudokuVerifier.verify(failRuleOne);
		assertEquals(-1, validity);
	}
	
	
	@Test
	public void testCheckRuleOne_CorrectStringReturnTrue(){
		sudokuVerifier = new SudokuVerifier();
		assertEquals(true, sudokuVerifier.checkRuleOne(correctSudoku));
	}
	
	@Test
	public void testCheckRuleTwo_CorrectSolutionReturnTrue(){
		sudokuVerifier = new SudokuVerifier();
		assertEquals(true, sudokuVerifier.checkRuleTwo(correctSudoku));
	}
	
	/*
	@Test
	public void testCheckRuleTwo_IncorrectSolutionReturnFalse(){
		sudokuVerifier = new SudokuVerifier();
		assertEquals(false, sudokuVerifier.checkRuleTwo(failRuleTwo));
	}
	*/
	
	@Test
	public void testCheckNineDigits_OneToNineReturnTrue(){
		sudokuVerifier = new SudokuVerifier();
		int[] test = {1,2,3,4,5,6,7,8,9};
		assertEquals(true, sudokuVerifier.checkNineDigits(test));
	}
	
	@Test
	public void testCheckNineDigits_NotOneToNineReturnFalse(){
		sudokuVerifier = new SudokuVerifier();
		int[] test = {2,2,3,4,5,6,7,8,8};
		assertEquals(false, sudokuVerifier.checkNineDigits(test));
	}
	
}
