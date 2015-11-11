package backtracking;
import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * Tags: Backtracking. String
 */
public class GenerateParen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));
	}
    public static List<String> generateParenthesis(int n) {
    	List<String> result=new ArrayList<String>();
    	if(n == 0){
    		return result;
    	}
    	help(result,"",n,0);
    	return result;
    }
    public static void help(List<String> result,String str,int left,int right){
    	if(left == 0 && right == 0){
    		result.add(str);
    		return;
    	}
    	//left first, then right
    	if(left>0){
    		help(result,str+"(",left-1,right+1);
    	}
    	if(right>0){
    		help(result,str+")",left,right-1);
    	}
    }

}
