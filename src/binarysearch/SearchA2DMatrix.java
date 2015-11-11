package binarysearch;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * Tags: Array, Binary Search
 */
public class SearchA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 0));
        System.out.println(searchMatrix(matrix, 1));
        System.out.println(searchMatrix(matrix, 2));
        System.out.println(searchMatrix(matrix, 11));
        System.out.println(searchMatrix(matrix, 15));
        System.out.println(searchMatrix(matrix, 34));
        System.out.println(searchMatrix(matrix, 35));
        System.out.println(searchMatrix(matrix, 50));
        System.out.println(searchMatrix(matrix, 51));
        System.out.println(searchMatrix(matrix, 100));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int start=0,end=row*col-1;
        int mid;
        while(start+1<end){
            mid=start+(end-start)/2;
            if(matrix[mid/col][mid%col]==target){
                return true;
            }
            else if(matrix[mid/col][mid%col]<target){
                start=mid;
            }
            else end=mid;
        }
        if (matrix[start / col][start % col] == target) {
            return true;
        } else if (matrix[end / col][end % col] == target) {
            return true;
        }
        
        return false;
    }

}
