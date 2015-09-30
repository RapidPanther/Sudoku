package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	public SudokuVerifier(){
		
	}
	
	
	
	public int verify(String candidateSolution) {
		int numbers[] = changeStringToIntArray(candidateSolution);
		
		
		//check if String is correct
		
		//check rule one
		
		if(!checkRuleOne(candidateSolution)){
			return  -1;
		}
		
		if(!checkRuleTwo(candidateSolution)){
			return -2;
		}
		
		
		
		
		
		
		// returns 1 if the candidate solution is correct
		return 0;
	}
	
	public boolean checkRuleOne(String input) {
		if(input.matches("[0-9]{81}"))
		{
			return true;
		}
		return false;
	}

	public int[] changeStringToIntArray(String sudokuSolution) {
		char numbersChar[] = sudokuSolution.toCharArray(); 
		
		int numbers[] = new int[81];
		
		for(int i = 0; i < numbers.length; i++)
		{
			numbers[i] = Character.getNumericValue(numbersChar[i]);
			//System.out.print(numbers[i]);
		}
		
		return numbers;
	}



	public boolean checkRuleTwo(String string) {
		int numbers[] = changeStringToIntArray(string);
		return true;
	}
	
	
}
