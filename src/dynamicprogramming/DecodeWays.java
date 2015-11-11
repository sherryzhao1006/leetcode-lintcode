package dynamicprogramming;
/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int numDecodings(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	int n=s.length();
    	int[] dp=new int[n+1];
    	dp[n]=1;
    	dp[n-1]=s.charAt(n-1)=='0'?0:1;
    	for(int i=n-2;i>=0;--i){
    		if(s.charAt(i)=='0'){
    			dp[i]=0;
    		}
    		else{
    			if(Integer.parseInt(s.substring(i, i+2))<=26){
    				dp[i]=dp[i+1]+dp[i+2];
    			}
    			else{
    				dp[i]=dp[i+1];
    			}
    		}
    	}
    	return dp[0];
    }

}
