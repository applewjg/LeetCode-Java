/*
 * Author: Yang Pei
 * Problem: Linked List Cycle II
 * Source: https://oj.leetcode.com/problems/linked-list-cycle-ii/
 * 
 * Note:
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Solution:
 * Use hashset, while looping the list, the first node appear in hashset is the 
 * start position of the cycle.
 * Use slow and fast pointer. Find the meet position first and then find the start
 * position of the cycle.
 */
import java.util.*;
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode temp = head;
		while(temp != null) {
			if(set.contains(temp))
				return temp;
			else
				set.add(temp);
			temp = temp.next;
		}
		return null;
	}
	
	public ListNode detectCycle1(ListNode head) {
		if(head == null || head.next == null)
			return null;
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		if(slow != fast)
			return null;
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
