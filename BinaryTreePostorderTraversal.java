/*
 * Author: Yang Pei
 * Problem: Binary Tree Postorder Traversal
 * Source: https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Note:
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
   return [3,2,1].
   
   Solution:
   Recursive method.
   Iterative method with two stacks. The first stack use for preorder traveral but
   reverse the order of left child and right child. The second one used for store the 
   node.
   Iterative method with one stacks. Need to check the pre TreeNode.
   Morris method which is quite complicated.
 */
import java.util.*;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		stack1.push(root);
		while(stack1.size() != 0) {
			TreeNode temp = stack1.pop();
			stack2.push(temp);
			if(temp.left != null)
				stack1.push(temp.left);
			if(temp.right != null)
				stack1.push(temp.right);
		}
		while(stack2.size() != 0) {
			TreeNode temp = stack2.pop();
			result.add(temp.val);
		}
		return result;
	}
	
	public List<Integer> postorederTraversal1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		TreeNode pre = null;
		stack.push(root);
		while(stack.size() != 0) {
			TreeNode temp = stack.pop();
			if(temp.left == null && temp.right == null) {
				result.add(temp.val);
				pre = temp;
			}
			else if(temp.left != null && temp.right == null) {
				if(pre == temp.left) {
					result.add(temp.val);
					pre = temp;
				}
				else {
					stack.push(temp);
					stack.push(temp.left);
				}
			}
			else {
				if(pre == temp.right) {
					result.add(temp.val);
					pre = temp;
				}
				else {
					stack.push(temp);
					stack.push(temp.right);
					if(temp.left != null)
						stack.push(temp.left);
				}
			}
		}
		return result;
	}
}
