package LeetCode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Zyfgoup
 * @Date 2020/12/25 15:34
 * @Description
 */
public class _105前序中序构建二叉树 {

    public static  TreeNode buildTree(int[] preorder, int[] inorder) {

        //记录元素位置 不用每次递归都去遍历
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length,inorder,0,inorder.length,map);
    }

    private static  TreeNode build(int[] preorder, int p_start,int p_length,int[] inorder,int i_start,int i_length,Map<Integer, Integer> map) {

        //边界
        if(p_start==p_length){
            return null;
        }

        //根节点为前序遍历的第一个节点
        TreeNode root = new TreeNode(preorder[p_start]);
        int index = map.get(preorder[p_start]);

        //根据根节点在中序数组的位置 拆分 左边为左子树 右边为右子树



        //左子树长度
        int leftLength = index-i_start;

        //根据中序数组的拆分的左右数组的长度 也把前序拆分成两个数组 注意开始、结束位置的指针控制
        //看成左子树也是一个前序+中序数组构建二叉树  右边同理 递归
        root.left = build(preorder,p_start+1,p_start+leftLength+1,inorder,i_start,index,map);
        root.right = build(preorder,p_start+leftLength+1,p_length,inorder,index+1,i_length,map);


        return root;
    }


    public static void main(String[] args) {
        int[] a= {3,9,20,15,7};
        int[] b = {9,3,15,20,7};
        buildTree(a,b);
    }
}
