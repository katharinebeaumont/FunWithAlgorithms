package dataStructures;

import java.util.List;

public class Tree<E> {

	private TreeNode<E> root;
	private int size;
	
	public void addRoot(TreeNode<E> root) throws Exception {
		if (this.root != null) {
			throw new Exception("Root already exists.");
		}
		this.root = root;
		size++;
	}
	
	public TreeNode<E> root() {
		return root;
	}
	
	public TreeNode<E> parent(TreeNode<E> element) {
		return element.getParent();
	}
	
	public List<TreeNode<E>> children(TreeNode<E> element) {
		return element.getChildren();
	}
	
	public int numChildren(TreeNode<E> element) {
		return element.getChildren().size();
	}
	
	public void attachLeft(TreeNode<E> parent, TreeNode<E> leftChild) {
		parent.setLeftChild(leftChild);
		size++;
	}
	
	public void attachRight(TreeNode<E> parent, TreeNode<E> rightChild) {
		parent.setRightChild(rightChild);
		size++;
	}
	
	public boolean isRoot(TreeNode<E> element) {
		return element.getParent() == null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isInternal(TreeNode<E> element) {
		return numChildren(element) > 0;
	}
	
	public boolean isExternal(TreeNode<E> element) {
		return numChildren(element) == 0;
	}
	
	public int depth(TreeNode<E> element) {
		if (isRoot(element)) {
			return 0;
		} else {
			return 1 + depth(parent(element));
		}
		
	}
}
