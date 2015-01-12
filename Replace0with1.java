/*
 * Author: Yang Pei
 * Problem: Replace 0s to 1s to get longest continuous 1s in array
 * Source: http://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
 * 
 * Note:
 * Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s. 
 * Expected time complexity is O(n) and auxiliary space is O(1).
 * 
 * Solution:
 * Iterative method, record the position of previous zero and previous previous zero.
 * Or using sliding window technique.
 * 
 * Follow up:
 * What if we could replace k 0s at most? Use the sliding window method would still ok.
 * 
 */
public class Replace0with1 {
	public static void replace(int[] array) {
		int n = array.length;
		int pre_zero = -1, pre_pre_zero = -1, max = -1, index = -1;
		for(int i = 0; i < n; i++) {
			if(array[i] == 0) {
				if(max < (i - pre_pre_zero - 1)) {
					max = i - pre_pre_zero - 1;
					index = pre_zero;
				}
				pre_pre_zero = pre_zero;
				pre_zero = i;
			}
			else {
				if(max < (i - pre_pre_zero - 1)) {
					max = i - pre_pre_zero - 1;
					index = pre_zero;
				}
			}
		}
		System.out.println(index + " " + max);
	}
	
	public static void replace1(int[] array) {
		int n = array.length;
		int left = 0, right = 0, cnt = 1, max = -1, index = -1, pre_zero = -1;
		while(right < n) {
			if(array[right] == 0) {
				if(cnt == 0) {
					while(left < right && array[left] == 1)
						left++;
					left++;
				}
				else 
					cnt--;
				pre_zero = right;
			}
			if(max < right - left + 1) {
				index = pre_zero;
				max = right - left + 1;
			}
			right++;
		}
		System.out.println(index + " " + max);
	}
	
	public static void replace(int[] array, int k) {
		int n = array.length;
		int left = 0, right = 0, max = -1, cnt = k;
		while(right < n) {
			if(array[right] == 0) {
				if(cnt == 0) {
					while(left < right && array[left] == 1)
						left++;
					left++;
				}
				else
					cnt--;
			}
			if(max < right - left + 1)
				max = right - left + 1;
			right++;
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		int[] array1 = new int[] {0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1};
		replace(array1, 2);
	}
}
