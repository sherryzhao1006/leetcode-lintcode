package dynamicprogramming;
import java.util.*;
/*
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares(13));
	}
    public static int numSquares(int n) {
    	if(n<=1){
    		return n;
    	}
    	int[] dp=new int[n+1];
    	Arrays.fill(dp,Integer.MAX_VALUE);
    	dp[0]=0;
    	for(int i=0;i<=n;++i){
    		for(int j=1;i+j*j<=n;++j){
    			dp[i+j*j]=Math.min(dp[i]+1,dp[i+j*j]);
    		}
    	}
    	return dp[n];
    }
}
