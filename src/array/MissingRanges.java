package array;
import java.util.*;
public class MissingRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result=new ArrayList<String>();
        if(nums == null || nums.length == 0){
            return result;
        }
        int start=lower;
        for(int i=0;i<nums.length;++i){
        	if(nums[i])
        }
        int prev = 0;
        int curr = 1;
        while(curr < nums.length) {
            if(nums[curr] - nums[curr-1] != 1) {
                if(nums[prev]+2 == nums[curr]) {
                    result.add(nums[prev]+1 + "");
                } else {
                    result.add(nums[prev]+1 + "->" + nums[curr]-1);
                }
            }
            prev = curr;
        }
        return result;
    }
}
