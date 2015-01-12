/*
 * Author: Yang Pei
 * Problem: Given a linked list of line segments, remove middle points
 * Source: http://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/
 * 
 * Note:
 * Given a linked list of co-ordinates where adjacent points either form a vertical line or a horizontal line. 
 * Delete points from the linked list which are in the middle of a horizontal or vertical line.
 * 
 * Solution:
 * Use two pointers. We assume that the list is aligned, that is no backward segments.
 */
public class RemoveMiddlePoints {
	private static class ListNode {
		int x, y;
		ListNode next;
		public ListNode(int x, int y) {
			this.x = x;
			this.y = y;
			this.next = null;
		}
	}
	
	public static ListNode removeMiddle(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode start = head, end = head;
		boolean horz = true;
		while(end.next != null) {
			if(horz == true) {
				if(end.next.y != start.y) {
					if(start != end)
						start.next = end;
					start = end;
					horz = false;
				}
			}
			else {
				if(end.next.x != start.x) {
					if(start != end)
						start.next = end;
					start = end;
					horz = true;
				}
			}
			end = end.next;
		}
		if(start != end)
			start.next = end;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(7, 11);
		ListNode temp = head;
		//temp.next = new ListNode(5, 10);
		//temp = temp.next;
		temp.next = new ListNode(7, 10);
		temp = temp.next;
		//temp.next = new ListNode(7, 5);
		//temp = temp.next;
		//temp.next = new ListNode(20, 5);
		//temp = temp.next;
		//temp.next = new ListNode(40, 5);
		removeMiddle(head);
		temp = head;
		while(temp != null) {
			System.out.println(temp.x + " " + temp.y);
			temp = temp.next;
		}
	}
}
