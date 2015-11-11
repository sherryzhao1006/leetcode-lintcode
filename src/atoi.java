

/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Keys: Whitespaces, Additional chars, Signs, Out of range
 * 
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * Tags: Math, String
 */
class atoi {
    
    public static void main(String[] args) {
        System.out.println("MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("MIN_VALUE: " + (Integer.MIN_VALUE-1));
        System.out.println("2147483648: " + Atoi("2147483648"));
        System.out.println("-2147483647: " + Atoi("-2147483647"));
        System.out.println("-2147483648: " + Atoi("-2147483648"));
        System.out.println("MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("2147483648: " + myAtoi1("2147483648"));
        System.out.println("-2147483647: " + myAtoi1("-2147483647"));
        System.out.println("-2147483648: " + myAtoi1("-2147483648"));
    }
    public static int Atoi(String str) {
    	str=str.trim();
        if(str == null || str.length() == 0){
            return 0;
        }
        int sign=1;
        int i=0;
        if(str.charAt(i) == '-'){
            sign=-1;
            i++;
        }else if(str.charAt(i)=='+'){
            i++;
        }
        long result=0;
        for(;i<str.length();++i){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                result=result*10+str.charAt(i)-'0';
            }else break;
            if(result>=Integer.MAX_VALUE) break;
        }
        result=result*sign;
        if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
    public static int myAtoi1(String str) {
        str = str.trim();
        if(str == null || str.length() == 0)
            return 0;
        boolean isNeg = false;
        int i=0;
        if(str.charAt(i) == '-') {
            isNeg = true;
            i++;
        } else if(str.charAt(i) == '+') {
            i++;
        }
        
        int sum = 0;
        while(i < str.length()) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if(sum > (Integer.MAX_VALUE/10)) {
                    return (isNeg == true ? Integer.MIN_VALUE : Integer.MAX_VALUE);
                }
                sum = sum * 10 + (int)(str.charAt(i) - '0');            
                i++;
            } else {
                
                return (isNeg == true ? -sum : sum);
            }
        }        
        return (isNeg == true ? -sum : sum);
    }

}
