
/**
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 *
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing
 * spaces.
 *
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 *
 * Tags: String
 */
public class ReverseWordsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String given = "the sky is blue";
        String given2 = "    a    b";
        char[] a=given2.toCharArray();
        for(char b:a){
        	System.out.print(b);
        }
        System.out.println();
        reverseWords1(new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
        //System.out.println(reverseWords(given2));
	}
	public static String reverseWords(String s){
		if(s.length()==0 || s==null){
			return "";
		}
		String[] words=s.split(" ");
		StringBuffer br=new StringBuffer();
		for(int i=words.length-1;i>=0;--i){
			if(!words[i].equals("")){
				br.append(words[i]).append(" ");
			}
		}
		return br.toString().trim();
	}
}
