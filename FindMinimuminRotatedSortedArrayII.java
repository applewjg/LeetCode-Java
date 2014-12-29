/*
 * Author: Yang Pei
 * Problem: Find Minimum in Rotated Sorted Array II
 * Source: https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 
 * Note:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 * 
 * Solution:
 * Binary Search. Since we have duplicates now, we need to break ice when we
 * compare A[mid] and A[l], A[r]
 * 		If A[l] < A[r], we know for sure that A[l] would be the answer.
 * 		If A[l] == A[r], we don't know whether A[l] is minimum or not.
 * 		Otherwise, if A[l] < A[mid], we could set l <--- mid + 1
 * 				else if A[mid] < A[r], we could set r <--- mid
 * 				else we have a situation where A[l] == A[mid]
 * 				or A[r] == A[mid], we move l <-- l+1
 * 		When we are out of the loop, we return r, since we r is always the candidate
 * 		of the minimum according to our operations.
 * The key idea in such problem is that when we are sure to cut half of the search
 * space, we just cut it, otherwise we could only gradually change the search space.
 * 
 * Follow up:
 * Find largest in rotated sorted array.
 */

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] num) {
    	int l = 0, r = num.length - 1;
    	while(l <= r) {
    		if(num[l] < num[r])
    			return num[l];
    		int mid = l + (r - l) / 2;
    		if(num[l] < num[mid])
    			l = mid + 1;
    		else if(num[mid] < num[r])
    			r = mid;
    		else
    			l++;
    	}
    	return num[r];
    }
    
}
