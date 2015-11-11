package array;
/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int removeElement(int[] A, int elem) {
    	int length=0;
    	for(int i=0;i<A.length;++i){
    		if(A[i] != elem){
    			A[length++]=A[i];
    		}
    	}
    	return length;
    }
}
