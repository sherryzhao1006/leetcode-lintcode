package backtracking;
import java.util.*;
public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result=removeInvalidParentheses("()())()");
		for(String i:result){
			System.out.println(i);
		}
	}
	public static List<String> removeInvalidParentheses1(String s) {
		List<String> result=new ArrayList<String>();
		if(s == null || s.length() == 0){
			result.add("");
			return result;
		}
		Map<Integer,Set<String>> map=new HashMap<Integer,Set<String>>();
		int[] max={Integer.MIN_VALUE};
		helper(s,map,max,0,0,0,"");
		return new ArrayList<String>(map.get(max[0]));
	}
	public static void helper(String s,Map<Integer,Set<String>>map,int[] max, int pos,int left,int right,String str){
		if(left<right) return;
		if(pos == s.length()){
			if(left != right) return;
			if(!map.containsKey(str.length())){
				map.put(str.length(), new HashSet<String>());
			}
			map.get(str.length()).add(str);
			max[0]=Math.max(max[0], str.length());
			return;
		}
		if(s.charAt(pos) == '('){
			helper(s,map,max,pos+1,left+1,right,str+"(");
			helper(s,map,max,pos+1,left,right,str);
		}else if(s.charAt(pos)==')'){
			helper(s,map,max,pos+1,left,right+1,str+")");
			helper(s,map,max,pos+1,left,right,str);
		}else{
			helper(s,map,max,pos+1,left,right,str+s.charAt(pos));
		}
	}
	
	public static List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<String>();
        if(s == null || s.length() == 0){
            return result;
        }
        Queue<String> q=new LinkedList<String>();
        Set<String> set=new HashSet<String>();
        q.add(s);
        set.add(s);
        boolean found=false;
        while(!q.isEmpty()){
            s=q.poll();
            if(isValid(s)){
                result.add(s);
                System.out.println("1: "+s);
                found=true;
                continue;
            }
            if(found) continue;
            for(int i=0;i<s.length();++i){
                if(s.charAt(i)!='(' && s.charAt(i)!=')') continue;
                 String sub=s.substring(0,i)+s.substring(i+1,s.length());
                 System.out.println("sub: "+i+" "+sub);
                    if(!set.contains(sub)){
                        set.add(sub);
                        q.add(sub);
                    }
                }
        }
        return result;
    }
	//(ab)(de)
    public static boolean isValid(String str){
        int count=0;
        for(int i=0;i<str.length();++i){
            if(str.charAt(i)=='('){
                count++;
            }
            if(str.charAt(i)==')' && count-- ==0){
                return false;
            }
        }
        return count==0;
    }

}
