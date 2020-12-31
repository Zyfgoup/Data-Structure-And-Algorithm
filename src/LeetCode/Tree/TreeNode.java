package LeetCode.Tree;

/**
 * @Author Zyfgoup
 * @Date 2020/11/17 19:06
 * @Description
 */
public class TreeNode {
         int val;
     TreeNode left;
     TreeNode right;
     TreeNode next;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right,TreeNode next) {
          this.val = val;
          this.left = left;
          this.right = right;
          this.next = next;
      }
}
