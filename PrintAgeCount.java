/*
 * Author: Yang Pei
 * Problem: Print Age Occurrences
 * Source: http://www.careercup.com/question?id=5129701993480192
 * 
 * Note:
 * Given an array of ages(integers) sorted lowest to highest, output the number of
 * occurrences of each age.
 * Example:
 * [8, 8, 8, 9, 9, 11, 15, 16, 16, 16]
 * 
 * 8: 3
 * 9: 2
 * 11: 1
 * 15: 1
 * 16: 3
 * 
 * This should be done in less than O(n)
 * Solution:
 * When the input size is small, we could just sweep the Array.
 * Here we assume that the input is very large, and we need to pay attention to the 
 * property of the data itself in this problem. The age is about in a range from 0 ~ 150,
 * so when there are large input, there would be much duplicates and we could use 
 * binary search to speed up.
 */
public class PrintAgeCount {
	public static void printAge(int[] A) {
		for(int i = 0; i <= 150; i++) {
			int ind1 = findLeft(A, i);
			if(ind1 == -1)
				continue;
			int ind2 = findRight(A, i);
			System.out.println(i + ": " + (ind2 - ind1 + 1));
		}
	}
	
	private static int findLeft(int[] A, int target) {
		int l = 0, r = A.length - 1, result = -1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(A[mid] == target) {
				result = mid;
				r = mid - 1;
			}
			else if(A[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return result;
	}
	
	private static int findRight(int[] A, int target) {
		int l = 0, r = A.length - 1, result = -1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(A[mid] == target) {
				result = mid;
				l = mid + 1;
			}
			else if(A[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {8, 8, 8, 9, 9, 11, 15, 16, 16, 16};
		printAge(A);
	}
}
