package binarytree;
import binarytree.TreeNode;
/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBTToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void flatten(TreeNode root){
		if(root == null){
			return;
		}
		while(root != null){
			if(root.left != null){
				TreeNode p=root.left;
				while(p.right != null){
					p=p.right;
				}
			p.right=root.right;
			root.right=root.left;
			root.left=null;
		}
		root=root.right;
	}
	}

}
