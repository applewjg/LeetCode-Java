/*
 * Author: Yang Pei
 * Problem: Longest Consecutive Sequence
 * Source: https://oj.leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Note:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 * Solution:
 * Treat each consecutive elements sequence as a connected component and find the 
 * largest one. Any elements in the same connected component could be removed once
 * has ever been checked.
 * 
 * Follow up:
 * What if we could not use additional space but could sacrifices a little time 
 * complexity? We could first sort the array and then find the longest consecutive
 * sequence.
 * Find the number of consecutive sequence in the array. Just equal to count the 
 * number of connected component. 
 * 
 */
import java.util.*;
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		int n = num.length;
		int res = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < n; i++)
			set.add(num[i]);
		for(int i = 0; i < n; i++) {
			if(set.contains(num[i])) {
				int cnt = 1;
				set.remove(num[i]);
				int left = num[i] - 1;
				while(set.contains(left)) {
					cnt++;
					set.remove(left);
					left--;
				}
				int right = num[i] + 1;
				while(set.contains(right)) {
					cnt++;
					set.remove(right);
					right++;
				}
				res = Math.max(res, cnt);
			}
		}
		return res;
	}
}
