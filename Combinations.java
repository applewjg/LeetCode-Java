/*
 * Author: Yang Pei
 * Problem: Combinations
 * Source: https://oj.leetcode.com/problems/combinations/
 * 
 * Note:
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

   Soluction:
   Limited depth DFS.
   
   Follow up:
   Given a list, may contain duplicates, return all unique k combinations. The key point 
   is how to avoid duplicates.
 */
import java.util.*;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		dfs(1, n, k, current, result);
		return result;
	}
	
	private void dfs(int beg, int n, int k, List<Integer> current, List<List<Integer>> result) {
		if(k == 0) {
			result.add(new ArrayList<Integer>(current));
		}
		else {
			for(int i = beg; i <= n; i++) {
				current.add(i);
				dfs(i+1, n, k-1, current, result);
				current.remove(current.size() - 1);
			}
		}
	}
	
	public static List<List<Integer>> combine(int[] num, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		Arrays.sort(num);
		dfs(num, 0, k, current, result);
		return result;
	}
	
	public static void dfs(int[] num, int beg, int k, List<Integer> current, List<List<Integer>> result) {
		if(k == 0) {
			result.add(new ArrayList<Integer>(current));
		}
		else {
			for(int i = beg; i < num.length; i++) {
				if(i != beg && num[i] == num[i-1])
					continue;
				current.add(num[i]);
				dfs(num, i+1, k-1, current, result);
				current.remove(current.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] num = new int[n];
		for(int i = 0; i < n; i++)
			num[i] = scan.nextInt();
		int k = scan.nextInt();
		System.out.println(combine(num, k).toString());
		scan.close();
	}
}
