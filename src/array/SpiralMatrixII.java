package array;

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        if(n == 0){
            return result;
        }
        int i=0;
        int num=1;
        while(i*2<n){
            for(int j=i;j<n-i;++j){
                result[i][j]=num++;
            }
            for(int j=i+1;j<n-i;++j){
                result[j][n-i-1]=num++;
            }
            for(int j=n-i-2;j>=i;--j){
                result[n-i-1][j]=num++;
            }
            for(int j=n-i-2;j>=i+1;--j){
                result[j][i]=num++;
            }
            i++;
        }
        return result;
	}
}
