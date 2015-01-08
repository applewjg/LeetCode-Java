import java.util.Set;

/*
 * Author: Yang Pei
 * Problem: Word Break
 * Source: https://oj.leetcode.com/problems/word-break/
 * 
 * Note:
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * Solution:
 * Use dp method to record if s[0...i] could be represented or not.
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		int n = s.length();
		if(n == 0)
			return false;
		boolean[] dp = new boolean[n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					if(dict.contains(s.substring(0, i+1)))
						dp[i] = true;
				}
				else {
					if(dp[j-1] == true && dict.contains(s.substring(j, i+1)))
						dp[i] = true;
				}
			}
		}
		return dp[n-1];
	}
}
