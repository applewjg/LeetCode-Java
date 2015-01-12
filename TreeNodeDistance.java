/*
 * Author: Yang Pei
 * Problem: Distance between two node in a Binary Tree
 * 
 * Note:
 * Given a binary tree and two nodes, find the distance of these two node in 
 * the tree, we assume that the two node exist in the tree and we assume the 
 * two nodes are different.
 * 
 * Solution:
 * Postorder traversal method to find LCA.
 */
public class TreeNodeDistance {
	
	private static class Result {
		TreeNode node;
		int depth;
		public Result(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
	
	public static Result distance(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null) 
			return new Result(null, 0);
		Result left = distance(root.left, node1, node2);
		Result right = distance(root.right, node1, node2);
		if(root == node1 || root == node2) {
			if(left.node == null && right.node == null)
				return new Result(root, 1);
			else if(left.node != null) {
				return new Result(null, left.depth+1);
			}
			else {
				return new Result(null, right.depth+1);
			}
		}
		else {
			if(left.node == null && right.node == null) {
				return left.depth == 0 ? right : left;
			}
			else if(left.node != null && right.node == null) {
				left.depth += 1;
				return left;
			}
			else if(left.node == null && right.node != null) {
				right.depth += 1;
				return right;
			}
			else {
				return new Result(null, left.depth+right.depth+1);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.right = node5;
		node3.left = node6;
		node3.right = node7;
		Result r = distance(node1, node5, node6);
		System.out.println(r.depth);
	}
}
