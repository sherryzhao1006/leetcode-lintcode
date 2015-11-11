package String;
import java.util.*;
public class EncodeandDecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Codec{
	public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();
        for(String str : strs){
            // 对于每个子串，先把其长度放在前面，用#隔开
            output.append(String.valueOf(str.length())+"#");
            // 再把子串本身放在后面
            output.append(str);
        }
        return output.toString();
    }
    public List<String> decode(String s) {
        List<String> res = new LinkedList<String>();
        int start = 0;
        while(start < s.length()) {
            int idx = s.indexOf("#",start);
            int size = Integer.parseInt(s.substring(start,idx));
            res.add(s.substring(idx+1,idx+size+1));
            start = idx+size+1;    
        } 
        return res;
    }
}
