package Tree;

/**
 * @Author Zyfgoup
 * @Date 2020/9/5 17:57
 * @Description
 */
public class 遍历树 {


    /**
     * 先输出根节点 然后遍历左 然后右
     * @param root
     */
    public static void  前序遍历(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.s+" ");
        前序遍历(root.leftChild);
        前序遍历(root.rightChild);
    }

    /**
     * 先遍历左子树
     * 输出根节点
     * 遍历右子树
     *
     * 遍历下一层的时候也是按照这样的顺序
     * @param root
     */
    public static void 中序遍历(TreeNode root){
        if(root == null){
            return;
        }
        中序遍历(root.leftChild);
        System.out.print(root.s+" ");
        中序遍历(root.rightChild);
    }

    /**
     * 先遍历左子树
     * 遍历右子树
     * 输出根
     *
     * @param root
     */
    public static void 后序遍历(TreeNode root){
        if(root == null){
            return;
        }
        后序遍历(root.leftChild);
        后序遍历(root.rightChild);
        System.out.print(root.s+" ");
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode("Q");
        TreeNode node2 = new TreeNode("I");
        TreeNode node3 = new TreeNode("P");
        TreeNode node4 = new TreeNode("A");
        TreeNode node5 = new TreeNode("C");
        TreeNode node6 = new TreeNode("B");
        TreeNode node7 = new TreeNode("G");
        TreeNode node8 = new TreeNode("O");

        node1.leftChild = node2;
        node1.rightChild = node3;
        node2.leftChild = node4;
        node2.rightChild = node5;
        node5.leftChild = node6;

        node3.rightChild = node8;
        node3.leftChild = node7;

        后序遍历(node1);
        System.out.println();
        中序遍历(node1);
        System.out.println();
        前序遍历(node1);

        /*
        A B C I G O P Q
        A I B C Q G P O
        Q I A C B P G O
         */




    }
}
