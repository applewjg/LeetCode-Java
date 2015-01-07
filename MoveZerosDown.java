/*
 * Author: Yang Pei
 * Problem: Move Zeros Down
 * 
 * Note:
 * Given a binary tree, move the zeros to the bottom, so that if a node's value is 0,
 * any of its descendant are 0s.
 * For example:
 *      1
 *     / \
 *    0   0
 *   / \   \
 *  2   0   3
 * could be changed to 
 *      1
 *     / \
 *    2   3
 *   / \   \
 *  0   0   0   
 * 
 * Solution:
 * 		Use level traversal and then assign from back of the list to front, if we find
 * 		a node that is not 0 and we still have 0 to assign, record the value and change
 *      the node to 0, otherwise all 0 have assigned, when we meet a node that is 0, 
 *      assign a recorded value to it.
 *      Use preorder traversal, when a node is 0, try to find if there is a lowest descendent
 *      that is not 0, reutrn the node and change the value. 
 */
import java.util.*;

public class MoveZerosDown {
	public static void moveDown(TreeNode root) {
		if(root == null)
			return;
		List<TreeNode> list = new ArrayList<TreeNode>();
		int count = 0;
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		TreeNode dummy = new TreeNode(0);
		qu.add(root); qu.add(dummy);
		while(qu.size() != 0) {
			TreeNode temp = qu.remove();
			if(temp == dummy) {
				if(qu.size() != 0)
					qu.add(dummy);
			}
			else {
				count = count + ((temp.val == 0) ? 1 : 0);
				list.add(temp);
				if(temp.left != null)
					qu.add(temp.left);
				if(temp.right != null)
					qu.add(temp.right);
			}
		}
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = list.size() - 1; i >= 0; i--) {
			TreeNode temp = list.get(i);
			if(count > 0) {
				if(temp.val != 0) {
					stack.push(temp.val);
					temp.val = 0;
				}
				count--;
			}
			else {
				if(temp.val == 0 && stack.size() > 0)
					temp.val = stack.pop();
			}
		}
	}
	
	public static void moveDown1(TreeNode root) {
		if(root == null)
			return;
		if(root.val == 0) {
			TreeNode left = findNonZero(root.left);
			TreeNode right = findNonZero(root.right);
			if(left != null) {
				root.val = left.val;
				left.val = 0;
			}
			else if(right != null) {
				root.val = right.val;
				right.val = 0;
			}
		}
		moveDown1(root.left);
		moveDown1(root.right);
	}
	
	private static TreeNode findNonZero(TreeNode root) {
		if(root == null)
			return null;
		TreeNode left = findNonZero(root.left);
		TreeNode right = findNonZero(root.right);
		if(left != null)
			return left;
		else if(right != null)
			return right;
		if(root.val != 0)
			return root;
		return null;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		node1.left = new TreeNode(0);
		node1.right = new TreeNode(0);
		node1.left.left = new TreeNode(3);
		node1.left.left.left = new TreeNode(0);
		node1.left.right = new TreeNode(0);
		node1.right.right = new TreeNode(5);
		node1.left.right.left = new TreeNode(4);
		node1.left.right.right = new TreeNode(0);
		PrintBST.printBST(node1);
		moveDown1(node1);
		System.out.println("");
		PrintBST.printBST(node1);
	}
}
