package String;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public class Solution {
	/*dp
	*/
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n=s.length();
        int[] dp=new int[n];
        dp[0]=0;
        int max=0;
        for(int i=1;i<s.length();++i){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    if(i-2>=0){
                        dp[i]=dp[i-2]+2;
                    }else dp[i]=2;
                }else{
                    if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
                        if(i-dp[i-1]-2>=0){
                            dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2;
                        }else{
                            dp[i]=dp[i-1]+2;
                        }
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    /*stack: store the index of '('
    */
        public int longestValidParentheses(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            Stack<Integer> stack=new Stack<Integer>();
            int max=0;
            int start=-1;
            for(int i=0;i<s.length();++i){
                if(s.charAt(i)=='('){
                    stack.push(i);
                }else{
                    if(stack.isEmpty()){
                        start=i;
                        continue;
                    }
                    stack.pop();
                    if(stack.isEmpty()){
                        max=Math.max(max,i-start);
                    }else{
                        max=Math.max(max,i-stack.peek());
                    }
                }
            }
            return max;
        }
}
}
