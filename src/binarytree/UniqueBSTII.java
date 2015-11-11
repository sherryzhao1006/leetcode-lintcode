package binarytree;
import binarytree.TreeNode;

import java.util.*;
/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBSTII {

	public static void main (String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateTree(3));
	}
	public static List<TreeNode> generateTree (int n){
		return generate(1,n);
	}
	public static List<TreeNode> generate(int begin,int end) {
		List<TreeNode> result=new ArrayList<TreeNode>();
		if(begin>end){
			result.add(null);
			return result;
		}
		for(int i=begin;i<=end;++i){
			List<TreeNode> left=generate(begin,i-1);
			List<TreeNode> right=generate(i+1,end);
			for(TreeNode l:left){
				for(TreeNode r:right){
					TreeNode root=new TreeNode(i);
					root.left= l;
					root.right= r;
					result.add(root);
				}
			}
		}
		return result;
	}

}
