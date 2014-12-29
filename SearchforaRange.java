/*
 * Author: Yang Pei
 * Problem: Search for a Range
 * Source: https://oj.leetcode.com/problems/search-for-a-range/
 * 
 * Note:
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * Solution:
 * Binary search, find the first and last occurance.
 * 
 * Follow up:
 * Given a sorted array, return the times of apperance of a target.
 * What if the array is rotated at some position?
 * 		First, find the position of the rotate position ---> O(logn)
 * 		Second, search for range on the two segnment ---> O(logn)
 */
public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		result[0] = findFirst(A, target);
		result[1] = findLast(A, target);
		return result;
	}
	
	private int findFirst(int[] A, int target) {
		int l = 0, r = A.length - 1, index = -1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(A[mid] == target) {
				index = mid;
				r = mid - 1;
			}
			else if(A[mid] > target) 
				r = mid - 1;
			else
				l = mid + 1;
		}
		return index;
	}
	
	private int findLast(int[] A, int target) {
		int l = 0, r = A.length - 1, index = -1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(A[mid] == target) {
				index = mid;
				l = mid + 1;
			}
			else if(A[mid] > target) 
				r = mid - 1;
			else
				l = mid + 1;
		}
		return index;
	}
}
