/*
 * Author: Yang Pei
 * Problem: Compare Version Numbers
 * Source: https://oj.leetcode.com/problems/compare-version-numbers/
 * 
 * Note:
 * Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * Solution:
 * Split the version according to the ".", then compare each number. Pay attention to
 * leading zeros. If each version number is within the Integer, we could use Integer.paresInt
 * instead of writing a function to compare.
 * 
 * Corner case: 1.0 and 1, 1.0.1 and 1. In this case, we need to check the array with
 * more split to see if each number is 0 or not.	
 */
public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
		String[] strs1 = version1.split("\\.");
		String[] strs2 = version2.split("\\.");
		for(int i = 0; i < Math.min(strs1.length, strs2.length); i++) {
			if(compare(strs1[i], strs2[i]) != 0)
				return compare(strs1[i], strs2[i]);
		}
		if(strs1.length < strs2.length) {
			for(int i = strs1.length; i < strs2.length; i++) {
				if(compare("0", strs2[i]) < 0)
					return -1;
			}
			return 0;
		}	
		else if(strs1.length > strs2.length) {
			for(int i = strs2.length; i < strs1.length; i++) {
				if(compare(strs1[i], "0") > 0)
					return 1;
			}
			return 0;
		}
		else
			return 0;
	}
	private static int compare(String num1, String num2) {
		int ind1 = 0;
		while(ind1 < num1.length() && num1.charAt(ind1) == '0')
			ind1++;
		int ind2 = 0;
		while(ind2 < num2.length() && num2.charAt(ind2) == '0')
			ind2++;
		num1 = num1.substring(ind1);
		num2 = num2.substring(ind2);
		if(num1.length() < num2.length())
			return -1;
		else if(num1.length() > num2.length())
			return 1;
		else {
			for(int i = 0; i < num1.length(); i++) {
				if(num1.charAt(i) < num2.charAt(i))
					return -1;
				else if(num1.charAt(i) > num2.charAt(i))
					return 1;
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		String version1 = "1.0.1";
		String version2 = "1";
		System.out.println(compareVersion(version1, version2));
	}
}
