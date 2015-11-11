package Math;
/*
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPowerOfTwo(int n) {
    	if(n<=0){
    		return false;
    	}
    	return (n & (n-1)) == 0;
    }
}
