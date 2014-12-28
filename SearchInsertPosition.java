/*
 * Author: Yang Pei
 * Problem: Search Insert Position
 * Source: https://oj.leetcode.com/problems/search-insert-position/
 * 
 * Note:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * Solution:
 * Binary search. If not exist, l will be the position to insert the target.
 * 
 * Follow up:
 * What if there is duplicates in the array?
 * Return the first/last occurance of the target?
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int l = 0, r = A.length - 1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(A[mid] == target)
				return mid;
			else if(A[mid] > target)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}
}
