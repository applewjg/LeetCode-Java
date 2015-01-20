/*
 * Author: Yang Pei
 * Problem: Linked List Cycle
 * Source: https://oj.leetcode.com/problemset/algorithms/
 * 
 * Note:
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Solution:
 * Use a hashset to record the node we have visited. If we found a node exist in 
 * the set, then there is a cycle.
 * Use fast and slow pointers.
 */
import java.util.*;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode temp = head;
		while(temp != null) {
			if(set.contains(temp))
				return true;
			else
				set.add(temp);
			temp = temp.next;
		}
		return false;
	}
	
	public boolean hasCycle1(ListNode head) {
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow)
				return true;
		}
		return false;
	}
}
