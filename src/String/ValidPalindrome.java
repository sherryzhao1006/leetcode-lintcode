package String;

/**
 * Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to 
 * ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Tags: Two pointers, String
 */
class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome1(String s){
    	StringBuffer sb=new StringBuffer();
    	for(char c:s.toCharArray()){
    		c=Character.toLowerCase(c);
    		if(Character.isLetterOrDigit(c)){
    			sb.append(c);
    		}
    	}
    	String copy=sb.toString().toLowerCase();
    	int length=copy.length();
    	for(int i=0;i<length/2;++i){
    		if(copy.charAt(i)!=copy.charAt(length-i-1)){
    			return false;
    		}
    	}
    	return true;
    }
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
        	return true;
        }
        s=s.toLowerCase();
        int start=0,end=s.length()-1;
        while(start<end){
        	while(start<end && !isvalid(s,start) ){
        		start++;
        	}
        	while(start<end && !isvalid(s,end)){
        		end--;
        	}
        	if(s.charAt(start)!=s.charAt(end)){
        		return false;
        	}
        	start++;
        	end--;
        }
        return true;
    }
    public static boolean isvalid(String s,int index){
    	if((s.charAt(index)>='0' && s.charAt(index)<='9')||(s.charAt(index)>='a' && s.charAt(index)<='z')){
    		return true;
    	}
    	return false;
    }

}
