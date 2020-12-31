package LeetCode.Tree;

/**
 * @Author Zyfgoup
 * @Date 2020/12/24 19:26
 * @Description
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */

public class _114二叉树展开成链表 {



    //后序
    //定义函数的意义 将左子树拉到右子树 且左子树在右子树前面
    public void flatten(TreeNode root) {
        if(root==null)
            return;


        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        //左为空 右为左子树  然后左子树最后一个的右子节点接上原本的右子树
        root.left = null;
        root.right = left;

        //遍历右树 到最后一个
        TreeNode temp = root;
        while(root.right!=null){
            temp = temp.right;
        }

        //连接原本的右子节点
        temp.right = right;

    }
}
