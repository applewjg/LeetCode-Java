/*
 * Author: Yang Pei
 * Problem: Remove Duplicates from Sorted List II
 * Source: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Note:
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * Solution:
 * Three pointers.
 * 
 * Follow up:
 * What if the dummy node is not allowed? Use recursive version do not need to allocate
 * a dummy node.
 */
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pointer1 = head, pointer2 = head, pointer3 = dummy;
		while(pointer1 != null) {
			while(pointer2 != null && pointer2.val == pointer1.val)
				pointer2 = pointer2.next;
			if(pointer2 != pointer1.next)
				pointer3.next = pointer2;
			else
				pointer3 = pointer3.next;
			pointer1 = pointer2;
		}
		pointer3.next = null;
		return dummy.next;
	}
	
	public ListNode deleteDuplicates2(ListNode head) {
		if(head == null || head.next == null)
			return head;
		if(head.val == head.next.val) {
			ListNode temp = head;
			while(temp != null && temp.val == head.val)
				temp = temp.next;
			return deleteDuplicates2(temp);
		}
		else {
			head.next = deleteDuplicates2(head.next);
			return head;
		}
	}
}
