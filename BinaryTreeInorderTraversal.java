/*
 * Author: Yang Pei
 * Problem: Binary Tree Inorder Traversal
 * Source: https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * Note:
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
   return [1,3,2].
   
   Soluiton:
   		Recursive method.
   		Iterative method with a stack.
   		Morris iterative with O(1) space complexity.
 */
import java.util.*;
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
		List<Integer> result = new ArrayList<Integer>();
		while(stack.size() != 0) {
			TreeNode temp = stack.pop();
			result.add(temp.val);
			temp = temp.right;
			while(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
		}
		return result;
	}
	
	public List<Integer> inorderTraversal1(TreeNode root) {
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
					tmp.right = cur;
					cur = cur.left;
				}
				else {
					tmp.right = null;
					result.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return result;
	}
}
