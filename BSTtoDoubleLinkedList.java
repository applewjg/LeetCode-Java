/*
 * Author: Yang Pei
 * Problem: BST to Double Linked List
 * Source: http://www.careercup.com/question?id=4863668900593664
 * 
 * Note:
 * Given a BST, convert this BST into a double linked list that is sorted and 
 * returns the head of the list. Do it in place with space complexity O(1).
 * 
 * Solution:
 * 		Use recursive method or use morris iterate.
 */
public class BSTtoDoubleLinkedList {
	public static TreeNode BSTtoDLL(TreeNode root) {
		if(root == null)
			return null;
		TreeNode pre = BSTtoDLL(root.left);
		TreeNode next = BSTtoDLL(root.right);
		if(pre == null) {
			root.left = null;
			root.right = next;
			if(next != null)
				next.left = root;
			return root;
		}
		else {
			TreeNode temp = pre;
			while(temp.right != null)
				temp = temp.right;
			temp.right = root;
			root.left = temp;
			root.right = next;
			if(next != null)
				next.left = root;
			return pre;
		}
	}
	
	public static TreeNode BSTtoDLL1(TreeNode root) {
		if(root == null)
			return null;
		TreeNode cur = root, tmp = null, pre = null;
		while(cur != null) {
			if(cur.left == null) {
				cur.left = pre;
				if(pre != null)
					pre.right = cur;
				pre = cur;
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
					cur.left = pre;
					if(pre != null)
						pre.right = cur;
					pre = cur;
					cur = cur.right;
				}
			}
		}
		while(root.left != null)
			root = root.left;
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(6);
		root = BSTtoDLL1(root);
		TreeNode pre = null;
		while(root != null) {
			System.out.print(root.val + " ");
			pre = root;
			root = root.right;
		}
		System.out.println("");
		while(pre != null) {
			System.out.print(pre.val + " ");
			pre = pre.left;
		}
	}
}
