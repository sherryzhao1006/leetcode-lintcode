package binarysearch;
/*A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ­ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -°.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.*/
public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,2,3,1};
		System.out.println(findPeakElement(nums));
	}
	public static int findPeakElement(int[] num) {
        if(num.length==0 ||num==null) return -1;
        int start=0,end=num.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(num[mid-1]>num[mid]) end=mid;
            else if(num[mid]<num[mid+1]) start=mid;
            else return mid;
        }
        if(num[start]>num[end]) return start;
        else return end;
    }

}
