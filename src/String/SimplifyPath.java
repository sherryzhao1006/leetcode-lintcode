package String;
import java.util.*;
/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * Tags: Stack, String
 */
class SimplifyPath {
    public static void main(String[] args) {
         System.out.println(simplifyPath("/home/"));
         System.out.println(simplifyPath("/a/./b/../../c/"));
         System.out.println(simplifyPath("/../"));
         System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
    public static String simplifyPath(String path){
    	/**
         * Split words with /, use a stack to save directories
         * If ".", skip
         * If "..", check stack. If stack empty, skip; If not, pop
         * Else, push it to stack
         * Initialize result as "/" if stack is empty, otherwise as empty string
         * Go through stack and concatenate words
         * Return result
         */
    	if(path==null){
    		return "";
    	}
    	Stack<String> stack=new Stack<String>();
    	String[] words=path.split("/");
    	for(String str:words){
    		if(str.length()==0 || str.equals(".")){
    			continue;
    		}
    		if(str.equals("..")){
    			if(stack.isEmpty()){
    				continue;
    			}
    			else stack.pop();
    		}
    		else stack.push(str);
    	}
    	String res=stack.isEmpty()?"/":"";
    	for(String str:stack){
    		res+="/"+str;
    	}
    	return res;
    }

}
