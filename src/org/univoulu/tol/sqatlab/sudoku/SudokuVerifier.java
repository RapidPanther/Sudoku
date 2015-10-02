package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	public SudokuVerifier(){
		
	}

	public int verify(String candidateSolution) {
		if(!checkRuleOne(candidateSolution))
		{
			return -1;
		}
		if(!checkRuleTwo(candidateSolution))
		{
			return -2;
		}
		if(!checkRuleThree(candidateSolution))
		{
			return -3;
		}
		if(!checkRuleFour(candidateSolution))
		{
			return -4;
		}
		
		return 0;
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
				//System.out.print(numbers[j][i]);
			}	
		}
		
		return numbers;
	}

	public boolean checkNineDigits(int[] test) {
		int[] correctValues = {1,2,3,4,5,6,7,8,9};
		
		for (int i: correctValues)
		{
			boolean isThere = false;
			for(int j = 0; j < test.length; j++)
			{
				if(i == test[j])
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
	
	//R1: A cell in a Sudoku game can only store positive digits, i.e. 1...9.
	public boolean checkRuleOne(String input) {
		if(input.matches("[0-9]{81}"))
		{
			return true;
		}
		return false;
	}
	
	//R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
	public boolean checkRuleTwo(String string) {
		
		int numbers[][] = changeStringToTwoDimensionalIntArray(string);
		int[] digit = new int[9];
		
		int counter = 0;
		int digitCounterX = 0;
		int digitCounterY = 0;
		int xValue = 0;
		int yValue = 0;
		
		while(digitCounterX < 2 && digitCounterY < 2)
		{		
			counter = 0;
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					xValue = i + digitCounterX * 3;
					yValue = j + digitCounterY * 3;
					System.out.print("  xValue " + xValue);
					System.out.print("  yValue " + yValue);
					
					digit[counter] = numbers[xValue][yValue];
					System.out.println(" counter: " + counter);
					counter++;
				}
			}
			
			if(!checkNineDigits(digit))
			{
				return false;
			}
			
			digitCounterY++;
			if(digitCounterY > 2)
			{
				digitCounterY = 0;
				digitCounterX++;
			}
			
			System.out.println("next round");
			System.out.println("digitCounterX: " + digitCounterX);
			System.out.println("digitCounterY: " + digitCounterY);
		}
		/*
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++){
				digit[counter] = numbers[i][j];
				System.out.println(digit[counter] + " " + counter);
				counter++;
			}
		}
		*/
		/*
		for(int i : digit)
		{
			System.out.print(i);
		}
		System.out.println();
		*/
		
		
		
		
		return true;
	}

	//R3: A digit can appear only once in the rows of the global grid.
	public boolean checkRuleThree(String test) {
		int numbers[] = changeStringToIntArray(test);		
		int[] digit = new int[9]; 	
		
		for(int i = 0; i < numbers.length; i++)
		{
			digit[i%9] = numbers[i];
			if(i%9 == 8){
				if(!checkNineDigits(digit)){
					return false;
				}
			}
		}
		return true;
	}
	
	//R4: A digit can appear only once in the columns of the global grid.
	public boolean checkRuleFour(String test) {
		int numbers[][] = changeStringToTwoDimensionalIntArray(test);
		
		for(int i= 0; i <9; i++)
		{
			int[] digit = new int[9];
			for(int j = 0; j <9; j++)
			{
				digit[j] = numbers[j][i];
				//System.out.print(digit[j]);
			}
			if(!checkNineDigits(digit)){
				return false;
			}
			//System.out.println();
		}
		return true;
	}
}
