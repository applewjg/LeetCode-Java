/*
 * Author: Yang Pei
 * Problem: Restore IP Address
 * Source: https://oj.leetcode.com/problems/restore-ip-addresses/
 * 
 * Note:
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * Solution:
 * Depth Limited DFS, we use a helper function to determine if the current 
 * substring is a valid field or not. A valid field should within 0 ~ 255 
 * and should not have leading zeros.
 * 
 * We could add some basic condition for purning.
 */
import java.util.*;
public class RestoreIPAddress {
	public List<String> resotreIPAddresses(String s) {
		List<String> result = new ArrayList<String>();
		dfs(s, 3, "", result);
		return result;
	}
	
	private void dfs(String s, int dep, String current, List<String> result) {
		if(s.length() <= dep || s.length() > (dep+1)*3)
			return;
		if(dep == 0) {
			if(valid(s)) {
				result.add(current + s);
			}
		}
		else {
			for(int i = 0; i < Math.min(3, s.length()); i++) {
				if(valid(s.substring(0, i+1))) {
					String temp = current + s.substring(0, i+1) + ".";
					dfs(s.substring(i+1), dep-1, temp, result);
				}
			}
		}
	}
	
	private boolean valid(String str) {
		if(str.length() < 1 || str.length() > 3)
			return false;
		if(str.length() == 1)
			return true;
		if(str.charAt(0) == '0')
			return false;
		if(Integer.parseInt(str) > 255)
			return false;
		return true;
	}
}
