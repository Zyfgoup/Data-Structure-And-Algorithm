package Tree;

/**
 * @Author Zyfgoup
 * @Date 2020/12/22 17:07
 * @Description
 */
public class ReverseTree {


    /**
     * 前序遍历的架子
     * @param root
     */
    public static TreeNode reverse(TreeNode root){
        if(root==null){
            return null;
        }

        TreeNode temp = root.rightChild;
        root.rightChild = root.leftChild;
        root.leftChild = temp;

        reverse(root.leftChild);
        reverse(root.rightChild);

        return root;
    }
}
