/*
 * Author: Yang Pei
 * Problem: Path Sum II
 * Source: https://oj.leetcode.com/problems/path-sum-ii/
 * 
 * Note:
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * Solution:
 * Preorder traversal.
 */
import java.util.*;
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		dfs(root, sum, list, result);
		return result;
	}
	
	private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
		if(root == null)
			return;
		if(root.left == null && root.right == null) {
			if(sum == root.val) {
				list.add(root.val);
				result.add(new ArrayList<Integer>(list));
				list.remove(list.size() - 1);
			}
		}
		else if(root.left != null && root.right == null) {
			list.add(root.val);
			dfs(root.left, sum - root.val, list, result);
			list.remove(list.size() - 1);
		}
		else if(root.left == null && root.right != null) {
			list.add(root.val);
			dfs(root.right, sum - root.val, list, result);
			list.remove(list.size() - 1);
		}
		else {
			list.add(root.val);
			dfs(root.left, sum - root.val, list, result);
			dfs(root.right, sum - root.val, list, result);
			list.remove(list.size() - 1);
		}
	}
}
