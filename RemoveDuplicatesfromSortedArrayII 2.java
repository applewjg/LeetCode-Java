/*
 * Author: Yang Pei
 * Problem: Remove Duplicate from Sorted Array II
 * Source: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * 
 * Note:
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * Solution:
 * Two pointers, one to check all elements and one to hold the tail of the processed array.
 * Use a counter to hold the times one element appears.
 */
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		int n = A.length;
		if(n == 0 || n == 1)
			return n;
		int index = 0;
		int cnt = 1;
		for(int i = 1; i < n; i++) {
			if(A[index] != A[i]) {
				A[++index] = A[i];
				cnt = 1;
			}
			else {
				if(cnt < 2) {
					A[++index] = A[i];
					cnt++;
				}
			}
		}
		return index + 1;
	}
}
