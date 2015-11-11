package dynamicprogramming;
/*
 * For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean canJump(int[] nums){
//		if(nums == null || nums.length == 0){
//			return true;
//		}
//		int n=nums.length;
//		boolean[] dp=new boolean[n];
//		dp[0]=true;
//		for(int i=1;i<n;++i){
//			for(int j=0;j<i;++j){
//				if(dp[j] && j+nums[j]>=i){
//					dp[i]=true;
//					break;
//				}
//			}
//		}
//		return dp[n-1];
		
		if(nums == null || nums.length ==0){
			return true;
		}
		int i=0;
		int reach=0;
		for(;i<nums.length && i<=reach;++i){
			reach=Math.max(reach, i+nums[i]);
		}
		return i==nums.length;
	}

}
