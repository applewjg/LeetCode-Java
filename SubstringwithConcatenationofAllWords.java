/*
 * Author: Yang Pei
 * Problem: Substring with Concatenation of All Words
 * Source: https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * Note:
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * 
 * Solution:
 * Brute force, assume L contains duplicate words, we use a HashMap to record each
 * words count.
 * 
 * Follow up:
 * Find a shortest substring of S that contains all the words in L, assume there are no
 * duplicates in L.
 */
import java.util.*;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		int n = L.length;
		int m = L[0].length();
		List<Integer> result = new ArrayList<Integer>();
		if(S.length() < m*n)
			return result;
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		for(int i = 0; i < n; i++) {
			if(map1.containsKey(L[i]))
				map1.put(L[i], map1.get(L[i]) + 1);
			else
				map1.put(L[i], 1);
		}
		for(int i = 0; i <= S.length() - m*n; i++) {
			boolean stat = true;
			map2.clear();
			for(int j = i; j < i+m*n; j += m) {
				String str = S.substring(j, j+m);
				if(map1.containsKey(str) == false) {
					stat = false;
					break;
				}
				else {
					if(map2.containsKey(str) == false) 
						map2.put(str, 1);
					else {
						if(map2.get(str) >= map1.get(str)) {
							stat = false;
							break;
						}
						else 
							map2.put(str, map2.get(str) + 1);
					}
				}
			}
			if(stat == true)
				result.add(i);
		}
		return result;
	}
}
