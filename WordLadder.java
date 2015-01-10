/*
 * Author: Yang Pei
 * Problem: Word Ladder
 * Source: Yang Pei
 * 
 * Note:
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 * Solution:
 * Use BFS.
 */
import java.util.*;
public class WordLadder {
	public static int ladderLength(String start, String end, Set<String> dict) {
		int m = start.length();
        Queue<String> qu = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        qu.add(start);
        int step = 1;
        while(qu.size() > 0) {
            Queue<String> next = new LinkedList<String>();
            while(qu.size() > 0) {
                String word = qu.remove();
                char[] chs = word.toCharArray();
                for(int i = 0; i < m; i++) {
                	char ch = chs[i];
                    for(char j = 'a'; j <= 'z'; j++) {
                        chs[i] = j;
                        String str = new String(chs);
                        if(str.equals(end))
                            return step + 1;
                        if(dict.contains(str))
                            if(set.contains(str) == false) {
                                next.add(str);
                                set.add(str);
                            }
                    }
                    chs[i] = ch;
                }
            }
            step++;
            qu = next;
        }
        return 0;
	}
	
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot"); dict.add("dot"); dict.add("dot"); dict.add("lot"); dict.add("log");
		System.out.println(ladderLength("hit", "cog", dict));
	}
}
