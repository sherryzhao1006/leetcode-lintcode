package binarysearch;
/*There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Show Tags
*/
public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A=new int[]{1,2,3};
		int[] B=new int[]{4,5};
		System.out.println(findMedianSortedArrays(A,B));
	}
	public static double findMedianSortedArrays(int A[], int B[]) {
	     int length=A.length+B.length;
	     if(length%2==0){
	         return (findkth(A,0,B,0,length/2) + findkth(A,0,B,0,length/2 +1))/2.0;
	     }
	     else{
	         return findkth(A,0,B,0,length/2+1);
	     }
	    }
	public static int findkth(int[] A, int A_start, int[] B, int B_start, int k){
	    if(A_start>=A.length){
	             return B[B_start+k-1];
	         }
	         if(B_start>=B.length){
	             return A[A_start+k-1];
	         }
	         if(k==1){
	             return Math.min(A[A_start],B[B_start]);
	         }
	         int A_key=A_start+k/2-1<A.length?A[A_start+k/2-1]:Integer.MAX_VALUE;
	         int B_key=B_start+k/2-1<B.length?B[B_start+k/2-1]:Integer.MAX_VALUE;
	         System.out.println(A_key+" "+B_key);
	         if(A_key<B_key){
	             return findkth(A,A_start+k/2,B,B_start,k-k/2);
	         }
	         else{
	             return findkth(A, A_start, B, B_start + k / 2, k - k / 2);
	         }
	     }

}
