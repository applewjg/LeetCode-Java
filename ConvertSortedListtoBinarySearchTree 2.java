/*
 * Author: Yang Pei
 * Problem: Convert Sorted List to Binary Search Tree
 * Source: https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * Note:
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Solution:
 * Recursively split the list into two half and build a new TreeNode. Two methods
 * to find the middle point of the list.
 * 		Using counter
 * 		Using fast/slow pointer
 */
public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		if(head.next == null)
			return new TreeNode(head.val);
		int count = 0;
		ListNode temp = head;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		int half = count / 2;
		temp = head;
		while(half > 1) {
			temp = temp.next;
			half--;
		}
		ListNode temp1 = temp.next;
		temp.next = null;
		TreeNode root = new TreeNode(temp1.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(temp1.next);
		return root;
	}
	
	public TreeNode sortedListToBST1(ListNode head) {
		if(head == null)
			return null;
		if(head.next == null)
			return new TreeNode(head.val);
		ListNode slow = head, fast = head, pre = null;
		while(fast != null && fast.next != null) {
		    pre = slow;
		    slow = slow.next;
		    fast = fast.next.next;
		}
		pre.next = null;
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST1(head);
		root.right = sortedListToBST1(slow.next);
		return root;
	}
}
