/*
 * Author: Yang Pei
 * Problem: Construct Binary Tree from Inorder and Postorder Traversal
 * Source: https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * Note:
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Assume there are no duplicates
 * 
 * Solution:
 * Recursion.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = inorder.length;
		if(n == 0)
			return null;
		if(n == 1)
			return new TreeNode(inorder[0]);
		int key = postorder[n-1];
		int i = 0;
		for(; i < n; i++)
			if(inorder[i] == key)
				break;
		int[] lin = new int[i];
		int[] lpos = new int[i];
		int[] rin = new int[n-1-i];
		int[] rpos = new int[n-1-i];
		for(int j = 0; j < i; j++) {
			lin[j] = inorder[j];
			lpos[j] = postorder[j];
		}
		for(int j = 0; j < n-1-i; j++) {
			rin[j] = inorder[i+j+1];
			rpos[j] = postorder[i+j];
		}
		TreeNode root = new TreeNode(key);
		root.left = buildTree(lin, lpos);
		root.right = buildTree(rin, rpos);
		return root;
	}
}
