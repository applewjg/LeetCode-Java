/*
 * Author: Yang Pei
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * Source: https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Note:
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Assume no duplicates in the tree.
 * 
 * Solution:
 * Build the tree recursively.
 * 
 * Follow up:
 * What if there exist duplicates in the tree? Could we still use the original
 * method to rebuild the tree?
 */
public class ConstructBinaryTreefromProorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = inorder.length;
		if(n == 0)
			return null;
		if(n == 1)
			return new TreeNode(inorder[0]);
		int key = preorder[0];
		int i = 0;
		for(; i < n; i++)
			if(inorder[i] == key)
				break;
		int[] lin = new int[i];
		int[] lpre = new int[i];
		int[] rin = new int[n-i-1];
		int[] rpre = new int[n-i-1];
		for(int j = 0; j < i; j++) {
			lin[j] = inorder[j];
			lpre[j] = preorder[j+1];
		}
		for(int j = 0; j < n-i-1; j++) {
			rin[j] = inorder[i+j+1];
			rpre[j] = preorder[i+j+1];
		}
		TreeNode root = new TreeNode(key);
		root.left = buildTree(lpre, lin);
		root.right = buildTree(rpre, rin);
		return root;
		
	}
}
