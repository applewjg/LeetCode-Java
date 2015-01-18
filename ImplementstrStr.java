/*
 * Author: Yang Pei
 * Problem: Implement strStr
 * Source: https://oj.leetcode.com/problems/implement-strstr/
 * 
 * Note:
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Solution:
 * Brute force method.
 * RK algorithm.
 * KMP algorithm.
 */
import java.util.*;
public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();
		for(int i = 0; i <= n - m; i++) {
			int j = 0;
			for(; j < m; j++) {
				if(haystack.charAt(i+j) != needle.charAt(j))
					break;
			}
			if(j == m)
				return i;
		}
		return -1;
	}
	
	public int strStr1(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();
		int prime = 9973;
		int h = 1, h1 = 0, h2 = 0;
		if(n < m)
			return -1;
		for(int i = 0; i < m; i++) {
			h1 = (h1 * 256 + haystack.charAt(i)) % prime;
			h2 = (h2 * 256 + needle.charAt(i)) % prime;
		}
		for(int i = 0; i < m-1; i++)
			h = (h * 256) % prime;
		for(int i = 0; i <= n-m; i++) {
			if(h1 == h2) {
				int j = 0;
				for(; j < m; j++) {
					if(haystack.charAt(i+j) != needle.charAt(j))
						break;
				}
				if(j == m)
					return i;
			}
			if(i < n-m)
				h1 = ((h1 - haystack.charAt(i)*h) * 256 + haystack.charAt(i+m)) % prime;
			if(h1 < 0)
				h1 = h1 + prime;
		}
		return -1;
	}
	
	public static int strStr2(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();
		if(m == 0)
			return 0;
		int[] next = new int[m];
		next[0] = 0;
		int j = 0;
		for(int i = 1; i < m; i++) {
			if(needle.charAt(i) == needle.charAt(j)) {
				j++;
				next[i] = j;
			}
			else {
				while(j > 0 && needle.charAt(i) != needle.charAt(j))
					j = next[j-1];
				if(needle.charAt(i) != needle.charAt(j))
					j--;
				j++;
				next[i] = j;
				
			}
		}

		int ind1 = 0, ind2 = 0;
		while(ind1 < n && ind2 < m) {
			if(haystack.charAt(ind1) == needle.charAt(ind2)) {
				ind1++; ind2++;
			}
			else {
				if(ind2 == 0)
					ind1++;
				else {
					while(ind2 > 0 && haystack.charAt(ind1) != needle.charAt(ind2))
						ind2 = next[ind2 - 1];
				}
			}
		}
		if(ind2 == m)
			return ind1 - m;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String str1 = scan.next();
			String str2 = scan.next();
			System.out.println(strStr2(str1, str2));
		}
	}
}
