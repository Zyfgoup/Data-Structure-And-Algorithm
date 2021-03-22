package 笔试.途牛;

import java.util.TreeMap;

/**
 * @Author Zyfgoup
 * @Date 2021/3/20 15:47
 * @Description
 */
public class Main2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val =3;
//        TreeNode left = new TreeNode();
//        left.val=3;
        TreeNode right = new TreeNode();
        right.val=1;
//        root.left = left;
        root.right = right;
        int[] error = findError(root);

        for (int i = 0; i < 2; i++) {
            System.out.println(error[i]);
        }

    }



    public static int[] findError (TreeNode root) {



        int[] arr = new int[2];
        arr[0] = root.val;
        arr[1] = root.val;
        dfs(root,arr);
        return arr;

    }
    public static  void dfs(TreeNode root,int[] arr){
        if(root == null){
            return;
        }

        if(root.left == null && root.right ==null){
            return;
        }



        dfs(root.left,arr);


        dfs(root.right,arr);
    }
}
   class TreeNode {
  int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
