/*
 * Author: Yang Pei
 * Problem: Search in Rotated Sorted Array II
 * Source: https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Note:
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 * Solution:
 * Binary search method:
 * 		Since there are duplicates, we only move l and r when A[l] < A[mid] and 
 * 		A[mid] < A[r] (since we know for sure where the target should be). If either
 * 		A[mid] == A[l] or A[mid] == A[r], we could not locate the position of target
 * 		so we just move the one the equals to the mid.
 */
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int l = 0, r = A.length - 1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(A[mid] == target)
				return true;
			if(A[l] < A[mid]) {
				if(A[l] <= target && target < A[mid])
					r = mid - 1;
				else
					l = mid + 1;
			}
			else if(A[mid] < A[r]) {
				if(A[mid] < target && target <= A[r])
					l = mid + 1;
				else
					r = mid - 1;
			}
			else if(A[mid] == A[l])
				l++;
			else
				r--;
		}
		return false;
	}
}
