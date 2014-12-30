/*
 * Author: Yang Pei
 * Problem: Search in Rotated Sorted Array
 * Source: https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Note:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * Solution:
 * Naive method: sweep the entire array and find the target ---> takes O(n) time.
 * Binary search method:
 * 		Use the condition of A[mid] with A[l] and A[r] together to check target located
 * 		in which parts.
 * 			if A[l] <= A[mid] and target >= A[l] and target < A[mid], r <--- mid - 1.
 * 			otherwise l <--- mid + 1.
 * 			if A[mid] < A[r] (only two conditions) and target > A[mid] and A[r] >= target
 * 			, l <--- mid + 1.
 * 			otherwise r <--- mid - 1.
 * 
 * Follow up:
 * Given a sorted array, assume no duplicates in it. Split the array into three parts and
 * then swap their position. given a target, search the position of it.
 */
public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
		int l = 0, r = A.length - 1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(A[mid] == target)
				return mid;
			if(A[l] <= A[mid]) {
				if(A[l] <= target && target < A[mid])
					r = mid - 1;
				else
					l = mid + 1;
			}
			else {
				if(A[mid] < target && target <= A[r])
					l = mid + 1;
				else
					r = mid - 1;
			}
		}
		return -1;
	}
}
