/*
 * Author: Yang Pei
 * Problem: Jump Game
 * Source: https://oj.leetcode.com/problems/jump-game/
 * 
 * Note:
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * Solution:
 * Use method similar to BFS.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        int n = A.length;
        if(n == 0)
            return false;
        int max = 0;
        for(int i = 0; i <= max; i++) {
            max = Math.max(i+A[i], max);
            if(max >= n-1)
                return true;
        }
        return false;
    }
}
