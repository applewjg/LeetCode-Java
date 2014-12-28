/*
 * Author: Yang Pei
 * Problem: Remove Duplicates from Sorted Array
 * Source: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Note:
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * Solution:
 * Use two pointers, one check all elements in the array, the other hold the tail of the array after process.
 * 
 * Be careful with index++ and ++index
 * 
 * Follow Up:
 * What if the array is not sorted?
 * 		Sort it, take O(nlogn) time
 * 		Use HashSet, take O(n) additional space
 * 		Two for loop, take O(n^2) time
 */
public class RemoveDuplicatesfromSortedArray {
	public static int removeDuplicates(int[] A) {
		int n = A.length;
		if(n == 0 || n == 1)
			return n;
		int index = 0;
		for(int i = 1; i < n; i++) {
			// we could change the condition here to solve different problem.
			if(A[i] != A[index])
				A[++index] = A[i];
		}
		return index+1;
	}
}
