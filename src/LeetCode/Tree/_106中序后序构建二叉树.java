package LeetCode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Zyfgoup
 * @Date 2020/12/25 17:03
 * @Description
 */
public class _106中序后序构建二叉树 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        //记录元素位置 不用每次递归都去遍历
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length,postorder,postorder.length,0,map);
    }

    private  static TreeNode build(int[] inorder, int i_start, int i_end, int[] postorder, int p_end, int p_start,Map<Integer, Integer> map) {

        //边界
        if(p_end == p_start){
            return null;
        }

        //根节点为前序遍历的第一个节点
        TreeNode root = new TreeNode(postorder[p_end-1]);
        int index = map.get(postorder[p_end-1]);

        int leftLen = index-i_start;


        //传值的边界
        root.left = build(inorder,i_start,i_start+leftLen,postorder,p_start+leftLen,p_start,map);
        root.right = build(inorder,index+1,i_end,postorder,p_end-1,p_start+leftLen,map);


        return root;

    }

    public static void main(String[] args) {

        int[] b = {9,3,15,20,7};
        int[] a = {9,15,7,20,3};
        TreeNode root = buildTree(b,a);
    }
}
