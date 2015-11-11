package String;

import java.util.*;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all
 * valid but "(]" and "([)]" are not.
 * 
 * Tags: Stack, String
 */
class ValidParenthese {
    
    public static void main(String[] args) {
        ValidParenthese v = new ValidParenthese();
        System.out.println(v.isValid("()"));
        System.out.println(v.isValid("()[]{}"));
        System.out.println(v.isValid("([)]"));
        System.out.println(v.isValid("[({(())}[()])]"));
        System.out.println(v.isValid("a[a(a{a(a(.)a)a}x[a(a)v]w)q]z"));
    }
    public boolean isValid(String s){
    	if(s.length()%2 != 0 || s==null){
    		return false;
    	}
    	Stack<Character> stack=new Stack<Character>();
    	Map<Character,Character> map=new HashMap<Character,Character>();
    	map.put('(',')');
    	map.put('[',']');
    	map.put('{','}');
    	int i;
    	for(i=0;i<s.length();++i){
    		char c=s.charAt(i);
    		if(c=='(' || c == '[' || c == '{'){
    			stack.push(c);
    			continue;
    		}
    		if(!stack.empty() && map.get(stack.peek())==c){
    			stack.pop();
    		}
    	}
    	return stack.empty();
    }
}
