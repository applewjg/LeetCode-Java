/*
 * Author: Yang Pei
 * Problem: Binary Search Tree Iterator
 * Source: https://oj.leetcode.com/problems/binary-search-tree-iterator/
 * 
 * Note:
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 * Solution:
 * Use the iterative inorder traverse of a binary tree with a stack. When we pop a node,
 * we check if there is right child, if there is right child, push all its left child into
 * the stack until there is no more left child.
 */
import java.util.*;

public class BinarySearchTreeIterator {
	private Stack<TreeNode> stack;
	public BinarySearchTreeIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		if(root != null)
			pushleft(root);
	}
	private void pushleft(TreeNode root) {
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
	}
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	public int next() {
		TreeNode temp = stack.pop();
		if(temp.right != null)
			pushleft(temp.right);
		return temp.val;
	}
}
