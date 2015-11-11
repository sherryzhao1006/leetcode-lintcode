package String;
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * Tags: String
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="PAYPALISHIRING";
		System.out.println(convert1("ABCD",2));
	}
	public static String convert(String s,int nRows){
		if(s.length()==0 || s==null){
			return "";
		}
		if(nRows==1){
			return s;
		}
		StringBuffer br=new StringBuffer();
		int step=2*nRows-2;
		for(int i=0;i<nRows;++i){
			if(i==0 || i==nRows-1){
				for(int j=i;j<s.length();j=j+step){
					br.append(s.charAt(j));
				}
			}
			else{
				boolean flag=true;
				int largestep=2*(nRows-1-i);
				int smallstep=step-largestep;
				int j=i;
				while(j<s.length()){
					br.append(s.charAt(j));
					if(flag){
						j=j+largestep;
					}
					else j=j+smallstep;
					flag=!flag;
				}
			}
		}
		return br.toString();
	}
	public static String convert1(String s, int numRows) {
	    StringBuilder[] list = new StringBuilder[numRows];
	    for(int i=0; i < list.length; i++) {
	        list[i] = new StringBuilder();
	    }
	    boolean down = true;
	    int cnt = 0;
//	    for(int i=0; i < s.length(); i++) {
//	    	System.out.println(i+" "+cnt);
//	    	list[cnt].append(s.charAt(i));
//	    	if(down){
//	    		cnt++;
//	    	}else{
//	    		cnt--;
//	    	}
//	    	if(cnt == numRows){
//	    		cnt-=2;
//	    		down=!down;
//	    	}
//	    	else if(cnt == -1){
//	    		cnt+=2;
//	    		down=!down;
//	    	}
//	    }
	    for(int i=0; i < s.length(); i++) {
	    	System.out.println(i+" "+cnt+" "+down);
            if(cnt ==0) {
                down = true;
            } else if(cnt == numRows) {
                down = false;
                cnt = numRows-2;
            }
    
            list[cnt].append(s.charAt(i));
    
    
            if(down == true) {
                cnt++;
            } else {
                cnt--;
            }
        }  
	    StringBuffer br=new StringBuffer();
	    for(StringBuilder bd:list){
	    	br.append(bd.toString());
	    }
	    return br.toString();
	}
}
