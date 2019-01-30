package dataStructures;

public class TreeSearch {

	public void breadthFirst(Tree tree) throws Exception {
		TreeQueue<TreeNode> queue = new TreeQueue<TreeNode>();
		TreeNode root = tree.root();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.dequeue();
			System.out.println(node.getElement());
			
			if (node.getLeftChild() != null) {
				queue.enqueue(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				queue.enqueue(node.getRightChild());
			}
		}
		
	}
}
