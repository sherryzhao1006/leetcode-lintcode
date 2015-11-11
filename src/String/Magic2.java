package String;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Magic2 {

	public static String encode(String source) {
        StringBuffer dest = new StringBuffer();
        char prev = source.charAt(0);
        int cnt = 1;
        for (int i = 1; i < source.length(); i++) {
            if(prev == source.charAt(i)) {
                cnt++;
            } else {
                dest.append(prev+""+cnt);
                cnt=1;
                prev = source.charAt(i);
            }
        }
        dest.append(prev+""+cnt);
        return dest.toString();
    }
	static Boolean printZeroSumSubarray(int arr[])
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
         
        // Initialize sum of elements
        int sum = 0;        
         
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {   
            // Add current element to sum
            sum += arr[i];
             
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (arr[i] == 0 || sum == 0 || hM.get(sum) != null)                            
               return true;
             
            // Add sum to hash map
            hM.put(sum, i);
            System.out.println(hM);
        }    
         
        // We reach here only when there is no subarray with 0 sum
        return false;
    }        
    
 
    public static void main(String[] args) {
        System.out.println(encode("AAABBCCCCCDDDDDDDDD"));
        System.out.println(encode("AAB"));
        int arr[] = {4, 2, -3, 1, 6};
        if (printZeroSumSubarray(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Subarray with 0 sum");      
    }
}

