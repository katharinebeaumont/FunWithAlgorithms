package euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class LatticePathsCombinationTest {
	

	private LatticePathsCombination lp = new LatticePathsCombination();

	@Test
	public void testCombinationsFor2By2Grid() {
		//Arrange
		int expectedTotal = 6;
		
		//Act
		long total = lp.calculateRoutes(2);
		
		//Assert
		assertEquals(expectedTotal, total);
	}
	
	@Test
	public void testCombinationsFor3By3Grid() {
		//Arrange
		int expectedTotal = 20;
		
		//Act
		long total = lp.calculateRoutes(3);
		
		//Assert
		assertEquals(expectedTotal, total);
	}
	
	@Test
	public void testCombinationsFor4By4Grid() {
		//Arrange
		int expectedTotal = 70;
		
		//Act
		long total = lp.calculateRoutes(4);
		
		//Assert
		assertEquals(expectedTotal, total);
	}
	
	@Test
	public void testCombinationsFor5By5Grid() {
		//Arrange
		int expectedTotal = 252;
		
		//Act
		long total = lp.calculateRoutes(5);
		
		//Assert
		assertEquals(expectedTotal, total);
	}
	
	public void testCombinationsFor6By6Grid() {
		//Arrange
		int expectedTotal = 924;
		
		//Act
		long total = lp.calculateRoutes(6);
		
		//Assert
		assertEquals(expectedTotal, total);
	}
	
}
