package binarytree;
import binarytree.TreeNode;
/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode sortedArrayToBST(int[] num){
		TreeNode node=help(num,0,num.length-1);
		return node;
	}
	public TreeNode help(int [] num, int begin,int end){
		if(begin>end){
			return null;
		}
		TreeNode node=new TreeNode(num[(begin+end)/2]);
		node.left=help(num,begin,(begin+end)/2 -1);
		node.right=help(num,(begin+end)/2 +1,end);
		return node;
	}

}
