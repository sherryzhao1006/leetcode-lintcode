package String;

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shortestPalindrome("aacecaaa"));
		System.out.println(shortestPalindrome("acec"));
		System.out.println(shortestPalindrome("aaaaa"));

	}
/*
 * [思路]
从某个char开始向两边扩展(左右两边的字符相等), 如果能一直扩展到字符串的头部, 则将末尾余下的reverse,再加到原字符串的头部,即可. 
tips:  1. 中轴字符选从中间开始,这样找到的即为最短的. 2. 中轴字符可能为一个, 也可能为两个. 
 */
	public static String shortestPalindrome(String s) {
        if( s == null || s.length() == 0){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        int len=s.length();
        int mid=(len-1)/2;
        String result="";
        for(int i=mid;i>=0;--i){
            if(s.charAt(i) == s.charAt(i+1)){
                if((result=checkboth(s,i,i+1))!= null){
                    return result;
                }
            }
                if((result=checkboth(s,i,i))!= null){
                    return result;
                }
            
        }
        return result;
    }
    public static String check(String s,int left,int right){
        int i=1;
        for(;left-i>=0 && right+i<s.length();++i){
            if(s.charAt(left-i) != s.charAt(right+i)){
                break;
            }
        }
        if(left-i>=0) return null;
        StringBuffer br=new StringBuffer(s.substring(right+i)).reverse();
        return br.toString()+s;
    }
    public static String checkboth(String s,int left,int right){
        int i=1;
        for(;left-i>=0 && right+i<s.length();++i){
            if(s.charAt(left-i) != s.charAt(right+i)){
                break;
            }
        }
        if(left-i<0 && right+1>=s.length()) return s;
        if(left-i>=0 && right+1>=s.length()){
            StringBuffer br=new StringBuffer(s.substring(0,left-i+1)).reverse();
            return s+br.toString();
        }else if(left-i<0 && right+1<s.length()){
        	StringBuffer br=new StringBuffer(s.substring(right+i)).reverse();
            return br.toString()+s;
        }
        else return null;
        //StringBuffer br=new StringBuffer(s.substring(right+i)).reverse();
        //return br.toString()+s;
    }
}
