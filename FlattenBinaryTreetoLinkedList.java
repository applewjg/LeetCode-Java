/*
 * Author: Yang Pei
 * Problem: Flatten Binary Tree to Linked List
 * Source: https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * Note:
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given

         1
        / \
       2   5
      / \   \
     3   4   6
   The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
             
    Solution:
    Recursive method or morris iterate.
 */
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		while(root != null) {
			if(root.left == null)
				root = root.right;
			else {
				TreeNode temp = root.left;
				while(temp.right != null)
					temp = temp.right;
				temp.right = root.right;
				root.right = root.left;
				root.left = null;
				root = root.right;
			}
		}
	}
	
	public void flatten1(TreeNode root) {
		flattenr(root);
	}
	private TreeNode flattenr(TreeNode root) {
		if(root == null)
			return null;
		TreeNode left = flattenr(root.left);
		TreeNode right = flattenr(root.right);
		if(left == null) {
			root.left = null;
			root.right = right;
		}
		else {
			TreeNode temp = left;
			while(temp.right != null)
				temp = temp.right;
			temp.right = right;
			root.left = null;
			root.right = left;
		}
		return root;
	}
}
