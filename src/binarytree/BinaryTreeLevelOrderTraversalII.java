package binarytree;
import binarytree.TreeNode;

import java.util.*;
/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/
public class BinaryTreeLevelOrderTraversalII {

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
		System.out.println(levelOrderBottom(root));
	}
	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			List<Integer> sub=new ArrayList<Integer>();
			for(int i=0;i<size;++i){
				TreeNode node=queue.peek();
				if(node.left!=null){
					queue.add(node.left);
				}
				if(node.right!=null){
					queue.add(node.right);
				}
				sub.add(queue.poll().val);
			}
			result.add(0,sub);
		}
		return result;
	}

}
