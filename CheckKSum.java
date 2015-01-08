/*
 * Author: Yang Pei
 * Problem: Check K Sum
 * 
 * Note:
 * Given an array of non-negative numbers, check if we could use exactly K elements
 * in the array (each element could only be used once) to get a target sum, we assume
 * that the given target and k is valide. 
 * 
 * Solution:
 * Using dp to solve the problem, dp[i][j] means if we could obtain sum i using j 
 * elements, then dp[i][j] |= dp[i-A[k]][j-1].
 */
import java.util.*;

public class CheckKSum {
	public static boolean kSum(int[] num, int target, int k) {
		int n = num.length;
		boolean[][] dp = new boolean[target+1][k+1];
		dp[0][0] = true;
		for(int i = 0; i < n; i++) {
			for(int j = target; j >= num[i]; j--) {
				for(int p = 1; p <= k; p++) {
					dp[j][p] |= dp[j-num[i]][p-1];
				}
			}
		}
		return dp[target][k];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int n = scan.nextInt();
			int[] num = new int[n];
			for(int i = 0; i < n; i++) {
				num[i] = scan.nextInt();
			}
			int target = scan.nextInt();
			int k = scan.nextInt();
			System.out.println(kSum(num, target, k));
		}
		scan.close();
	}
}
