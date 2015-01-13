/*
 * Author: Yang Pei
 * Problem: Count and Say
 * Source: https://oj.leetcode.com/problems/count-and-say/
 * 
 * Note:
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Soltuion:
 * Implementation. 
 */
public class CountandSay {
    public String countAndSay(int n) {
        String str = "1";
        while(n > 1) {
            StringBuilder sb = new StringBuilder();
            int ind1 = 0, ind2 = 0;
            while(ind1 < str.length()) {
                while(ind2 < str.length() && str.charAt(ind2) == str.charAt(ind1))
                    ind2++;
                sb.append(ind2 - ind1);
                sb.append(str.charAt(ind1));
                ind1 = ind2;
            }
            str = sb.toString();
            n--;
        }
        return str;
    }
}
