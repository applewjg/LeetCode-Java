/*
 * Author: Yang Pei
 * Problem: Palindrome Partition
 * Source: https://oj.leetcode.com/problems/palindrome-partitioning/
 * 
 * Note:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
   Soltuion:
   First try to find all palindrome exist in the string -- use dp method.
   Then find all possible partition method from head to tail -- recursion method.
   
   Also, we could write the entire code using only recursion, each time we need to 
   take additional time to check if the current substring is palindrome or not.
   
   Corner case: What should we return if the input is ""?
 */
import java.util.*;

public class PalindromePartition {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for(int i = n-1; i >= 0; i--) {
			for(int j = i; j < n; j++) {
				if(i == j)
					dp[i][j] = true;
				else if(i + 1 == j) {
					if(s.charAt(i) == s.charAt(j))
						dp[i][j] = true;
				}
				else {
					if(dp[i+1][j-1] == true && s.charAt(i) == s.charAt(j))
						dp[i][j] = true;
				}
			}
		}
		dfs(s, 0, list, result, dp);
		return result;
	}
	private void dfs(String s, int ind, List<String> list, List<List<String>> result, boolean[][] dp) {
		if(ind == s.length()) {
			result.add(new ArrayList<String>(list));
		}
		else {
			for(int i = ind; i < s.length(); i++) {
				if(dp[ind][i] == true) {
					list.add(s.substring(ind, i+1));
					dfs(s, i+1, list, result, dp);
					list.remove(list.size() - 1);
				}
			}
		}
	}
}
