package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	public SudokuVerifier(String sudokuSolution){
		
	}
	
	
	
	public int verify(String candidateSolution) {
		int numbers[] = changeStringToIntArray(candidateSolution);
		
		
		//check if String is correct
		
		//check rule one
		/*
		if(checkRuleOne(numbers)){
			return  -1;
		}
		*/
		
		//check rule two
		
		
		
		
		
		// returns 1 if the candidate solution is correct
		return 0;
	}
	
	public boolean checkRuleOne(String input) {
		if(input.matches(""))
		{
			return true;
		}
		return false;
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
