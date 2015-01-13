/*
 * Author: Yang Pei
 * Problem: Anagrams
 * Source: https://oj.leetcode.com/problems/anagrams/
 * 
 * Note:
 * Given an array of strings, return all groups of strings that are anagrams.
 * All inputs will be in lower-case.
 * 
 * Solution:
 * Sort each string and use hashmap to record the string with the same anagrams.
 * Sort each string and then sort the entire array.
 */
import java.util.*;
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String str = new String(chs);
            if(map.containsKey(str) == false) {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str, list);
            }
            else {
                map.get(str).add(strs[i]);
            }
        }
        for(String key : map.keySet()) {
            if(map.get(key).size() > 1) {
                for(int i = 0; i < map.get(key).size(); i++) {
                    result.add(map.get(key).get(i));
                }
            }
        }
        return result;
    }
}
