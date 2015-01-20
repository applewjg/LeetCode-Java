/*
 * Author: Yang Pei
 * Problem: Partition List
 * Source: https://oj.leetcode.com/problems/partition-list/
 * 
 * Note:
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * Solution:
 * Allocate two new node to hold the split list then linked back. Pay attention to 
 * set the last node's next to null otherwise might have loop.
 * For example, {2, 1} and x = 2;
 * Or we can use only one dummy node to hold the head of the list and change it in-place.
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null)
			return head;
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode temp = head, temp1 = dummy1, temp2 = dummy2;
		while(temp != null) {
			if(temp.val < x) {
				temp1.next = temp;
				temp = temp.next;
				temp1 = temp1.next;
				temp1.next = null;
			}
			else {
				temp2.next = temp;
				temp = temp.next;
				temp2 = temp2.next;
				temp2.next = null;
			}
		}
		temp1.next = dummy2.next;
		return dummy1.next;
	}
	
	public ListNode partition1(ListNode head, int x) {
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode temp1 = dummy, temp2 = null, temp = head;
		while(temp != null) {
			if(temp.val < x) {
				if(temp2 != null) {
					temp2.next = temp.next;
					temp.next = temp1.next;
					temp1.next = temp;
					temp1 = temp1.next;
					temp = temp2.next;
				}
				else {
					temp = temp.next;
					temp1 = temp1.next;
				}
			}
			else {
				if(temp2 == null) 
					temp2 = temp;
				else 
					temp2 = temp2.next;
				temp = temp.next;
			}
		}
		return dummy.next;
	}
}
