/*
 * Author: Yang Pei
 * Problem: Merge K Sorted Lists
 * Source: https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Note:
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * Solution:
 * Naive method: each time loop the k lists to find the minimum element.
 * Better method: use heap to hold the current head of each list and maintain the 
 * 					minimum element.
 */
import java.util.*;
public class MergeKSortedLists {
	public class myComparator implements Comparator<ListNode> {
		public int compare(ListNode node1, ListNode node2) {
			return node1.val - node2.val;
		}
	}
	public ListNode mergeKLists(List<ListNode> lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(1, new myComparator());
		for(int i = 0; i < lists.size(); i++) {
			if(lists.get(i) != null)
				pq.add(lists.get(i));
		}
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		while(pq.size() != 0) {
			ListNode node = pq.poll();
			temp.next = node;
			temp = temp.next;
			if(node.next != null)
				pq.add(node.next);
		}
		temp.next = null;
		return dummy.next;
	}
}
