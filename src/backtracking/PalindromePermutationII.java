package backtracking;

import java.util.*;

public class PalindromePermutationII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<String> generatePalindromes(String s){
		List<String> result=new ArrayList<String>();
		char odd='#';
		boolean isOdd=false;
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();++i){
			char a=s.charAt(i);
			if(map.containsKey(a)){
				map.put(a, map.get(a)+1);
			}else map.put(a, 1);
		}
		for(char a:map.keySet()){
			if(map.get(a)%2 != 0){
				if(isOdd){
					return result;
				}
				isOdd=true;
				odd=a;
			}
		}
		StringBuffer br=new StringBuffer();
		if(odd != '#'){
			br.append(odd);
			map.put(odd, map.get(odd)-1);
		}
		helper(br,map,result,s.length());
		return result;
	}
	public void helper(StringBuffer br,Map<Character,Integer> map,List<String> result,int n){
		if(br.length() == n){
			result.add(br.toString());
			return;
		}
		for(char a:map.keySet()){
		    if(map.get(a)>0){
			br.insert(0, a);
			br.append(a);
			map.put(a, map.get(a)-2);
			helper(br,map,result,n);
			map.put(a,map.get(a)+2);
			br.deleteCharAt(0);
			br.deleteCharAt(br.length() -1);
		    }
		}
	}

}
