package dataStructures;

import org.junit.Test;

public class TreeSearchTest {

	@Test
	public void testBreadthFirstWithOneNode() throws Exception {
		//Arrange
		System.out.println("Breadth First, one node");
		TreeNode<String> root = new TreeNode<String>(null, null, null, "root");
		TreeSearch<String> search = new TreeSearch<String>();
		Tree<String> tree = new Tree<String>();
		tree.addRoot(root);
		
		//Act
		search.breadthFirst(tree);
		
		//Assert
	}
	
	@Test
	public void testBreadthFirstWithRightChildOfRootNode() throws Exception {
		//Arrange
		System.out.println("Breadth First, one child of root node");
		
		TreeNode<String> root = new TreeNode<String>(null, null, null, "root");
		TreeNode<String> rightChild = new TreeNode<String>(root, null, null, "rightChild");
		root.setRightChild(rightChild);
		TreeSearch<String> search = new TreeSearch<String>();
		Tree<String> tree = new Tree<String>();
		tree.addRoot(root);
		
		//Act
		search.breadthFirst(tree);
		
		//Assert
	}
	
	@Test
	public void testBreadthFirstWithTreeOfDepth2() throws Exception {
		//Arrange
		System.out.println("Breadth First, tree of depth 2");
		
		TreeNode<String> root = new TreeNode<String>(null, null, null, "root 0");
		TreeNode<String> rightChildOfRoot = new TreeNode<String>(root, null, null, "rightChild 2");
		TreeNode<String> leftChildOfRoot = new TreeNode<String>(root, null, null, "LeftChild 1");
		Tree<String> tree = new Tree<String>();
		tree.addRoot(root);
		tree.attachLeft(root, leftChildOfRoot);
		tree.attachRight(root, rightChildOfRoot);
		
		//Level down
		TreeNode<String> rightChildOfLeftChild = new TreeNode<String>(leftChildOfRoot, null, null, "leftChild left child 4");
		TreeNode<String> leftChildOfLeftChild = new TreeNode<String>(leftChildOfRoot, null, null, "leftChild rigth child 3");
		tree.attachLeft(leftChildOfRoot, leftChildOfLeftChild);
		tree.attachRight(leftChildOfRoot, rightChildOfLeftChild);
		
		TreeNode<String> rightChildOfRightChild = new TreeNode<String>(rightChildOfRoot, null, null, "rightChild 6");
		TreeNode<String> leftChildOfRightChild = new TreeNode<String>(rightChildOfRoot, null, null, "rightChild 5");
		tree.attachLeft(rightChildOfRoot, leftChildOfRightChild);
		tree.attachRight(rightChildOfRoot, rightChildOfRightChild);
		
		
		TreeSearch<String> search = new TreeSearch<String>();
		
		
		//Act
		search.breadthFirst(tree);
		
		//Assert
	}
	

	@Test
	public void testDepthFirstWithOneNode() throws Exception {
		//Arrange
		System.out.println("Depth First, just root node");
		
		TreeNode<String> root = new TreeNode<String>(null, null, null, "root");
		TreeSearch<String> search = new TreeSearch<String>();
		Tree<String> tree = new Tree<String>();
		tree.addRoot(root);
		
		//Act
		search.depthFirst(tree);
		
		//Assert
	}
	
	@Test
	public void testDepthFirstWithRightChildOfRootNode() throws Exception {
		//Arrange
		System.out.println("Depth First, one child of root node");
		
		TreeNode<String> root = new TreeNode<String>(null, null, null, "root");
		TreeNode<String> rightChild = new TreeNode<String>(root, null, null, "rightChild");
		root.setRightChild(rightChild);
		TreeSearch<String> search = new TreeSearch<String>();
		Tree<String> tree = new Tree<String>();
		tree.addRoot(root);
		
		//Act
		search.depthFirst(tree);
		
		//Assert
	}
	
	@Test
	public void testDepthFirstWithTreeOfDepth2() throws Exception {
		//Arrange
		System.out.println("Depth First, tree of depth 2");
		
		TreeNode<String> root = new TreeNode<String>(null, null, null, "root 0");
		TreeNode<String> rightChildOfRoot = new TreeNode<String>(root, null, null, "rightChild 4");
		TreeNode<String> leftChildOfRoot = new TreeNode<String>(root, null, null, "LeftChild 1");
		Tree<String> tree = new Tree<String>();
		tree.addRoot(root);
		tree.attachLeft(root, leftChildOfRoot);
		tree.attachRight(root, rightChildOfRoot);
		
		//Level down
		TreeNode<String> leftChildOfLeftChild = new TreeNode<String>(leftChildOfRoot, null, null, "leftChild left child 2");
		TreeNode<String> rightChildOfLeftChild = new TreeNode<String>(leftChildOfRoot, null, null, "leftChild right child 3");
		tree.attachLeft(leftChildOfRoot, leftChildOfLeftChild);
		tree.attachRight(leftChildOfRoot, rightChildOfLeftChild);
		
		TreeNode<String> rightChildOfRightChild = new TreeNode<String>(rightChildOfRoot, null, null, "rightChild 6");
		TreeNode<String> leftChildOfRightChild = new TreeNode<String>(rightChildOfRoot, null, null, "rightChild 5");
		tree.attachLeft(rightChildOfRoot, leftChildOfRightChild);
		tree.attachRight(rightChildOfRoot, rightChildOfRightChild);
		
		TreeSearch<String> search = new TreeSearch<String>();
		
		
		//Act
		search.depthFirst(tree);
		
		//Assert
	}
}
