/*
 * Author: Yang Pei
 * Problem: Find Minimum in Rotated Sorted Array
 * Source: https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Note:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * Solution:
 * Binary search. Since there are no duplicates(important):
 * 		If A[l] <= A[r], we know A[l] would be the answer
 * 		Otherwise, we check the relationship of A[mid] with A[l] and A[r]
 * 			If A[mid] >= A[l], we know from A[l] ... A[mid] is increasing and A[mid] could 
 * 			not be the minimum
 * 			otherwise, we know from A[mid] ... A[r] is increasing and A[mid] could
 * 			be the minimum
 * 
 * Follow up:
 * Find largest in rotated sorted array.
 */
public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] num) {
		int l = 0, r = num.length - 1;
		while(l <= r) {
			if(num[l] <= num[r])
				return num[l];
			int mid = l + (r - l) / 2;
			if(num[mid] >= num[l])
				l = mid + 1;
			else
				r = mid;
		}
		return num[l];
	}
}
