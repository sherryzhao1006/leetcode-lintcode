package backtracking;
import java.util.*;
/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/
public class RestoreIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("25525511135"));
	}
	public static List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<String>();
        List<String> sub=new ArrayList<String>();
        if(s.length()<4 || s.length()>12){
            return result;
        }
        help(result,sub,s,0);
        return result;
    }
    public static void help(List<String> result,List<String> sub,String s,int pos){
        if(sub.size()==4){
            if(pos!=s.length()){
                return;
            }
            StringBuffer br=new StringBuffer();
            for(String tmp:sub){
                br.append(tmp).append(".");
            }
            br.deleteCharAt(br.length()-1);
            result.add(br.toString());
            return;
        }
        for(int i=pos;i<s.length() && i<pos+3;++i){
            String tmp=s.substring(pos,i+1);
            if(isValid(tmp)){
                sub.add(tmp);
                help(result,sub,s,i+1);
                sub.remove(sub.size()-1);
            }
        }
    }
    public static boolean isValid(String tmp){
        if(tmp.charAt(0)=='0'){
            return tmp.equals("0");
        }
        int num=Integer.parseInt(tmp);
        return num>=0 && num<=255;
    }

}
