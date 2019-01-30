package euler;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int changeCount = 0;
        //How much does the top row cost?
        int costFirstRow = costOfRow(s, 0);
        
        if (costFirstRow != 15) {
            // Find minimum way of changing row
            changeCount += changeRow(s, 0);
        }
        int costSecondRow = costOfRow(s, 1);
        if (costSecondRow != 15) {
            // Find minimum way of changing row
            changeCount += changeRow(s, 1);
        }

        int costThirdRow = costOfRow(s, 2);
        if (costThirdRow != 15) {
            // Find minimum way of changing row
            changeCount += changeRow(s, 2);
        }
        return changeCount;
    }

    static int costOfRow(int[][] s, int row) {
        return s[row][0] + s[row][1] + s[row][2];
    }

    static int changeRow(int[][] s, int row) {
        int changeCount = 0;
        int firstNumber = s[row][0];
        int secondNumber = s[row][1];
        int thirdNumber = s[row][2];

        int difference = 15 - (firstNumber + secondNumber + thirdNumber);
        //Difference can be negative
        for (int i=0; i<3; i++) {
            if (changeElement(s, row, i, difference)) {
                changeCount += Math.abs(difference);
            }
        }
        return changeCount;
    }

    private static boolean changeElement(int[][] s, int row, int col, int difference) {
        int number = s[row][col];
        int newNumber = difference + number;
        boolean changeIsInRange = (0 < newNumber)
                                  && (10 > newNumber);
        boolean alreadyHaveNumber = false;
        boolean needToChangeNumber = false;
        for (int i=0; i<row; i++) {
        		for (int j=0; j<col; j++) {
        			if (s[i][j] == newNumber) {
        				alreadyHaveNumber = true;
        			}
        			if (s[i][j] == number) {
        				needToChangeNumber = true;
        			}
        		}
        }
        
        if ((!alreadyHaveNumber && changeIsInRange) || needToChangeNumber) {
            //Would changing the number mean the column adds up?
            int columnTotal = s[0][col] + s[1][col] + s[2][col] + difference;
            if (columnTotal == 15) {
                s[row][col] = newNumber;
                return true;
            }
        }
        return false;
    } 

    
    public static void main(String[] args) throws IOException {
        int[][] s = new int[3][3];

        int[] magicSquare1 = {4,8,2,4,5,7,6,1,6};
        int[] magicSquare2 = {4,9,2,3,5,7,8,1,5};
        int[] magicSquare3 = {5,3,4,1,5,8,6,4,2};
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                s[i][j] = magicSquare1[k];
                k++;
            }
        }
        System.out.println("Before result:");
        for (int i = 0; i < 3; i++) {
    			System.out.println(s[i][0] + "" + s[i][1] + "" + s[i][2]);
        }
        
        System.out.println("Formulating result");
        int result = formingMagicSquare(s);
        System.out.println(result);
        System.out.println("After result:");
        for (int i = 0; i < 3; i++) {
        		System.out.println(s[i][0] + "" + s[i][1] + "" + s[i][2]);
        }
    }
}
