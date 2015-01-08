/*
 * Author: Yang Pei
 * Problem: Word Search
 * Source: https://oj.leetcode.com/problems/word-search/
 * 
 * Note:
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * Solution:
 * DFS and pruning. Use a hashset to record the prefix of the target words and if 
 * the current composed word does not exist in the hashset, we do not need to further
 * search from this point.
 */
import java.util.*;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if(word.length() == 0)
			return false;
		HashSet<String> set = new HashSet<String>();
		for(int i = 1; i <= word.length(); i++)
			set.add(word.substring(0, i));
		int m = board.length;
		if(m == 0)
			return false;
		int n = board[0].length;
		boolean[][] mark = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(dfs(board, mark, "", word, i, j, set) == true)
					return true;
			}
		}
		return false;
	}
	
	private int[] dx = new int[]{0, 0, 1, -1};
	private int[] dy = new int[]{1, -1, 0, 0};
	
	private boolean dfs(char[][] board, boolean[][] mark, String cur, String word, int i, int j, HashSet<String> set) {
		
		if(mark[i][j] == true)
			return false;
		cur = cur + board[i][j];
		mark[i][j] = true;
		if(set.contains(cur) == false) {
			mark[i][j] = false;
			return false;
		}
		if(cur.equals(word))
			return true;
		int m = board.length;
		int n = board[0].length;
		for(int k = 0; k < 4; k++) {
			int xx = i + dx[k];
			int yy = j + dy[k];
			if(xx >= 0 && xx < m && yy >= 0 && yy < n)
				if(dfs(board, mark, cur, word, xx, yy, set) == true)
					return true;
		}
		mark[i][j] = false;
		return false;
	}
}
