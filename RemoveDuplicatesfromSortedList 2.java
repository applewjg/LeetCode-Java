/*
 * Author: Yang Pei
 * Problem: Remove Duplicates from Sorted List
 * Source: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Note:
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * Solution:
 * Two pointers.
 * 
 * Follow up:
 * What if the list is not sorted?
 * Write the recursive version?
 */
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode pointer1 = head, pointer2 = head.next;
		for(; pointer2 != null; pointer2 = pointer2.next) {
			if(pointer2.val != pointer1.val) {
				pointer1.next = pointer2;
				pointer1 = pointer2;
			}
		}
		pointer1.next = pointer2;
		return head;
	}
	
	public ListNode deleteDuplicates2(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode temp = head;
		while(temp != null && temp.val == head.val)
			temp = temp.next;
		head.next = deleteDuplicates2(temp);
		return head;
	}
}
