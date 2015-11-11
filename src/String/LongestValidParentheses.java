package String;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int longestValidParentheses(String s) {
	       if(s.length()<=1){
	           return 0;
	       }
	       int max=0;
	       int n=s.length();
	       int[] dp=new int[n];
	       dp[0]=0;
	       for(int i=1;i<n;++i){
	           if(s.charAt(i)==')'){
	               if(s.charAt(i-1)=='('){
	                   if(i-2>=0){
	                       dp[i]=dp[i-2]+2;
	                   }
	                   else{
	                       dp[i]=2;
	                   }
	               }
	               else{
	                   if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
	                       if((i-dp[i-1]-2)>=0){
	                           dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2];
	                       }
	                       else{
	                           dp[i]=dp[i-1]+2;
	                       }
	                   }
	               }
	           }
	           max=Math.max(max,dp[i]);
	       }
	       return max;
	    }

}
