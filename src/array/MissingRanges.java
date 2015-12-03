package array;
import java.util.*;
//Missing Ranges
//Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
//For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result=new ArrayList<String>();
        if(nums == null || nums.length == 0){
            if(upper==lower){
                result.add(upper+"");
            }else{
                result.add(lower+"->"+upper);
            }
            return result;
        }
        if(nums[0] != lower){
            if(nums[0]-1 == lower){
                result.add(lower+"");
            }else{
                result.add(lower+"->"+(nums[0]-1));
            }
        }
        int prev=nums[0];
        for(int i=1;i<nums.length;++i){
            while(i<nums.length && nums[i]==nums[i-1]+1){
                i++;
            }
            if(i == nums.length) break;
            int start=nums[i-1]+1;
            if(nums[i]-start == 1){
                result.add(start+"");
            }else{
                result.add(start+"->"+(nums[i]-1));
            }
        }
        if(nums[nums.length-1] != upper){
            if(nums[nums.length-1]+1 == upper){
                result.add(upper+"");
            }else{
                result.add((nums[nums.length-1]+1)+"->"+upper);
            }
        }
        return result;
    }
}
