/*
 * Author: Yang Pei
 * Problem: Combination Sum II
 * Source: https://oj.leetcode.com/problems/combination-sum-ii/
 * 
 * Note:
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * 
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * Solution:
 * Depth Limited DFS.
 * 
 * Follow up:
 * Check if we could use the elements in the array to form the target value.
 */
import java.util.*;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		Arrays.sort(num);
		dfs(num, 0, 0, target, current, result);
		return result;
	}
	
	private void dfs(int[] num, int beg, int sum, int target, 
			List<Integer> current, List<List<Integer>> result) {
		if(sum > target)
			return;
		else if(sum == target) {
			result.add(new ArrayList<Integer>(current));
		}
		else {
			for(int i = beg; i < num.length; i++) {
				if(i != beg && num[i] == num[i-1])
					continue;
				current.add(num[i]);
				dfs(num, i+1, sum+num[i], target, current, result);
				current.remove(current.size() - 1);
			}
		}
	}
}
