/*
 * Author: Yang Pei
 * Problem: Activity Schedule
 * Source: http://www.careercup.com/question?id=5666830939062272
 * 
 * Note:
 * Given several intervals, find the maximum number of intervals that do not conflict.
 * 
 * Solution:
 * Greedy method, sort the intervals according to the ending time and then sweep the 
 * array.
 */
import java.util.*;
public class ActivieySchedule {
	public static class Interval {
		int start, end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static int maxInterval(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval ival1, Interval ival2) {
				return ival1.end - ival2.end;
			}
		});
		int count = 0;
		int endTime = -1;
		for(int i = 0; i < intervals.length; i++) {
			if(endTime <= intervals[i].start) {
				count++;
				endTime = intervals[i].end;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Interval[] intervals = new Interval[n];
		for(int i = 0; i < n; i++) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			intervals[i] = new Interval(start, end);
		}
		System.out.println(maxInterval(intervals));
	}
}
