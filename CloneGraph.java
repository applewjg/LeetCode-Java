/*
 * Author: Yang Pei
 * Problem: Clone Graph
 * Source: https://oj.leetcode.com/problems/clone-graph/
 * 
 * Note:
 * Clone an undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors.
 * 
 * Solution:
 * DFS. Use a HashMap to record the mapping information between the original
 * node and the cloned node.
 * 
 * Corner case: Pay attention that the input might be null.
 */
import java.util.*;

public class CloneGraph {
	public static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		public UndirectedGraphNode(int x) {
			this.label = x;
			neighbors = new ArrayList<CloneGraph.UndirectedGraphNode>();
		}
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new 
				HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		if(node == null)
			return null;
		dfs(node, map);
		return map.get(node);
	}
	
	private void dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		UndirectedGraphNode nn = new UndirectedGraphNode(node.label);
		map.put(node, nn);
		for(UndirectedGraphNode n : node.neighbors) {
			if(map.containsKey(n) == false)
				dfs(n, map);
			nn.neighbors.add(map.get(n));
		}
	}
}
