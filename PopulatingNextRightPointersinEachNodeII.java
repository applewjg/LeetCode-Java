/*
 * Author: Yang Pei
 * Problem: Populating Next Right Pointers in Each Node II
 * Source: https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Note:
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Solution:
 * BFS.
 */
public class PopulatingNextRightPointersinEachNodeII {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			this.val = x;
		}
	}
	public void connect(TreeLinkNode root) {
		while(root != null) {
			TreeLinkNode pre = null, next = null;
			while(root != null) {
				if(next == null)
					next = root.left == null ? root.right : root.left;
				if(root.left != null) {
					if(pre != null)
						pre.next = root.left;
					pre = root.left;
				}
				if(root.right != null) {
					if(pre != null)
						pre.next = root.right;
					pre = root.right;
				}
				root = root.next;
			}
			root = next;
		}
	}
}
