package dataStructures;

import org.junit.Test;

public class TreeSearchTest {

	@Test
	public void testWithOneNode() throws Exception {
		//Arrange
		TreeNode root = new TreeNode(null, null, null, "root");
		TreeSearch search = new TreeSearch();
		Tree tree = new Tree();
		tree.addRoot(root);
		
		//Act
		search.breadthFirst(tree);
		
		//Assert
	}
	
	@Test
	public void testWithRightChildOfRootNode() throws Exception {
		//Arrange
		TreeNode root = new TreeNode(null, null, null, "root");
		TreeNode rightChild = new TreeNode(root, null, null, "rightChild");
		root.setRightChild(rightChild);
		TreeSearch search = new TreeSearch();
		Tree tree = new Tree();
		tree.addRoot(root);
		
		//Act
		search.breadthFirst(tree);
		
		//Assert
	}
	
	@Test
	public void testWithTreeOfDepth2() throws Exception {
		//Arrange
		TreeNode root = new TreeNode(null, null, null, "root 0");
		TreeNode rightChildOfRoot = new TreeNode(root, null, null, "rightChild 2");
		TreeNode leftChildOfRoot = new TreeNode(root, null, null, "LeftChild 1");
		Tree tree = new Tree();
		tree.addRoot(root);
		tree.attachLeft(root, leftChildOfRoot);
		tree.attachRight(root, rightChildOfRoot);
		
		//Level down
		TreeNode rightChildOfLeftChild = new TreeNode(leftChildOfRoot, null, null, "leftChild left child 4");
		TreeNode leftChildOfLeftChild = new TreeNode(leftChildOfRoot, null, null, "leftChild rigth child 3");
		tree.attachLeft(leftChildOfRoot, leftChildOfLeftChild);
		tree.attachRight(leftChildOfRoot, rightChildOfLeftChild);
		
		TreeNode rightChildOfRightChild = new TreeNode(rightChildOfRoot, null, null, "rightChild 6");
		TreeNode leftChildOfRightChild = new TreeNode(rightChildOfRoot, null, null, "rightChild 5");
		tree.attachLeft(rightChildOfRoot, leftChildOfRightChild);
		tree.attachRight(rightChildOfRoot, rightChildOfRightChild);
		
		
		TreeSearch search = new TreeSearch();
		
		
		//Act
		search.breadthFirst(tree);
		
		//Assert
	}
}
