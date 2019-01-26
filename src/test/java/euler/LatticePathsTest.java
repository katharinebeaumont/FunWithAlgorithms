package euler;

import static org.junit.Assert.*;


import org.junit.Test;

public class LatticePathsTest {

	private LatticePaths lp = new LatticePaths();

	@Test
	public void testGenerateEdgesFor2By2Grid() {
		//Arrange
		int n = 2;
		// For a 2x2 grid, we expect 9 nodes, but the final
		// one, 9, won't have any edges. So we're looking for
		// 8 edge keys
		// Grid:
		//   1 2 3
		//   4 5 6
		//   7 8 9
		int numberKeys = (n+1)*(n+1);
		
		//Act
		Object[] edges = lp.generateEdges(n);
		
		//Assert
		assertEquals(numberKeys, edges.length);
		for (int key = 1; key < edges.length; key++) {
			short[] connectingNodes = (short[]) edges[key];
			if (key == 1 || key == 2 || key == 4 || key == 5 ) {
				assertEquals(2, connectingNodes.length);
			}
			if (key == 3 || key == 6 || key == 7 || key == 8) {
				assertEquals(1, connectingNodes.length);
			}
			if (key == 1) {
				assertEquals(2, (int)connectingNodes[0]);
				assertEquals(4, (int)connectingNodes[1]);
			}
			if (key == 2) {
				assertEquals(3, (int)connectingNodes[0]);
				assertEquals(5, (int)connectingNodes[1]);
			}
			if (key == 3) {
				assertEquals(6, (int)connectingNodes[0]);
			}
			if (key == 4) {
				assertEquals(5, (int)connectingNodes[0]);
				assertEquals(7, (int)connectingNodes[1]);
			}
			if (key == 5) {
				assertEquals(6, (int)connectingNodes[0]);
				assertEquals(8, (int)connectingNodes[1]);
			}
			if (key == 6) {
				assertEquals(9, (int)connectingNodes[0]);
			}
			if (key == 7) {
				assertEquals(8, (int)connectingNodes[0]);
			}
			if (key == 8) {
				assertEquals(9, (int)connectingNodes[0]);
			}
		}
		
	}
	
	@Test
	public void testCalculateRoutesFor2By2() {
		assertEquals(6, lp.calculateRoutes(2));
	}
	
	@Test
	public void testCalculateRoutesFor3By3() {
		assertEquals(20, lp.calculateRoutes(3));
	}
	
	@Test
	public void testCalculateRoutesFor4By4() {
		assertEquals(70, lp.calculateRoutes(4));
	}
	
	@Test
	public void testCalculateRoutesFor20By20() {
		//This will fail, because I don't want to give away the
		// answer to the question.
		assertEquals(20, lp.calculateRoutes(20));
	}
}
