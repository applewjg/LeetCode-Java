/*
 * Author: Yang Pei
 * Problem: Binary Tree Level Order Traversal
 * Source: https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Note:
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
  return its level order traversal as:
 [
   [3],
   [9,20],
   [15,7]
 ]
 
 Solution:
 Iterative method, use two queues or use one queues.
 */
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.offer(root);
		while(qu.size() > 0) {
			Queue<TreeNode> next = new LinkedList<TreeNode>();
			List<Integer> list = new ArrayList<Integer>();
			while(qu.size() > 0) {
				TreeNode tmp = qu.poll();
				list.add(tmp.val);
				if(tmp.left != null)
					next.offer(tmp.left);
				if(tmp.right != null)
					next.offer(tmp.right);
			}
			result.add(list);
			qu = next;
		}
		return result;
	}
}
