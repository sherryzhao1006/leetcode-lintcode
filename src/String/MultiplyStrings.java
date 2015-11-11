package String;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() ==0){
            return num2;
        }
        if(num2 == null || num2.length() == 0){
            return num1;
        }
        int n=num1.length();
        int m=num2.length();
        int[] result=new int[n+m];
        num1=new StringBuffer(num1).reverse().toString();
        num2=new StringBuffer(num2).reverse().toString();
        for(int i=0;i<n;++i){
            int a=num1.charAt(i)-'0';
            for(int j=0;j<m;++j){
                int b=num2.charAt(j)-'0';
                result[i+j]+=a*b;
            }
        }
        StringBuffer br=new StringBuffer();
        int carry=0;
        for(int i=0;i<result.length;++i){
            result[i]=result[i]+carry;
            br.insert(0,result[i]%10);
            carry=result[i]/10;
        }
        while(carry != 0){
            br.insert(0,carry%10);
            carry=carry/10;
        }
        while(br.charAt(0)=='0' && br.length()>1){
            br.deleteCharAt(0);
        }
        return br.toString();
    }
}
