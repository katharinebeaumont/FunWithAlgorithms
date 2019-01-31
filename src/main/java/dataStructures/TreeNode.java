package dataStructures;

import java.util.ArrayList;
import java.util.List;

/*
 * Tree data structure.
 * Needs tidying up - particularly around attaching nodes
 * and encapsulating TreeNode 
 */
public class TreeNode<E> {

	private TreeNode<E> parent;
	private TreeNode<E> leftChild;
	private TreeNode<E> rightChild;
	private E element;
	
	public TreeNode(TreeNode<E> parent, TreeNode<E> leftChild, 
			TreeNode<E> rightChild, E element) {
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.element = element;
	}
	
	public TreeNode<E> getParent() {
		return parent;
	}

	public List<TreeNode<E>> getChildren() {
		List<TreeNode<E>> list = new ArrayList<TreeNode<E>>();
		if (rightChild != null) {
			list.add(rightChild);
		}
		if (leftChild != null) {
			list.add(leftChild);
		}
		
		return list;
	}
	
	public TreeNode<E> getLeftChild() {
		return leftChild;
	}

	public TreeNode<E> getRightChild() {
		return rightChild;
	}

	public E getElement() {
		return element;
	}
	
	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
	}

	public void setLeftChild(TreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(TreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}

	public void setElement(E element) {
		this.element = element;
	}
}
