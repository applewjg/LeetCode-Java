/*
 * Author: Yang Pei
 * Problem: Color Sort
 * Source: https://oj.leetcode.com/problems/sort-colors/
 * 
 * Note:
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Solution:
 * Use count sort or use three pointers.
 */
public class ColorSort {
	public void sortColors(int[] A) {
		int n = A.length;
        if(n == 0)
            return;
        int[] count = new int[3];
        for(int i = 0; i < n; i++) {
            count[A[i]]++;
        }
        int index = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < count[i]; j++) {
                A[index++] = i;
             }
        }
	}
	
	public void sortColors1(int[] A) {
        int n = A.length;
        if(n == 0)
            return;
        int ind1 = -1, ind2 = n;
        for(int i = 0; i < ind2; i++) {
            if(A[i] < 1) {
                ind1++;
                int temp = A[ind1];
                A[ind1] = A[i];
                A[i] = temp;
            }
            else if(A[i] > 1) {
                ind2--;
                int temp = A[ind2];
                A[ind2] = A[i];
                A[i] = temp;
                i--;
            }
        }
    }
}
