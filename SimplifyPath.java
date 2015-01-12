/*
 * Author: Yang Pei
 * Problem: Simplify Path
 * Source: https://oj.leetcode.com/problems/simplify-path/
 * 
 * Note:
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Solution:
 * First split the path, then use a stack.
 * Use two pointers to split the words out and use a stack.
 */
import java.util.*;
public class SimplifyPath {
	public static String simplifyPath(String path) {
		if(path.length() == 0)
			return "/";
		String[] files = path.split("\\/+");
		List<String> stack = new ArrayList<String>();
		System.out.println(files.length);
		for(int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
			if(files[i].equals("..")) {
				if(stack.size() > 0)
					stack.remove(stack.size() - 1);
			}
			else if(files[i].equals("."))
				continue;
			else {
				if(files[i].length() != 0)
					stack.add(files[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		if(stack.size() == 0)
			return "/";
		else {
			for(int i = 0; i < stack.size(); i++) {
				sb.append("/");
				sb.append(stack.get(i));
			}
			return sb.toString();
		}
	}
	
	public String simplifyPath1(String path) {
        if(path.length() == 0)
            return "/";
        int n = path.length();
        int ind1 = 0, ind2 = n - 1;
        while(ind1 < n && path.charAt(ind1) == '/')
            ind1++;
        while(ind2 >= 0 && path.charAt(ind2) == '/')
            ind2--;
        if(ind1 > ind2)
            return "/";
        path = path.substring(ind1, ind2+1);
        StringBuilder sb = new StringBuilder();
        List<String> stack = new ArrayList<String>();
        ind1 = 0; ind2 = 0;
        while(ind1 < path.length()) {
            while(ind2 < path.length() && path.charAt(ind2) == '/')
                ind2++;
            ind1 = ind2;
            while(ind2 < path.length() && path.charAt(ind2) != '/')
                ind2++;
            if(path.substring(ind1, ind2).equals("..")) {
                if(stack.size() > 0)
                    stack.remove(stack.size() - 1);
            }
            else if(path.substring(ind1, ind2).equals(".")) {
                ind1 = ind2;
                continue;
            }
            else {
                stack.add(path.substring(ind1, ind2));
            }
            ind1 = ind2;
        }
        if(stack.size() == 0)
            return "/";
        else {
            for(int i = 0; i < stack.size(); i++) {
                sb.append("/");
                sb.append(stack.get(i));
            }
            return sb.toString();
        }
    }
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("a/b///c"));
	}
}
