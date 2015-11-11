import java.util.*;
import binarytree.TreeNode;
public class KthSmallestElementinaBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//O(n)
	public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        int i=1;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(i == k){
                return root.val;
            }
            i++;
            root=root.right;
        }
        return 0;
    }
/*	进一步思考：
	如果BST节点TreeNode的属性可以扩展，则再添加一个属性leftCnt，记录左子树的节点个数

	记当前节点为node

	当node不为空时循环：

	若k == node.leftCnt + 1：则返回node

	否则，若k > node.leftCnt：则令k -= node.leftCnt + 1，令node = node.right

	否则，node = node.left
	上述算法时间复杂度为O(BST的高度)
	start:
if K = root.leftElement + 1
   root node is the K th node.
   goto stop
else if K > root.leftElements
   K = K - (root.leftElements + 1)
   root = root.right
   goto start
else
   root = root.left
   goto srart

stop:
	*/
}
