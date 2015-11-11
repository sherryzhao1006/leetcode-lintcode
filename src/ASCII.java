/*
 * String ="AB"
65*100+66= 6566
int result=6566-->"AB"
 */
public class ASCII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(asciiToInt("50"));
		System.out.println(intToAscii(5348));
	}
	public static int asciiToInt(String str){
		int result=0;
		for(int i=0;i<str.length();++i){
			result=result*100;
			result=result+(int)(str.charAt(i));
		}
		return result;
	}
	public static String intToAscii(int i){
		StringBuffer br=new StringBuffer();
		while(i != 0){
			char a=(char)(i%100);
			br.insert(0,a);
			i=i/100;
		}
		return br.toString();
	}

}
