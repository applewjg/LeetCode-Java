/*
 * Author: Yang Pei
 * Problem: Reverse Words in a String
 * Source: https://oj.leetcode.com/problems/reverse-words-in-a-string/
 * 
 * Note:
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * 
 * Solution:
 * Two methods:
 * 		Use split method to split the string into words and then reverse the order.
 * 		Use two pointers to split the string.
 * 		Use recursive method to reverse the order of words.
 * 
 * Follow up:
 * Reverse each words itself instead of order.
 */
public class ReverseWordsinaString {
	public String reverseWords(String s) {
		s = s.trim();
		if(s.length() == 0)
			return s;
		String[] words = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int i = words.length-1; i >= 0; i--) {
			sb.append(words[i]);
			sb.append(" ");
		}
		return sb.substring(0, sb.length() - 1);
	}
	
	public String reverseWords1(String s) {
		s = s.trim();
		if(s.length() == 0)
			return s;
		int ind1 = s.length() - 1, ind2 = s.length() - 1;
		StringBuilder sb = new StringBuilder();
		while(ind1 >= 0) {
			while(ind2 >= 0 && s.charAt(ind2) == ' ')
				ind2--;
			ind1 = ind2;
			while(ind2 >= 0 && s.charAt(ind2) != ' ')
				ind2--;
			sb.append(s.substring(ind2+1, ind1+1));
			sb.append(" ");
			ind1 = ind2;
		}
		return sb.substring(0, sb.length() - 1);
	}
	
	public String reverseWords2(String s) {
		s = s.trim();
		if(s.length() == 0)
			return "";
		int ind = 0;
		while(ind < s.length() && s.charAt(ind) != ' ')
			ind++;
		String res = reverseWords(s.substring(ind));
		if(res.equals(""))
			return s.substring(0, ind);
		else
			return res + " " + s.substring(0, ind);
	}
}
