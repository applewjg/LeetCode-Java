/*
 * Author: Yang Pei
 * Problem: Letter Combinations of a Phone Number
 * Source: https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Note:
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * Solution:
 * Depth limited DFS.
 * 
 * Follow up:
 * Given a array of letter combinations which is sorted. How to search for all match
 * combinations of a phone number in this array?
 */
import java.util.*;

public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		char[][] phone = new char[][] {{' '}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, 
				{'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
		List<String> result = new ArrayList<String>();
		dfs(0, digits, "", phone, result);
		return result;
	}
	
	private void dfs(int dep, String digits, String current, char[][] phone, List<String> result) {
		if(digits.length() == dep) {
			result.add(current);
		}
		else {
			int num = digits.charAt(dep) - '0';
			for(int i = 0; i < phone[num].length; i++) {
				dfs(dep+1, digits, current+phone[num][i], phone, result);
			}
		}
	}
}
