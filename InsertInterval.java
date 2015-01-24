/*
 * Author: Yang Pei
 * Problem: Insert Interval
 * Source: https://oj.leetcode.com/problems/insert-interval/
 * 
 * Note:
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Solution:
 * Sweep the entire array to find the position to insert the interval. When current
 * interval's end time small than inserted one, do nothing, if start time larger than
 * inserted end time, then insert the merged one, otherwise merge the intervals.
 * Use binary search to find the position to insert the interval. Find the left and 
 * right interval and then merge. Many corner case need to be handled carefully.
 */
import java.util.*;

public class InsertInterval {
	public static class Interval {
		int start;
		int end;
		public Interval() {
			start = 0;
			end = 0;
		}
		public Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int s = newInterval.start;
		int e = newInterval.end;
		boolean inserted = false;
		int beg = 0, count = 0;
		for(int i = 0; i < intervals.size(); i++) {
			if(inserted == false) {
				if(intervals.get(i).start > e) {
					Interval inter = new Interval(s, e);
					while(count > 0) {
						intervals.remove(beg);
						count--;
					}
					intervals.add(beg, inter);
					inserted = true;
				}
				else if(intervals.get(i).end < s)
					beg++;
				else {
					count++;
					s = Math.min(s, intervals.get(i).start);
					e = Math.max(e, intervals.get(i).end);
				}
			}
		}
		if(inserted == false) {
			Interval inter = new Interval(s, e);
			while(count > 0) {
				intervals.remove(beg);
				count--;
			}
			intervals.add(inter);
		}
		return intervals;
	}
	
	public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
		boolean inserted = false;
		for(int i = 0; i < intervals.size(); i++) {
			if(intervals.get(i).end < newInterval.start)
				continue;
			else if(intervals.get(i).start > newInterval.end) {
				intervals.add(i, newInterval);
				inserted = true;
				break;
			}
			else {
				newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i).end));
				intervals.remove(i);
				i--;
			}
		}
		if(inserted == false)
			intervals.add(newInterval);
		return intervals;
	}
	
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		for(int i = 0; i < intervals.size(); i++) {
			if(intervals.get(i).end < newInterval.start) {
				result.add(intervals.get(i));
			}
			else if(intervals.get(i).start > newInterval.end) {
				result.add(newInterval);
				newInterval = intervals.get(i);
			}
			else {
				newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i).end));
			}
		}
		result.add(newInterval);
		return result;
	}
	
	private int findLeft(List<Interval> intervals, int start) {
		int l = 0, r = intervals.size() - 1;
		while(l < r) {
			int mid = l + (r - l) / 2;
			if(intervals.get(mid).end >= start) 
				r = mid;
			else
				l = mid + 1;
		}
		return r;
	}
	
	private int findRight(List<Interval> intervals, int end) {
		int l = 0, r = intervals.size() - 1;
		while(l < r) {
			int mid = l + (r - l + 1) / 2;
			if(intervals.get(mid).start <= end)
				l = mid;
			else
				r = mid - 1;
		}
		return l;
	}
	
	public List<Interval> insert4(List<Interval> intervals, Interval newInterval) {
		if(intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		int left = findLeft(intervals, newInterval.start);
		int right = findRight(intervals, newInterval.end);
		if(intervals.get(left).end < newInterval.start)
			intervals.add(newInterval);
		else if(intervals.get(right).start > newInterval.end)
			intervals.add(0, newInterval);
		else {
			int s = Math.min(newInterval.start, intervals.get(left).start);
			int e = Math.max(newInterval.end, intervals.get(right).end);
			if(right < left)
				intervals.add(left, newInterval);
			else {
				int count = right - left + 1;
				while(count > 0) {
					intervals.remove(left);
					count--;
				}
				intervals.add(left, new Interval(s, e));
			}
		}
		return intervals;
	}
}
