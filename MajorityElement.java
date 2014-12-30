/*
 * Author: Yang Pei
 * Problem: Majority Element
 * Source: https://oj.leetcode.com/problems/majority-element/
 * 
 * Note:
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Solution:
 * Naive method: Use additional space to hold each element's appearances ---> O(n) space complexity
 * Greed method: Use a box to hold the majority candidate and count its number ---> O(1) space complexity
 * 
 * Follow up:
 * What if the array does not contain a major?
 * 		Final check the candidate to see if its count
 */
public class MajorityElement {
	public int majorityElement(int[] num) {
		int n = num.length;
		int major = 0, count = 0;
		for(int i = 0; i < n; i++) {
			if(count == 0) {
				major = num[i];
				count++;
			}
			else {
				if(major == num[i])
					count++;
				else
					count--;
			}
		}
		return major;
	}
}
