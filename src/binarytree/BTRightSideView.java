package binarytree;
import binarytree.TreeNode;
import java.util.*;
/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class BTRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		TreeNode one =new TreeNode(2);
		TreeNode two=new TreeNode(3);
		root.left=one;
		root.right=two;
		TreeNode three=new TreeNode(5);
		TreeNode four=new TreeNode(4);
		one.right=three;
		two.right=four;
		System.out.println(rightSideView(root));
	}
	public static List<Integer> rightSideView(TreeNode root){
		List<Integer> result=new ArrayList<Integer>();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		if(root == null){
		    return result;
		}
		queue.add(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0;i<size;++i){
				TreeNode node=queue.poll();
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
				if(i==size-1){
					result.add(node.val);
				}
			}
		}
		return result;
	}

}
