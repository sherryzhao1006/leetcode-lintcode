package binarytree;
import binarytree.TreeNode;
/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean isValidBST(TreeNode root){
		return isValid(root,Long.MAX_VALUE,Long.MIN_VALUE);
	}
	public static boolean isValid(TreeNode root,long max,long min){
		if(root == null){
			return true;
		}
		if(root.val<=min || root.val>=max){
			return false;
		}
		return isValid(root.left,root.val,min) && isValid(root.right,max,root.val);
	}

}
