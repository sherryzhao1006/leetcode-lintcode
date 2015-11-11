package String;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 *
 * For example,
 * Given s = "Hello World",
 * return 5.
 *
 * Tags: String
 */
class LengthOfLastWord {
    public static void main(String[] args) {
        String a = " ";
        String b = " Hello World";
        String c = "           ";
        String d = "a";
        System.out.println(lengthOfLastWord(a));
        System.out.println(lengthOfLastWord(b));
        System.out.println(lengthOfLastWord(c));
        System.out.println(lengthOfLastWord(d));
    }
    public static int lengthOfLastWord(String s){
    	String[] str=s.split(" ");
    	if(str.length==0 || str==null){
    		return 0;
    	}
    	return str[str.length-1].length();
    }

}
