/*
 * Author: Yang Pei
 * Problem: Search the missing element in Arithmetic Progression
 * Source: http://www.geeksforgeeks.org/find-missing-number-arithmetic-progression/
 * 
 * Note:
 * Given an arithmetic progression, find the missing elements in it. Assume that there
 * exist exact one missing element in it (the head and tail is not missing).
 * 
 * Solution:
 * Naive method is to sweep the entire array to find the missing element.
 * Binary search the array. Pay attention how to cut off the search space.
 * 
 * Follow up:
 * Given a array from 1 ... N and it is sorted, however, m number is missing.
 * Find all missing numbers.
 * Since the missing number could be appear in the two end of the array, we need
 * to check if the current array contains enough position or not, if not, we need
 * to add missing numbers from two ends.
 */
import java.util.*;
public class SearchinArithmeticProgression {
	public static int findMissing(int[] A) {
		int n = A.length;
		int diff = (A[n-1] - A[0]) / n;
		int l = 0, r = n-1;
		while(l < r) {
			if(r - l == 1)
				return A[r] - diff;
			int mid = l + (r - l) / 2;
			int temp = (mid - l) * diff + A[l];
			if(A[mid] == temp)
				l = mid;
			else
				r = mid;
		}
		return A[r] - diff;
	}
	
	public static void findMissing1(int[] A, int l, int r, int N, int m, List<Integer> result) {
		// check if there is missing element on both ends of the array
		int count = (A[r] - A[l]) - (r - l);
		if(m > count) {
			for(int i = 1; i < A[l]; i++)
				result.add(i);
			for(int i = A[r] + 1; i <= N; i++)
				result.add(i);
		}
		if(r - l == 1) {
			for(int i = 1; i <= m; i++)
				result.add(A[l] + i);
		}
		else {
			// half the array and try to find the missing elements recursively
			int mid = l + (r - l) / 2;
			int left = (A[mid] - A[l]) - (mid - l);
			int right = (A[r] - A[mid]) - (r - mid);
			if(left != 0)
				findMissing1(A, l, mid, N, left, result);
			if(right != 0)
				findMissing1(A, mid, r, N, right, result);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			List<Integer> result = new ArrayList<Integer>();
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[] A = new int[n-m];
			for(int i = 0; i < n-m; i++)
				A[i] = scan.nextInt();
			findMissing1(A, 0, n-m-1, n, m, result);
			System.out.println(result.toString());
		}
		scan.close();
	}
}
