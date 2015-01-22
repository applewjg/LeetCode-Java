/*
 * Author: Yang Pei
 * Problem: Binary Tree Level Order Traversal II
 * Source: https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * Note:
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * Solution:
 * First level traverse the tree, then reverse the result.
 * Use postorder traversal.
 */
import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if(root == null)
			return result;
		TreeNode dummy = new TreeNode(0);
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.offer(root); qu.offer(dummy);
		while(qu.size() > 0) {
			TreeNode node = qu.poll();
			if(node == dummy) {
				result.add(list);
				list = new ArrayList<Integer>();
				if(qu.size() != 0)
					qu.offer(dummy);
			}
			else {
				list.add(node.val);
				if(node.left != null)
					qu.offer(node.left);
				if(node.right != null)
					qu.offer(node.right);
			}
		}
		Collections.reverse(result);
		return result;
	}
	
	public List<List<Integer>> levelOrderBottom1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		postorder(root, 0, result);
		return result;
	}
	
	private void postorder(TreeNode root, int dep, List<List<Integer>> result) {
		if(result.size() <= dep) {
			List<Integer> list = new ArrayList<Integer>();
			result.add(0, list);
		}
		if(root.left != null)
			postorder(root.left, dep+1, result);
		if(root.right != null)
			postorder(root.right, dep+1, result);
		result.get(result.size() - dep - 1).add(root.val);
	}
}
