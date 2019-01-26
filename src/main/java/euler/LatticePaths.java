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
 * Map the grid squares in terms of edges, and treat it
 * like a directed graphs.
 * Using an adjacency list representation for the graph 
 * and doing an exhaustive search (using recursion) for paths from the origin
 * to the final destination.
 * This is not the fastest way to do this. Perhaps using a matrix
 * representation would be faster.
 */
public class LatticePaths {

	/*
	 * For a 2x2 grid, nGridSquares is 2.
	 * For a 3x3 grid, nGridSquares is 3...
	 * nGridSquares should really be called
	 *  numberOfGridSquaresAcrossOneSide
	 * but life is too short.
	 *  
	 */
	public long calculateRoutes(int nGridSquares) {
		//Time it
		long startTime = System.currentTimeMillis();
		System.out.println("Calculating the number of routes for a " 
					    + nGridSquares + "x" + nGridSquares + " grid.");
		Object[] edges = generateEdges(nGridSquares);
		//Start with the node 1, 
		// then look at how many outgoing edges there are from it,
		//   and how many outgoing edges there are from the connecting nodes
		//     and how many edges from them...
		//    until we get to the final node.
		long total = count(edges, 1);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("Time taken is " + time + " milliseconds.");
		System.out.println("There are " + total + " routes.");
		return total;
	}

	private long count(Object[] edges, int index) {
		long count = 0;
		if (index == (edges.length)) {
			return 1;
		}
		short[] nodes = (short[]) edges[index];
		for (short node: nodes) {
			count += count(edges, node);
		}
		return count;
		
	}
	
	public Object[] generateEdges(int nGridSquares) {
		int nNodes = (nGridSquares + 1)*(nGridSquares + 1);
		System.out.println("There are " + nNodes + " nodes.");
		
		// The final node doesn't have any edges 
		// And we're ignoring the Java convention of indexing from 0, 
		// so edges[0] is null, and we start from edges[1].
		// So the list length is effectively nNodes - 1
		Object[] edges = new Object[nNodes];
		int nEdges = 0;
		for (int i = 1; i <= nNodes; i++) {
			//i is the key
			// Start at the top left, which is 1.
			// A 2x2 grid will have nodes:
			//   1 2 3
			//   4 5 6
			//   7 8 9
			short rightNode = getRightNode(i, nGridSquares);
			short lowerNode = getLowerNode(i, nGridSquares, nNodes);
			short[] nodes;
			if (rightNode > 0 && lowerNode > 0) {
				nodes = new short[2];
				nodes[0] = rightNode;
				nodes[1] = lowerNode;
				nEdges += 2;
			}
			else if (rightNode > 0) {
				nodes = new short[1];
				nodes[0] = rightNode;
				nEdges++;
			} else if (lowerNode > 0) {
				nodes = new short[1];
				nodes[0] = lowerNode;
				nEdges++;
			} else {
				// There are no connecting nodes, so we are at the 
				// bottom right of the grid
				continue; 
			}
			edges[i] = nodes;
		}
		System.out.println("There are " + nEdges + " edges.");
		return edges;
	}
	private short getRightNode(int i, int nGridSquares) {
		//For a 2x2 grid,
		// if the node is 3, 6 or 9, it is the
		// rightmost node
		if (i % (nGridSquares + 1) == 0) {
			return 0;
		}
		return (short) (i + 1);
	}

	private short getLowerNode(int i, int nGridSquares, int nEdges) {
		//For a 2x2 grid,
		// if the node is 7, 8 or 9, it is the
		// lowest node
		if (i > nEdges - (nGridSquares + 1)) {
			return 0;
		}
		return (short) (i + nGridSquares + 1);
	}
}
