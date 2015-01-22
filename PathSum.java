/*
 * Author: Yang Pei
 * Problem: Path Sum
 * Source: https://oj.leetcode.com/problems/path-sum/
 * 
 * Note:
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * Solution:
 * Preorder traversal.
 * 
 * Follow up:
 * Determine if the tree has a root-to-node path such that sum to target. We only need
 * to change a little on the original code, at each node we try to find if the sum is
 * target or not.
 * Determine if the tree has a node-to-node path such that sum to target. Bottom up 
 * recursion on each node to find all possible path. Return a list of all sum value
 * of each node.
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null) {
			if(sum == root.val)
				return true;
			else 
				return false;
		}
		else if(root.left == null && root.right != null) {
			return hasPathSum(root.right, sum - root.val);
		}
		else if(root.left != null && root.right == null) {
			return hasPathSum(root.left, sum - root.val);
		}
		else {
			return hasPathSum(root.left, sum - root.val) | hasPathSum(root.right, sum - root.val);
		}
	}
}
