package binarytree;
import binarytree.TreeNode;
/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
public class BalancedBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        System.out.println(isBalanced(root));
	}
	public static boolean isBalanced(TreeNode root){
		return checkheight(root)!=-1;
	}
	public static int checkheight(TreeNode node){
		if(node == null){
			return 0;
		}
		int left=checkheight(node.left);
		int right=checkheight(node.right);
		if(left == -1 || right == -1 || Math.abs(left-right)>1){
			return -1;
		}
		return Math.max(left, right)+1;
	}

}
