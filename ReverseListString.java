/*
 * Author: Yang Pei
 * Problem: Reverse List String
 * 
 * Note:
 * Given a string represent by a list, each node in the list contains a character,
 * A word is separated by space. Reverse each word in the list.
 * For example
 * 'h'->'e'->'l'->'l'->'o'->' '->'w'->'o'->'r'->'l'->'d' would be changed to
 * 'o'->'l'->'l'->'e'->'h'->' '->'d'->'l'->'r'->'o'->'w'
 * 
 * Solution:
 * Two pointers. Be careful: there might be multiple spaces between two words. And there
 * might be leading and tailing spaces. And there might contains no space and there might 
 * be all space.
 * 
 * Define of the ListNodeC 
 * {
 *     char val;
 *     ListNodeC next;
 *     public ListNodeC(char ch) {
 *         this.val = ch;
 *         this.next = null;
 *     }
 * }
 */
public class ReverseListString {
	public static ListNodeC reverse(ListNodeC head) {
		if(head == null) 
			return head;
		ListNodeC dummy = new ListNodeC(' ');
		dummy.next = head;
		ListNodeC pointer1 = dummy, pointer2 = dummy;
		while(pointer1.next != null) {
			while(pointer2.next != null && pointer2.next.val == ' ')
				pointer2 = pointer2.next;
			if(pointer2.next == null)
				break;
			pointer1 = pointer2;
			// pay attention here, otherwise would have infinite loop
			pointer2 = pointer2.next;
			while(pointer2.next != null && pointer2.next.val != ' ') {
				ListNodeC temp = pointer2.next;
				pointer2.next = temp.next;
				temp.next = pointer1.next;
				pointer1.next = temp;
			}
			pointer1 = pointer2;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		String str = " a ba   c  ";
		ListNodeC dummy = new ListNodeC(' ');
		ListNodeC temp = dummy;
		for(int i = 0; i < str.length(); i++) {
			ListNodeC node = new ListNodeC(str.charAt(i));
			temp.next = node;
			temp = temp.next;
		}
		temp = dummy.next;
		while(temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
		temp = reverse(dummy.next);
		while(temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
	}
}
