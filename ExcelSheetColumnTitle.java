/*
 * Author: Yang Pei
 * Problem: Excel Sheet Column Title
 * Source: https://oj.leetcode.com/problems/excel-sheet-column-title/
 * 
 * Note:
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 * Solution:
 * Recursive method or iterative method. 
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if(n == 0)
			return "";
		return convertToTitle((n-1)/26) + (char)((n-1)%26 + 'A');
	}
	
	public String convertToTitle1(int n) {
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			sb.append((char)((n - 1) % 26 + 'A'));
			n = (n - 1) / 26;
		}
		sb = sb.reverse();
		return sb.toString();
	}
}
