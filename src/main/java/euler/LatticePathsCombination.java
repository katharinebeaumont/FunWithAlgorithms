package euler;

/*
 * Problem from:
 *     https://projecteuler.net/problem=15
 * Starting in the top left corner of a 2×2 grid, 
 * and only being able to move to the right and down, 
 * there are exactly 6 routes to the bottom right corner.
 * 
 *  _ _
 * |_|_|  
 * |_|_|
 *  
 * How many such routes are there through a 20×20 grid?
 * 
 * This solution:
 * n is the number of grid squares.
 * Using combinations, there are 2xn steps to the corner,
 * and we choose n.
 * 
 *  ( 2n )
 *  ( n  ) combinations = (2n)!/(n!^2)
 * 
 * See https://www.robertdickau.com/manhattan.html
 */
public class LatticePathsCombination {

	public long calculateRoutes(int nGridSquares) {
		//Time it
		long startTime = System.currentTimeMillis();
		System.out.println("Calculating the number of routes for a " 
					    + nGridSquares + "x" + nGridSquares + " grid.");
		
		int lengthOfPath = nGridSquares * 2;
		
		long numerator = 1;
		for (int i = 1; i<=lengthOfPath; i++) {
			numerator *= i;
		}
		
		long denominator = 1;
		for (int i = 1; i<=nGridSquares; i++) {
			denominator *= i;
		}
		denominator *= denominator;
		
		long total = numerator/denominator;
		
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("Time taken is " + time + " milliseconds.");
		System.out.println("There are " + total + " routes.");
		return total;
	}
}
