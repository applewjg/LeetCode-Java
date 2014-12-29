/*
 * Author: Yang Pei
 * Problem: Text Justification
 * Source: https://oj.leetcode.com/problems/text-justification/
 * 
 * Note:
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * Solution:
 * Use one function to determine the words, use one function to make the line.
 * 
 * Corner case:
 * The last line and the line with only one words, we should left-justified.
 */
import java.util.*;

public class TextJustification {
	private int wordCount(String[] words, int beg, int L) {
		// return the first of next line's word's index
		int count = 0;
		int i = beg;
		for(i = beg; i < words.length; i++) {
			count = count + words[i].length();
			if(count > L)
				break;
			count = count + 1;
		}
		return i;
	}
	
	private String newLine(String[] words, int beg, int end, int L) {
		int count = 0;
		for(int i = beg; i < end; i++)
			count = count + words[i].length();
		int number = end - beg;
		int blank = number == 1 ? ((L - count) / (number - 1)) : L - count;
		int extra = number == 1 ? ((L - count) % (number - 1)) : 0;
		String bl = "";
		for(int i = 0; i < blank; i++)
			bl = bl + " ";
		StringBuffer line = new StringBuffer();
		for(int i = beg; i < end; i++) {
			line.append(words[i]);
			if(beg != i && i == end - 1)
				break;
			line.append(bl);
			if(extra > 0) {
				line.append(" ");
				extra--;
			}
		}
		return line.toString();
	}
	
	private String lastLine(String[] words, int beg, int L) {
		StringBuffer line = new StringBuffer();
		for(int i = beg; i < words.length; i++) {
			line.append(words[i]);
			if(i != words.length - 1)
				line.append(" ");
		}
		int blank = L - line.length();
		for(int i = 0; i < blank; i++)
			line.append(" ");
		return line.toString();
	}
	
	public List<String> fullJustify(String[] words, int L) {
		int ind = 0;
		List<String> result = new ArrayList<String>();
		while(ind < words.length) {
			int beg = ind;
			ind = wordCount(words, beg, L);
			if(ind == words.length)
				result.add(lastLine(words, beg, L));
			else
				result.add(newLine(words, beg, ind, L));
		}
		return result;
	}
}
