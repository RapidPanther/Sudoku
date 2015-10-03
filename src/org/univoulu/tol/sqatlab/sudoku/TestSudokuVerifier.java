package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSudokuVerifier {
	
	SudokuVerifier sudokuVerifier;
	String correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";	
	String wrongSudoku = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	String failRuleOne = "-417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	String failRuleTwo = "417369825631258947958724316825437169791586432346912758289643571573291684164875293";
	String failRuleThree = "412369825637158947958724316825437169791586432346912758289643571573291684164875293";
	String failRuleFour = "147369825632158947958724316825437169791586432346912758289643571573291684164875293";
	
	
	@Test
	public void testChangeStringToIntArray() {
		sudokuVerifier = new SudokuVerifier();
		int[] numbers = sudokuVerifier.changeStringToIntArray(correctSudoku);
		
		assertEquals(4,numbers[0]);
		assertEquals(1, numbers[1]);
		assertEquals(7, numbers[2]);
		assertEquals(3, numbers[80]);
	}
	
	@Test
	public void testChangeStringToTwoDimensionalIntArray() {
		sudokuVerifier = new SudokuVerifier();
		int[][] numbers = sudokuVerifier.changeStringToTwoDimensionalIntArray(correctSudoku);
		
		assertEquals(1, numbers[0][1]);
		assertEquals(2, numbers[0][7]);
		assertEquals(6, numbers[1][0]);
		assertEquals(3, numbers[4][7]);
		assertEquals(4, numbers[5][1]);
		assertEquals(8, numbers[7][7]);
		assertEquals(3, numbers[8][8]);
	}
	
	
	@Test
	public void testVerify_CorrectString_ReturnsZero(){
		sudokuVerifier = new SudokuVerifier();
		int validity = sudokuVerifier.verify(correctSudoku);
		assertEquals(0, validity);
	}
	
	@Test
	public void testVerify_WrongStringRuleOne_ReturnsMinusOne(){
		sudokuVerifier = new SudokuVerifier();
		int validity = sudokuVerifier.verify(failRuleOne);
		assertEquals(-1, validity);
	}	
	
	@Test
	public void testVerify_WrongStringRuleTwo_ReturnsMinusTwo(){
		sudokuVerifier = new SudokuVerifier();
		int validity = sudokuVerifier.verify(failRuleTwo);
		assertEquals(-2, validity);
	}
	
	@Test
	public void testVerify_WrongStringRuleThree_ReturnsMinusThree(){
		sudokuVerifier = new SudokuVerifier();
		int validity = sudokuVerifier.verify(failRuleThree);
		assertEquals(-3, validity);
	}
	
	@Test
	public void testVerify_WrongStringRuleFour_ReturnsMinusFour(){
		sudokuVerifier = new SudokuVerifier();
		int validity = sudokuVerifier.verify(failRuleFour);
		assertEquals(-4, validity);
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
	
	@Test
	public void testCheckRuleTwo_IncorrectSolutionReturnFalse(){
		sudokuVerifier = new SudokuVerifier();
		assertEquals(false, sudokuVerifier.checkRuleTwo(failRuleTwo));
	}
	
	@Test
	public void testCheckRuleThree_CorrectSolutionReturnTrue(){
		sudokuVerifier = new SudokuVerifier();
		assertEquals(true, sudokuVerifier.checkRuleThree(correctSudoku));
	}
	
	@Test
	public void testCheckRuleThree_IncorrectSolutionReturnFalse(){
		sudokuVerifier = new SudokuVerifier();
		assertEquals(false, sudokuVerifier.checkRuleThree(failRuleThree));
	}
	
	@Test
	public void testCheckRuleFour_IncorrectSolutionReturnFalse(){
		sudokuVerifier = new SudokuVerifier();
		assertEquals(false, sudokuVerifier.checkRuleFour(failRuleFour));
	}
		 
	@Test
	public void testCheckRuleFour_CorrectSolutionReturnTrue(){
		sudokuVerifier = new SudokuVerifier();
		assertEquals(true, sudokuVerifier.checkRuleFour(correctSudoku));
	}
	
	@Test
	public void testCheckNineDigits_OneToNineReturnTrue(){
		sudokuVerifier = new SudokuVerifier();
		int[] test = {1,2,3,4,5,6,7,8,9};
		assertEquals(true, sudokuVerifier.checkNineDigits(test));
	}
	
	@Test
	public void testCheckNineDigits_NotOneToNineReturnFalse(){
		sudokuVerifier = new SudokuVerifier();
		int[] test = {1,2,3,4,5,6,7,8,8};
		assertEquals(false, sudokuVerifier.checkNineDigits(test));
	}
	
}
