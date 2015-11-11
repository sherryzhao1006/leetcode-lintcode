package dynamicprogramming;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int jump(int[] A) {
    	if(A == null || A.length == 0){
    		return 0;
    	}
    	int n=A.length;
    	int[] dp=new int[n];
    	dp[0]=0;
    	for(int i=1;i<A.length;++i){
    		dp[i]=Integer.MAX_VALUE;
    		for(int j=0;j<i;++j){
    			if(dp[j] != Integer.MAX_VALUE && j+A[j]>=i){
    				dp[i]=Math.min(dp[i],dp[j]+1);
    			}
    		}
    	}
    	return dp[n-1];
    }
}
