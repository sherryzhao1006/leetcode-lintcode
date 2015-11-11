package array;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//http://blog.csdn.net/yutianzuijin/article/details/11499917
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total=nums1.length+nums2.length;
        if(total % 2 == 0){
        	return (findMid(nums1,0,nums2,0,total/2)+findMid(nums1,0,nums2,0,total/2 +1))/2.0;
        }else{
        	return findMid(nums1,0,nums2,0,total/2+1);
        }
    }
    public int findMid(int[] nums1,int start1,int[] nums2,int start2,int k){
    	if(start1>=nums1.length){
    		return nums2[start2+k-1];
    	}
    	if(start2>=nums2.length){
    		return nums1[start1+k-1];
    	}
    	if(k == 1){
    		return Math.min(nums1[start1],nums2[start2]);
    	}
    	int val1=start1+k/2-1<nums1.length?nums1[start1+k/2-1]:Integer.MAX_VALUE;
    	int val2=start2+k/2-1<nums2.length?nums1[start2+k/2-1]:Integer.MAX_VALUE;
    	if(val1<val2){
    		return findMid(nums1,start1+k/2,nums2,start2,k-k/2);
    	}else{
    		return findMid(nums1,start1,nums2,start2+k/2,k-k/2);
    	}
    }
}
