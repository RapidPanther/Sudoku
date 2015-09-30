package org.univoulu.tol.sqatlab.sudoku;

import java.util.Arrays;

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
	
	public int[][] changeStringToTwoDimensionalIntArray(String sudokuSolution) {
		char numbersChar[] = sudokuSolution.toCharArray(); 
		
		int numbers[][] = new int[9][9];
		int counter = 0;
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				numbers[i][j] = Character.getNumericValue(numbersChar[counter]);
				counter++;
				//System.out.print(numbers[i][j]);
			}	
			
			
		}
		
		return numbers;
	}



	public boolean checkRuleTwo(String string) {
		int numbers[][] = changeStringToTwoDimensionalIntArray(string);
		int[] digit = new int[9];
		
		
		
		
		
		
		return true;
	}



	public boolean checkNineDigits(int[] test) {
		int[] correctValues = {1,2,3,4,5,6,7,8,9};
		
		for (int i: correctValues)
		{
			boolean isThere = false;
			for(int j = 0; j < test.length; j++)
			{
				if(i == j)
				{
					isThere = true;
				}
			}
			if(!isThere){
				return false;
			}
		}
		
		return true;
	}
	
	
}
