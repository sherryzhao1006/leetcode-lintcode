import java.util.*;
public class MinimumWindowSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		System.out.println(s.minWindow("a", "aa"));
	}

}
class Solution {
    public String minWindow(String s, String t) {
         if(s == null || s.length() == 0){
             return "";
         }   
         if(t == null || t.length() == 0){
             return "";
         }
         Map<Character,Integer> smap=new HashMap<Character,Integer>();
         Map<Character,Integer> tmap=new HashMap<Character,Integer>();
         for(int i=0;i<s.length();++i){
             if(smap.containsKey(s.charAt(i))){
                 smap.put(s.charAt(i),smap.get(s.charAt(i))+1);
             }else{
                 smap.put(s.charAt(i),1);
             }
         }
         for(int j=0;j<t.length();++j){
             if(tmap.containsKey(t.charAt(j))){
                 tmap.put(t.charAt(j),tmap.get(t.charAt(j)+1));
             }else{
                 tmap.put(t.charAt(j),1);
             }
         }
         if(!isValid(smap,tmap)){
             return "";
         }
         Map<Character,Integer> cmap=new HashMap<Character,Integer>();
         int min=s.length();
         int head=0;
         int minhead=0;
         for(int i=0;i<s.length();++i){
             char a=s.charAt(i);
             if(cmap.containsKey(a)){
                 cmap.put(a,cmap.get(a)+1);
             }else{
                 cmap.put(a,1);
             }
             while(isValid(cmap,tmap)){
                 if(min>(i-head+1)){
                     min=i-head+1;
                     minhead=head;
                 }
                 char remove = s.charAt(head++);
                if(cmap.get(remove) == 1) {
                    cmap.remove(remove);
                } else {
                    cmap.put(remove,cmap.get(remove)-1);
                }
             }
         }
         return s.substring(minhead,minhead+min);
    }
    public boolean isValid(Map<Character,Integer> s, Map<Character,Integer> t) {
        for(char curr : t.keySet()) {
            if(!s.containsKey(curr)) {
                return false;
            } else {
                if(t.get(curr) < s.get(curr))
                    return false;
            }
        }    
        return true;
    }
}