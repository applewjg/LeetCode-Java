/*
 * Author: Yang Pei
 * Problem: Merge Sorted Array
 * Source: https://oj.leetcode.com/problems/merge-sorted-array/
 * 
 * Note:
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * Solution:
 * Three Pointers. Merge from the tails of the two array.
 * 
 * 
 */
public class MergeSortedArray {
	public void merge(int[] A, int m, int[] B, int n) {
		int index = m + n - 1;
		int ind1 = m - 1;
		int ind2 = n - 1;
		while(ind1 >= 0 && ind2 >= 0) {
			if(A[ind1] >= B[ind2])
				A[index--] = A[ind1--];
			else
				A[index--] = B[ind2--];
		}
		if(ind2 >= 0) {
			while(ind2 >= 0)
				A[index--] = B[ind2--];
		}
	}
}
