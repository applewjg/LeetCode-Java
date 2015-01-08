/*
 * Author: Yang Pei
 * Problem: Three Sum
 * Source: https://oj.leetcode.com/problems/3sum/
 * 
 * Note:
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * Solution:
 * Sort the array, enumerate the first elements, then find the remain two elements from
 * both end. The important part is to avoid duplicates.
 * 
 * Follow up:
 * Find the sum that equals to a target value.
 * Assume the value are all non negative, check if there exist three values sum to a given target.
 */
import java.util.*;
public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num.length < 3)
			return result;
		Arrays.sort(num);
		int n = num.length, pre = num[0];
		for(int i = 0; i < n - 2; i++) {
			if(i != 0 && num[i] == pre)
				continue;
			pre = num[i];
			int left = i+1, right = n-1;
			while(left < right) {
				int sum = num[i] + num[left] + num[right];
				if(sum == 0) {
					ArrayList<Integer> array = new ArrayList<Integer>();
					array.add(num[i]);
					array.add(num[left]);
					array.add(num[right]);
					result.add(array);
					left++;
					while(left < right && num[left] == num[left-1])
						left++;
				}
				else if(sum < 0) {
					left++;
					while(left < right && num[left] == num[left-1])
						left++;
				}
				else {
					right--;
					while(left < right && num[right] == num[right+1])
						right--;
				}
			}
		}
		return result;
	}
}
