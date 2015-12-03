package Math;

public class FractiontoRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        if(denominator == 0){
            if(numerator>0){
                String.valueOf(Integer.MIN_VALUE);
            } else {
                return String.valueOf(Integer.MAX_VALUE);
            }
        }
        StringBuffer br=new StringBuffer();
        if((numerator>0 && denominator<0) ||(numerator<0 && denominator>0)){
            br.append("-");
        }
        long a=Math.abs((long)numerator);
        long b=Math.abs((long)denominator);
        long result=(long)(a/b);
        long remainder=(long)(a%b);
        br.append(result+"");
        if(remainder == 0){
            return br.toString();
        }
        br.append(".");
        Map<Long,Integer> map=new HashMap<Long,Integer>();
        map.put(remainder,br.length());
        while(remainder != 0){
            remainder*=10;
            result=remainder/b;
            br.append(result);
            remainder=remainder%b;
            if(map.containsKey(remainder)){
                br.insert(map.get(remainder),"(");
                br.append(")");
                return br.toString();
            }else{
                map.put(remainder,br.length());
            }
        }
        return br.toString();
    }
}