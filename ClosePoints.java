/*
 * Author: Yang Pei
 * Problem: Find k cloest points
 * Source: http://www.careercup.com/question?id=5770054991872000
 * 
 * Note:
 * Given a list of points in 2-dimensional space and an integer k
 * Output the k input points that closest to (5, 5), using Euclidean distance.
 * 
 * Solution:
 * Use heap or quick selection. We assume the points with the same position are
 * different points.
 */
import java.util.*;
public class ClosePoints {
	private static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int distance(Point that) {
			return (that.x - this.x)*(that.x - this.x) + (that.y - this.y)*(that.y - this.y); 
		}
		
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	private static class Node {
		int ind, distance;
		public Node(int ind, int distance) {
			this.ind = ind;
			this.distance = distance;
		}
	}
	
	public static void kPoints(Point[] points, int k) {
		PriorityQueue<Node> pq = new PriorityQueue<Node> (k, new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				return node2.distance - node1.distance;
			}
		});
		Point target = new Point(5, 5);
		for(int i = 0; i < points.length; i++) {
			Node tmp = new Node(i, target.distance(points[i]));
			if(pq.size() < k) {
				pq.offer(tmp);
			}
			else {
				if(pq.peek().distance > tmp.distance) {
					pq.poll();
					pq.offer(tmp);
				}
			}
		}
		while(pq.size() > 0) {
			Node tmp = pq.poll();
			System.out.println(points[tmp.ind] + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Point[] points = new Point[6];
		points[0] = new Point(-2, -4);
		points[1] = new Point(0, 0);
		points[2] = new Point(10, 15);
		points[3] = new Point(5, 6);
		points[4] = new Point(7, 8);
		points[5] = new Point(-10, -30);
		kPoints(points, 2);
	}
}
