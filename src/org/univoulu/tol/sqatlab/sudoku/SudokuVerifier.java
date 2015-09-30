package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public int verify(String candidateSolution) {
		//check if String is correct
		
		
		
		
		// returns 1 if the candidate solution is correct
		return 0;
	}
	
	public static int[] changeStringToIntArray(String sudokuSolution) {
		char numbersChar[] = sudokuSolution.toCharArray(); 
		
		int numbers[] = new int[81];
		
		for(int i = 0; i < numbers.length; i++)
		{
			numbers[i] = Character.getNumericValue(numbersChar[i]);
			//System.out.print(numbers[i]);
		}
		
		return numbers;
	}
	
	
}
