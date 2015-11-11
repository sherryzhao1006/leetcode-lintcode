package binarysearch;

public class sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(9));
		//int[] arr=new int[]{1,2,3,4,999999999};
		//System.out.println(sumPairs(arr));
	}
	public static int mySqrt(int x) {
        int low = 0;
        int high = x;
        while(high-low > 0.0001) {
            int mid = low+(high-low)/2;
            int res = mid*mid;
            if(res == x)
                return mid;
            else if( res < x) {
                low = mid;
            } else if(res > x) {
                high = mid;
            }           
        }
        return low;    
    }
	public static int Sqrt(int x){
		long lo = 0;
        long hi = x;

        while (lo+1<hi) {     
            long mid = lo+(hi-lo)/2;
            System.out.println(mid);
            if(x == mid*mid){
            	return (int)mid;
            }
            else if (x < mid * mid) {
                hi = mid;      // not hi = mid
            } else {
                lo = mid; 
            }
            System.out.println(lo+" "+hi);
        }
        if(hi*hi==x){
        	return (int)hi;
        }
        else return (int) lo;
//		long lo = 0;
//        long hi = x; 
//        while(lo <= hi) {
//            long mid = lo+(hi-lo)/2;
//            if(mid*mid == x)
//                return (int) mid;
//            else if(mid*mid < x) {
//                lo = mid+1;
//            } else {
//                hi = mid-1;
//            }
//        }
//        return (int)hi;
	}

}
