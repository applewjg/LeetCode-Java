/*
 * Authour: Yang Pei
 * Problem: Rotate List
 * Source: https://oj.leetcode.com/problems/rotate-list/
 * 
 * Note:
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * Solution:
 * 		First, find the length of the list
 * 		Second, find the position to split
 * 
 * Corner case:
 * The given n might larger than the length of the list.
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || head.next == null)
			return head;
		ListNode temp = head;
		int cnt = 1;
		while(temp.next != null) {
			temp = temp.next;
			cnt++;
		}
		n = n % cnt;
		if(n == 0)
			return head;
		ListNode temp2 = head;
		int k = cnt - n;
		while(k > 1) {
			temp2 = temp2.next;
			k--;
		}
		temp.next = head;
		head = temp2.next;
		temp2.next = null;
		return head;
	}
}
