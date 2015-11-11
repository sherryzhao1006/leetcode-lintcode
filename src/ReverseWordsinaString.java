
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
	//reverse words in a string II
	/*
	 * For example,
Given s = "the sky is blue",
return "blue is sky the".
	 */
	public static void reverseWords1(char[] s){
		if(s == null || s.length == 0){
			return;
		}
		reverse(s,0,s.length-1);
		for(char c:s){
			System.out.print(c+" ");
		}
		System.out.println();
		int start=0,end=0;
		while(end < s.length) {
            while(end < s.length && s[end] != ' ') {
                    end++;
            }
            reverse(s,start,end-1);
            end++;
            start = end;
        }
		for(char c:s){
			System.out.print(c+" ");
		}
	}
	public static void reverse(char[] s,int start,int end){
		while(start<=end){
			char tmp=s[start];
			s[start]=s[end];
			s[end]=tmp;
			start++;
			end--;
		}
	}

}
