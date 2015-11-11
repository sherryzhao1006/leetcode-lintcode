package String;
/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * Tags: String
 */
public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
	}
	public static String countAndSay(int n){
		String pre="1";
		int i;
		for(i=1;i<n;++i){
			StringBuffer br=new StringBuffer();
			int count=0;
			for(int j=0;j<pre.length();++j){
				if(j==0||pre.charAt(j)==pre.charAt(j-1)){
					count++;
				}
				else{
					br.append(count+"");
					br.append(pre.charAt(j-1));
					count=1;
				}
			}
			br.append(count+"");
			br.append(pre.charAt(pre.length()-1));
			pre=br.toString();
		}
		return pre;
	}

}
