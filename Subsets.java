/*
 * Author: Yang Pei
 * Problem: Subsets
 * Source: https://oj.leetcode.com/problems/subsets/
 * 
 * Note:
 * Given a set of distinct integers, S, return all possible subsets.
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * Solution:
 * Recursion.
 */
import java.util.*;

public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(S);
		recur(0, S, list, result);
		return result;
	}
	
	private void recur(int ind, int[] S, List<Integer> list, List<List<Integer>> result) {
		result.add(new ArrayList<Integer>(list));
		for(int i = ind; i < S.length; i++) {
			if(i > ind && S[i] == S[i-1])
				continue;
			list.add(S[i]);
			recur(i+1, S, list, result);
			list.remove(list.size() - 1);
		}
	}
}
