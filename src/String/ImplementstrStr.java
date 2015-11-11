package String;
/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, 
 * or null if needle is not part of haystack.
 * 
 * Tags: Two Pointers, String
 */
public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "14531234";
        String str2 = "123";
        String str3 = "1123";
        String str4 = "1245";
        String str5 = "12121212123";
        System.out.println(strStr(str1, str2));
        System.out.println(strStr(str3, str2));
        System.out.println(strStr(str4, str2));
        System.out.println(strStr(str5, str2));
	}
	public static int strStr(String haystack,String needle){
    	if(haystack == null && needle == null){
    		return 0;
    	}
    	int j=0,i=0;
    	for(;i<haystack.length()-needle.length()+1;++i){
    		for(j=0;j<needle.length();++j){
    			if(haystack.charAt(i+j) != needle.charAt(j)){
    				break;
    			}
    		}
    	if(j == needle.length()){
    		return i;
    	}
    	}
    	return -1;
    }
}


