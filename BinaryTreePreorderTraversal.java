/*
 * Author: Yang Pei
 * Problem: Binary Tree Preorder Traversal
 * Source: https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Note:
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
   return [1,2,3].
   
   Solution:
   Recursive method is quite easy. There are two iterative method, one is to use a stack
   and the othre one is Morris iterate which take O(1) space.
 */
import java.util.*;
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		stack.push(root);
		while(stack.size() > 0) {
			TreeNode temp = stack.pop();
			result.add(temp.val);
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
		return result;
	}
	
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		TreeNode cur = root, tmp = null;
		while(cur != null) {
			if(cur.left == null) {
				result.add(cur.val);
				cur = cur.right;
			}
			else {
				tmp = cur.left;
				while(tmp.right != null && tmp.right != cur)
					tmp = tmp.right;
				if(tmp.right == null) {
					result.add(cur.val);
					tmp.right = cur;
					cur = cur.left;
				}
				else {
					tmp.right = null;
					cur = cur.right;
				}
			}
		}
		return result;
	}
}
