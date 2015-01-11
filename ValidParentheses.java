/*
 * Author: Yang Pei
 * Problem: Valid Parentheses
 * Source: https://oj.leetcode.com/problems/valid-parentheses/
 * 
 * Note:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * Solution:
 * Use stack.
 */
import java.util.*;
public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{')
				stack.push(ch);
			else if(ch == ')') {
				if(stack.size() > 0 && stack.peek() == '(')
					stack.pop();
				else
					return false;
			}
			else if(ch == ']') {
				if(stack.size() > 0 && stack.peek() == '[')
					stack.pop();
				else
					return false;
			}
			else {
				if(stack.size() > 0 && stack.peek() == '{')
					stack.pop();
				else
					return false;
			}
		}
		if(stack.size() == 0)
			return true;
		else
			return false;
	}
}
