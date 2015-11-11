package binarytree;

public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		Codec codec=new Codec();
		System.out.println(codec.serialize(root));
		root=codec.deserialize(codec.serialize(root));
		print(root);
	}
	public static void print(TreeNode root){
		if(root == null){
			System.out.print("null,");
			return;
		}
		System.out.print(root.val+",");
		print(root.left);
		print(root.right);
	}

}
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null,";
        }
        StringBuffer br=new StringBuffer();
        br.append(root.val);
        br.append(",");
        br.append(serialize(root.left));
        br.append(serialize(root.right));
        return br.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sp=data.split(",");
        int[] count={0};
        return helper(sp,count);
    }
    public TreeNode helper(String[] sp,int[] count){
        if(sp[count[0]].equals("null")){
            count[0]++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(sp[count[0]]));
        count[0]++;
        root.left=helper(sp,count);
        root.right=helper(sp,count);
        return root;
    }
}