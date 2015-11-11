package binarytree;
import binarytree.TreeNode;

import java.util.*;
public class getNodeNum {

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
        System.out.println(getNodenum1(root));
	}
	public static int getNodenum(TreeNode root){
		if(root == null){
			return 0;
		}
		int count=1;
		Deque<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode curr=queue.poll();
			if(curr.left!=null){
				queue.add(curr.left);
				count++;
			}
			if(curr.right !=null){
				queue.add(curr.right);
				count++;
			}
		}
		return count;
	}
	public static int getNodenum1(TreeNode root){
		if(root==null){
			return 0;
		}
		return getNodenum1(root.left)+getNodenum1(root.right)+1;
	}
}
