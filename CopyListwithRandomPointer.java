/*
 * Author: Yang Pei
 * Problem: Copy List with Random Pointer
 * Source: https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Note:
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * Solution:
 * Use a hashmap to record the mapping relation of the original node and the copied one.
 * Another way is to insert the copied node into the original list and then split the list.
 */
import java.util.*;

public class CopyListwithRandomPointer {
	private class RandomListNode {
		int label;
		RandomListNode next, random;
		public RandomListNode(int label) {
			this.label = label;
		}
	}
	
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode temp1 = head, temp2 = dummy;
        while(temp1 != null) {
            RandomListNode node = new RandomListNode(temp1.label);
            map.put(temp1, node);
            temp2.next = node;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1 = head; temp2 = dummy.next;
        while(temp1 != null) {
            if(temp1.random != null) {
                temp2.random = map.get(temp1.random);
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return dummy.next;
    }
    
    public RandomListNode copyRandomList1(RandomListNode head) {
    	if(head == null)
    		return head;
    	RandomListNode temp = head;
    	while(temp != null) {
    		RandomListNode node = new RandomListNode(temp.label);
    		node.next = temp.next;
    		temp.next = node;
    		temp = node.next;
    	}
    	temp = head;
    	while(temp != null) {
    		if(temp.random != null) {
    			temp.next.random = temp.random.next;
    		}
    		temp = temp.next.next;
    	}
    	RandomListNode dummy = new RandomListNode(0);
    	RandomListNode temp1 = dummy;
    	temp = head;
    	while(temp != null) {
    		temp1.next = temp.next;
    		temp.next = temp.next.next;
    		temp = temp.next;
    		temp1 = temp1.next;
    	}
    	return dummy.next;
    }
}
