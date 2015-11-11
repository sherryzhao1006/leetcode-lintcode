package array;
import java.util.*;
public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> result=new ArrayList<Integer>();
	        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
	            return result;
	        }
	        int n=matrix.length;
	        int m=matrix[0].length;
	        int i=0;
	        while(i*2<n && i*2<m){
	            for(int j=i;j<m-i;++j){
	                result.add(matrix[i][j]);
	            }
	            for(int j=i+1;j<n-i;++j){
	                result.add(matrix[j][m-i-1]);
	            }
	            if(n - 2 * i == 1 || m - 2 * i == 1)  // if only one row /col remains
	                break;
	            for(int j=m-i-2;j>=i;--j){
	                result.add(matrix[n-i-1][j]);
	            }
	            for(int j=n-i-2;j>=i+1;--j){
	                result.add(matrix[j][i]);
	            }
	            i++;
	        }
	        return result;
	    }


}
