import java.util.*;
public class wordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s==null || s.length()==0) return null;
        List<String> result=new ArrayList<String>();
        List<String> sub=new ArrayList<String>();
        boolean[] canbreak=new boolean[s.length()+1];
        Arrays.fill(canbreak,true);
        help(result,sub,s,wordDict,canbreak,0);
        return result;
    }
    void help(List<String> result,List<String> sub,String s,Set<String>wordDict,boolean[] canbreak,int pos){
        if(pos==s.length()){
            StringBuffer br=new StringBuffer();
            for(String str:sub){
                br.append(str).append(" ");
            }
            br.deleteCharAt(br.length()-1);
            result.add(br.toString());
            return;
        }
        if(!canbreak[pos]) return;
        for(int i=pos;i<s.length();++i){
            String left=s.substring(pos,i+1);
            if(!wordDict.contains(left) ||!canbreak[i+1]){
                continue;
            }
            sub.add(left);
            int leftside=result.size();
            help(result,sub,s,wordDict,canbreak,i+1);
            if(leftside==result.size()){
                canbreak[i+1]=false;
            }
            sub.remove(sub.size()-1);
        }
    }
}
