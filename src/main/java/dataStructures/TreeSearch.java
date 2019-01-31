package dataStructures;


public class TreeSearch<E> {

	/*
	 * O(n), using a queue
	 */
	public void breadthFirst(Tree<E> tree) throws Exception {
		TreeQueue<TreeNode<E>> queue = new TreeQueue<TreeNode<E>>();
		TreeNode<E> root = tree.root();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			TreeNode<E> node = queue.dequeue();
			visit(node);
			
			if (node.getLeftChild() != null) {
				queue.enqueue(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				queue.enqueue(node.getRightChild());
			}
		}
		
	}
	
	/*
	 * O(n) using recursion
	 */
	public void depthFirst(Tree<E> tree) throws Exception {
		TreeNode<E> node = tree.root();
		depthFirstVisit(node);
	}
	
	private void depthFirstVisit(TreeNode<E> node) {
		visit(node);
		if (node.getLeftChild() != null) {
			depthFirstVisit(node.getLeftChild());
		}
		if (node.getRightChild() != null) {
			depthFirstVisit(node.getRightChild());
		}
	}
	
	/*
	 * Visit method
	 */
	private void visit(TreeNode<E> node) {
		System.out.println(node.getElement());
	}
}
