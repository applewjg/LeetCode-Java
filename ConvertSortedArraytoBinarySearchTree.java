/*
 * Author: Yang Pei
 * Problem: Convert Sorted Array to Binary Search Tree
 * Source: https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * Note:
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Solution:
 * The inorder traversal of BST is an sorted array. In order to build a height
 * balanced BST, each time we use the middle of the array as the root and recursively
 * build the left tree using left parts and right tree using right parts.
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		int n = num.length;
		if(n == 0)
			return null;
		if(n == 1)
			return new TreeNode(num[0]);
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid - 1];
		for(int i = 0; i < mid; i++)
			left[i] = num[i];
		for(int i = 0; i < n-mid-1; i++)
			right[i] = num[mid+i+1];
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(left);
		root.right = sortedArrayToBST(right);
		return root;
	}
}
