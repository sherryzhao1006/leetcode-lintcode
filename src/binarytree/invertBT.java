package binarytree;
import binarytree.TreeNode;
public class invertBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		TreeNode left=new TreeNode(2);
		TreeNode right=new TreeNode(2);
		TreeNode leftleft=new TreeNode(3);
		TreeNode leftright=new TreeNode(4);
		TreeNode rightleft=new TreeNode(4);
		TreeNode rightright=new TreeNode(3);
		root.left=left;
		root.right=right;
		left.left=leftleft;
		left.right=leftright;
		right.left=rightleft;
		right.right=rightright;
		invertTree(root);
	}

	public static TreeNode invertTree(TreeNode root){
		if(root == null){
			return root;
		}
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
