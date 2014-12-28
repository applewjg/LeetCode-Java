/*
 * Author: Yang Pei
 * Problem: Remove Element
 * Source: https://oj.leetcode.com/problems/remove-element/
 * 
 * Note:
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Solution:
 * Two pointers.
 * 
 * Be careful here we should initialize index to -1.
 * Follow up:
 * What if the array is sorted?
 * 		We could use binary search to reduce the time to O(logn).
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int n = A.length;
		int index = -1;
		for(int i = 0; i < n; i++) {
			if(A[i] != elem) 
				A[++index] = A[i];
		}
		return index+1;
	}
}
