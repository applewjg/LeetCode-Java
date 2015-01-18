/*
 * Author: Yang Pei
 * Problem: Longest Substring Without Repeating Characters
 * Source: https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Note:
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * Solution:
 * Naive method is to enumerate all possible substrings and check their validation
 * Maintain a sliding window to hold the current valid substring and shrink from
 * the left side of the window if the condition is voliated.
 * 
 * Follow up:
 * What if each characters to appear at most k times? We could use a HashMap instead
 * of a HashSet to keep the window.
 * 
 */
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int res = 0, n = s.length(), index = 0;
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0; i < n; i++) {
			if(set.contains(s.charAt(i)) == false) {
				set.add(s.charAt(i));
			}
			else {
				while(index <= i && s.charAt(index) != s.charAt(i)) {
					set.remove(s.charAt(index));
					index++;
				}
				index++;
			}
			res = Math.max(res, i - index + 1);
		}
		return res;
	}
}
