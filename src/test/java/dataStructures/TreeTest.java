package dataStructures;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TreeTest {

	@Test
	public void testAddRoot() {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		
		//Act
		try {
			tree.addRoot(rootNode);
		} catch (Exception e) {
			fail("Shouldn't be a root already");
			e.printStackTrace();
		}
		TreeNode rootReturned = tree.root();
		assertEquals(rootNode, rootReturned);
		assertEquals(1, tree.size());
	
		try {
			tree.addRoot(rootNode);
			fail("Should throw an exception");
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void testParent() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		
		tree.attachLeft(rootNode, child);
		
		//Act
		TreeNode returnedParent = tree.parent(child);
		
		//Assert
		assertEquals(rootNode, returnedParent);
	}
	
	@Test
	public void testChildren() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		
		tree.attachLeft(rootNode, child);
		
		//Act
		List<TreeNode> returnedChildren = tree.children(rootNode);
		
		//Assert
		assertEquals(1, returnedChildren.size());	
		assertEquals(child, returnedChildren.get(0));	
	}
	
	@Test
	public void testNumChildren() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		
		tree.attachLeft(rootNode, child);
		
		//Act
		int numKids = tree.numChildren(rootNode);
		
		//Assert
		assertEquals(1, numKids);		
		TreeNode<Integer> rightChild = new TreeNode<Integer>(rootNode, null, null, 61);
		
		tree.attachRight(rootNode, rightChild);
		
		numKids = tree.numChildren(rootNode);
		
		//Assert
		assertEquals(2, numKids);	
	}
	
	@Test
	public void testAttachLeft() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		
		tree.attachLeft(rootNode, child);
		
		//Act
		TreeNode<Integer> leftChild = rootNode.getLeftChild();
		
		//Assert
		assertEquals(child, leftChild);		
	}
	
	@Test
	public void testAttachRight() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		
		tree.attachRight(rootNode, child);
		
		//Act
		TreeNode<Integer> rightChild = rootNode.getRightChild();
		
		//Assert
		assertEquals(child, rightChild);		
	}
	
	@Test
	public void testIsRoot() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		TreeNode<Integer> child2 = new TreeNode<Integer>(rootNode, null, null, 1);
			
		tree.attachRight(rootNode, child);
		tree.attachLeft(rootNode, child2);
		
		//Assert
		assertTrue(tree.isRoot(rootNode));
		assertTrue(!tree.isRoot(child));
		assertTrue(!tree.isRoot(child2));
	}
	
	@Test
	public void testIsEmpty() throws Exception {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		TreeNode<Integer> child2 = new TreeNode<Integer>(rootNode, null, null, 1);
			
		assertTrue(tree.isEmpty());
		tree.addRoot(rootNode);
		assertTrue(!tree.isEmpty());
		tree.attachRight(rootNode, child);
		tree.attachLeft(rootNode, child2);
		assertTrue(!tree.isEmpty());
		
	}
	
	@Test
	public void testSize() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		TreeNode<Integer> child2 = new TreeNode<Integer>(rootNode, null, null, 1);
			
		tree.attachRight(rootNode, child);
		tree.attachLeft(rootNode, child2);
		
		assertEquals(3, tree.size());
		
		TreeNode<Integer> grandchild = new TreeNode<Integer>(child, null, null, 21);
		TreeNode<Integer> grandchild2 = new TreeNode<Integer>(child, null, null, 19);
		tree.attachRight(child, grandchild);
		tree.attachLeft(child, grandchild2);
		
		assertEquals(5, tree.size());
		
	}
	
	@Test
	public void testIsInternal() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		TreeNode<Integer> child2 = new TreeNode<Integer>(rootNode, null, null, 1);
			
		assertTrue(!tree.isInternal(rootNode));
		tree.attachRight(rootNode, child);
		tree.attachLeft(rootNode, child2);
		assertTrue(tree.isInternal(rootNode));
		
	}
	
	@Test
	public void testIsExternal() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		TreeNode<Integer> child2 = new TreeNode<Integer>(rootNode, null, null, 1);
			
		assertTrue(tree.isExternal(rootNode));
		tree.attachRight(rootNode, child);
		tree.attachLeft(rootNode, child2);
		assertTrue(!tree.isExternal(rootNode));
	}
	
	@Test
	public void testDepth() throws Exception {
		//Arrange
		TreeNode<Integer> rootNode = new TreeNode<Integer>(null, null, null, 9);
		Tree tree = new Tree();
		tree.addRoot(rootNode);
		TreeNode<Integer> child = new TreeNode<Integer>(rootNode, null, null, 1);
		TreeNode<Integer> child2 = new TreeNode<Integer>(rootNode, null, null, 1);
			
		tree.attachRight(rootNode, child);
		tree.attachLeft(rootNode, child2);
		
		assertEquals(1, tree.depth(child));
		
		TreeNode<Integer> grandchild = new TreeNode<Integer>(child, null, null, 21);
		TreeNode<Integer> grandchild2 = new TreeNode<Integer>(child, null, null, 19);
		tree.attachRight(child, grandchild);
		tree.attachLeft(child, grandchild2);
		
		assertEquals(2, tree.depth(grandchild));
	}
}