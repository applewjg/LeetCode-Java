/*
 * Author: Yang Pei
 * Problem: Find Peak Element
 * Source: https://oj.leetcode.com/problems/find-peak-element/
 * 
 * Note:
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 * Solution:
 * Naive method: sweep the entire array and find the peak element --> take O(n) time
 * 
 * Binary search method: key idea is to drop as much as portion of array as possible.
 * 		We need to check the condition of num[mid] with num[mid+1] to determine
 * 		how we drop the array.
 * 			If num[mid] < num[mid+1], we know mid would not be the answer
 * 			and there must exist a peak from mid+1 to r, we set l <-- mid+1.
 * 			Otherwise we have num[mid] > num[mid+1], we know mid could be the answer
 * 			and there must exist a peak from l to mid, we set r <-- mid.
 * 			When mid == num.length - 1, this indicate that the last element is a peak,
 * 			we just l <-- l+1 to break out the loop.
 * 			When l == r, according to our operation, we know this would be a peak, we
 * 			could break out the loop, so in the outer loop, we set the condition to
 * 			"l < r" instead of "l <= r".
 * 
 * Attention:
 * Pay attention to the condition in the outer while loop, if "l <= r" set, it would
 * involve in infinite loop.
 */
public class FindPeakElement {
	public int findPeakElement(int[] num) {
		int l = 0, r = num.length - 1;
		while(l < r) {
			int mid = l + (r - l) / 2;
			if(mid < num.length - 1) {
				if(num[mid] < num[mid + 1])
					l = mid + 1;
				else
					r = mid;
			}
			else
				l = mid + 1;
		}
		return r;
	}
}
