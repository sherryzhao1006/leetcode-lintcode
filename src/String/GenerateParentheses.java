package String;
import java.util.*;
/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));
	}
//	public static List<String> generateParenthesis(int n){
//		List<String> result=new ArrayList<String>();
//		if(n==0){
//			return result;
//		}
//		help(result,"",n,n);
//		return result;
//	}
//	public static void help(List<String> result,String s,int left,int right){
//		if(left==0 && right==0){
//			result.add(s);
//			return;
//		}
//		if(left>right || left<0 || right<0){
//			return;
//		}
//		help(result,s+"(",left-1,right);
//		help(result,s+")",left,right-1);
//	}
	public static List<String> generateParenthesis(int n) {
        if(n<=0){
            return null;
        }
        List<String> result=new ArrayList<String>();
        StringBuffer br=new StringBuffer();
        helper(result,br,n,n);
        return result;
    }
    public static void helper(List<String> result,StringBuffer br,int left,int right){
        if(left==0 && right ==0){
            result.add(br.toString());
            return;
        }
        if(left>right || left<0 || right<0){
            return;
        }
        if(left>0){
            helper(result,br.append("("),left-1,right);
            br.deleteCharAt(br.length()-1);
        }
        if(right>0){
            helper(result,br.append(")"),left,right-1);
            br.deleteCharAt(br.length()-1);
        }
    }
}
