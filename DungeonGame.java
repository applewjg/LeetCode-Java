/*
 * Author: Yang Pei
 * Problem: Dungeon Game
 * Source: https://oj.leetcode.com/problems/dungeon-game/
 * 
 * Note:
 * 
 * Soltuion:
 * Dp, dp[i][j] record the minimum health needed to go from (i, j) to reach the goal.
 * dp[i][j] = (dungeon[i][j] - Math.min(dp[i+1][j], dp[i][j+1]) >= 0) ? 1 : (dungeon[i][j] - Math.min(dp[i+1][j], dp[i][j+1]))
 */
public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		if(m == 0)
			return 0;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];
		for(int i = m-1; i >= 0; i--) {
			for(int j = n-1; j>= 0; j--) {
				int min;
				if(i == m-1 && j == n-1)
					min = 1;
				else if(i == m-1)
					min = dp[i][j+1];
				else if(j == n-1)
					min = dp[i+1][j];
				else 
					min = Math.min(dp[i][j+1], dp[i+1][j]);
				dp[i][j] = (dungeon[i][j] - min >= 0) ? 1 : (min - dungeon[i][j]);
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int[][] dungeon = new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
		System.out.println(calculateMinimumHP(dungeon));
	}
}
