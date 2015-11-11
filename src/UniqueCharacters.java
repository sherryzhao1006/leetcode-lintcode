import java.util.*;
public class UniqueCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUnique("aaaabb"));
		System.out.println(isUnique("abcder"));
	}
	public static boolean isUnique(String str){
		Set<Character> set=new HashSet<Character>();
		for(int i=0;i<str.length();++i){
			if(set.contains(str.charAt(i))){
				return false;
			}
			set.add(str.charAt(i));
		}
		return true;
	}
}
