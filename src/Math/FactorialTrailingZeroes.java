package Math;
/*
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int trailingZeroes(int n) {
    	if(n<=5){
    		return n/5;
    	}
    	return n/5+trailingZeroes(n/5);
    }
}
