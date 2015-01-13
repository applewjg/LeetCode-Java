/*
 * Author: Yang Pei
 * Problem: Valid Palindrome
 * Source: https://oj.leetcode.com/problems/valid-palindrome/
 * 
 * Note:
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Solution:
 * Two pointers.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.equals(""))
            return true;
        s = s.toLowerCase();
        int ind1 = 0, ind2 = s.length() - 1;
        while(ind1 < ind2) {
            while(ind1 < ind2 && !((s.charAt(ind1) >= 'a' && s.charAt(ind1) <= 'z') || (s.charAt(ind1) >= '0' && s.charAt(ind1) <= '9')))
            ind1++;
            while(ind1 < ind2 && !((s.charAt(ind2) >= 'a' && s.charAt(ind2) <= 'z') || (s.charAt(ind2) >= '0' && s.charAt(ind2) <= '9')))
            ind2--;
            if(s.charAt(ind1) != s.charAt(ind2))
                return false;
            ind1++; ind2--;
        }
        return true;
    }
}
