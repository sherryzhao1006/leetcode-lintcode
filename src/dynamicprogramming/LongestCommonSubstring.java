package dynamicprogramming;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int longestCommonSubstring(String A,String B){
		if(A == null ||B== null || A.length() == 0 || B.length() == 0){
			return 0;
		}
		int m=A.length();
		int n=B.length();
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<m;++i){
			dp[i][0]=0;
		}
		for(int j=0;j<n;++j){
			dp[0][j]=0;
		}
		int max=0;
		for(int i=0;i<=m;++i){
			for(int j=0;j<=n;++j){
				if(A.charAt(i)==B.charAt(j)){
					dp[i+1][j+1]=dp[i][j]+1;
				}
				else{
					dp[i+1][j+1]=0;
				}
				max=Math.max(max, dp[i+1][j+1]);
			}
		}
		return max;
	}

}
