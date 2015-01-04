/*
 * Author: Yang Pei
 * Problem: Print BST
 * Source: http://www.careercup.com/question?id=5665654537453568
 * 
 * Note:
 * Given a BST, print it out like a tree just what we see on textbooks with new lines
 * and indentation.
 * 
 * Solution:
 * Inorder traverse the tree, put each node on a distinct column. Use a list to store
 * the content of the string on each layer. 
 */
import java.util.*;
public class PrintBST {
	private static int inorder(TreeNode root, int col, int layer, List<String> result) {
		if(root == null)
			return col;
		if(result.size() <= layer)
			result.add("");
		int ind = inorder(root.left, col, layer+1, result);
		StringBuilder sb = new StringBuilder(result.get(layer));
		int beg = sb.length();
		for(int i = beg; i < ind; i++)
			sb.append(" ");
		sb.append(root.val);
		result.set(layer, sb.toString());
		return inorder(root.right, ind+1, layer+1, result);
	}
	
	public static void printBST(TreeNode root) {
		List<String> result = new ArrayList<String>();
		inorder(root, 0, 0, result);
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		printBST(node1);
	}
}
