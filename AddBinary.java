public class AddBinary {
	public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        if(m == 0) return b;
        else if(n == 0) return a; // corner case
        
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        int p1 = ch1.length - 1, p2 = ch2.length - 1;
        int carry = 0, num = 0;
        StringBuffer sb = new StringBuffer();
        
        while(p1 >= 0 && p2 >= 0) {
            num = ch1[p1] - '0' + ch2[p2] - '0' + carry;
            carry = num / 2;
            num = num % 2;
            sb.append(String.valueOf(num));
            p1--; p2--;
        }
        
        if(p1 < 0) {
            while(p2 >= 0) {
                num = ch2[p2] - '0' + carry;
                carry = num / 2;
                num = num % 2;
                sb.append(String.valueOf(num));
                p2--;
            }
        }
        else {
            while(p1 >= 0) {
                num = ch1[p1] - '0' + carry;
                carry = num / 2;
                num = num % 2;
                sb.append(String.valueOf(num));
                p1--;
            }
        }
        
        if(carry == 1)
            sb.append("1");
        sb = sb.reverse();
        return sb.toString();
    }
}