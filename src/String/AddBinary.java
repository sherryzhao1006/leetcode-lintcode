package String;
/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String a = "11110011001011110111110001010000111110011110101100011111010010001000001101111001000111";
        //String b = "111001011011111010001001111001100000101010000101100010101100010010010011011000";
        String a = "1";
        String b = "11";
        System.out.println(addBinary(a, b));
	}
	public static String addBinary(String a,String b){
		if(a.length()==0 && b.length()==0){
			return a.length()==0?b:a;
		}
		int m=a.length()-1,n=b.length()-1;
		int abit,bbit,result,carry=0;
		StringBuffer br=new StringBuffer();
		while(m>=0 || n>=0 || carry==1){
			abit=(m>=0)? (a.charAt(m--)-'0'):0;
			bbit=(n>=0)? Character.getNumericValue(b.charAt(n--)):0;
			result=abit^bbit^carry;
			carry=(abit+bbit+carry)/2;
			br.append(result);
		}
		return br.reverse().toString();
	}
}
