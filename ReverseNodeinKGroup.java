/*
 * Author: Yang Pei
 * Problem: Reverse Node in k-Group
 * Source: https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Note:
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Solution:
 * First check k, if k == 0 or k == 1, return. Then check how many times we need
 * to reverse the list. Then reverse each part.
 * 
 * Or we could combine the length check and reverse together to sweep the list only
 * one pass.
 */
public class ReverseNodeinKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 0 || k == 1)
			return head;
		ListNode temp = head;
		int count = 0;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		int cnt = count / k;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode temp1 = head, temp2 = dummy;
		for(int i = 0; i < cnt; i++) {
			int n = k;
			while(n > 1) {
				temp = temp1.next;
				temp1.next = temp.next;
				temp.next = temp2.next;
				temp2.next =temp;
				n--;
			}
			temp2 = temp1;
			temp1 = temp1.next;
		}
		return dummy.next;
	}
	
	public ListNode reverseKGroup2(ListNode head, int k) {
		if(k == 0 || k == 1)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode temp1 = head, temp2 = dummy;
		while(true) {
			int cnt = 0;
			ListNode temp = temp1;
			while(temp != null && cnt < k) {
				temp = temp.next;
				cnt++;
			}
			if(cnt < k)
				break;
			while(cnt > 1) {
				temp = temp1.next;
				temp1.next = temp.next;
				temp.next = temp2.next;
				temp2.next = temp;
				cnt--;
			}
			temp2 = temp1;
			temp1 = temp1.next;
		}
		return dummy.next;
	}
}
