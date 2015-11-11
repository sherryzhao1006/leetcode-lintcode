package Stack;
import java.util.*;
/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int evalRPN(String[] tokens) {
    	if(tokens == null || tokens.length==0){
    		return 0;
    	}
    	int left=0,right=0,result=0;
    	Stack<Integer> stack=new Stack<Integer>();
    	for(String str:tokens){
    		if(str.equals("+")){
    			right=stack.pop();
    			left=stack.pop();
    			result=left+right;
    			stack.push(result);
    		}
    		else if(str.equals("-")){
    			right=stack.pop();
    			left=stack.pop();
    			result=left-right;
    			stack.push(result);
    		}
    		else if(str.equals("*")){
    			right=stack.pop();
    			left=stack.pop();
    			result=left*right;
    			stack.push(result);
    		}
    		else if(str.equals("/")){
    			right=stack.pop();
    			left=stack.pop();
    			result=left/right;
    			stack.push(result);
    		}
    		else{
    			stack.push(Integer.parseInt(str));
    		}
    	}
    	return stack.pop();
    }
}
