/*
 * Author: Yang Pei
 * Problem: Nuts and Bolts Problem
 * Source: http://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem/
 * 
 * Note:
 * Given a set of n nuts of different sizes and n bolts of different sizes. 
 * There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.
 * Constraint: Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
 * It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.
 * 
 * Solution:
 * Use the partition idea in quick sort to recursively process on both array. First use bolts
 * first element to partition nuts then use nuts' pivot to partition bolts.
 * 
 * Assumption:
 * In this case, we only use characters to map, however, there could be some function
 * provided to check if a "nut" matches a "bolt" or not.
 */
public class NutsBoltsProblem {
	private static int partition(char[] num, int left, int right, char pivot) {
		// System.out.println(num[left] + " " + num[right] + " " + pivot);
		int i = left;
		char temp1, temp2;
		for(int j = left; j < right; j++) {
			if(num[j] < pivot) {
				temp1 = num[i];
				num[i] = num[j];
				num[j] = temp1;
				i++;
			}
			else if(num[j] == pivot) {
				temp1 = num[j];
				num[j] = num[right];
				num[right] = temp1;
				j--;
			}
		}
		temp2 = num[i];
		num[i] = num[right];
		num[right] = temp2;
		return i;
	}
	
	public static void nutsBolts(char[] nuts, char[] blots, int left, int right) {
		if(left < right) {
			char ch = blots[right];
			int pivot = partition(nuts, left, right, ch);
			ch = nuts[pivot];
			partition(blots, left, right, ch);
			nutsBolts(nuts, blots, left, pivot-1);
			nutsBolts(nuts, blots, pivot+1, right);
		}
	}
	
	public static void main(String[] args) {
		char[] ch1 = new char[] {'@', '#', '$', '%', '^', '&'};
		char[] ch2 = new char[] {'$', '%', '&', '^', '@', '#'};
		nutsBolts(ch1, ch2, 0, 5);
		for(int i = 0; i < 6; i++) {
			System.out.print(ch1[i] + " ");
		}
		System.out.println("");
		for(int i = 0; i < 6; i++) {
			System.out.print(ch1[i] + " ");
		}
	}
}
