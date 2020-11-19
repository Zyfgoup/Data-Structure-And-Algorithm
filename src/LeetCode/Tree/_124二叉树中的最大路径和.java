package LeetCode.Tree;

/**
 * @Author Zyfgoup
 * @Date 2020/11/17 18:50
 * @Description
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出：42
 *
 * 路径不一定从根节点开始  从15开始到20到7 42
 * 当 20 15 7时  可能的情况就是
 * 20+15+20的父节点
 * 或者20+7+20的父节点
 * 或者20+15+7直接结束
 *
 * 前两种情况就是返回左右节点最大值+当前值返回给上一层
 * left+right+当前 也在每一层递归中计算了
 * 最后返回的是记录最大值的ans
 *
 * 说到底还是一个后序遍历
 * void traverse(TreeNode root) {
 *     // 前序遍历
 *     traverse(root.left)
 *     // 中序遍历
 *     traverse(root.right)
 *     // 后序遍历
 * }
 *
 */
public class _124二叉树中的最大路径和 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);

        //返回的是ans 递归中已经记录了
        return ans;
    }

    public int max(TreeNode root){

        //递归 边界条件必须
        if(root==null){
            return 0;
        }

        //与0比较 如果小于0则不要
        int left = Math.max(0,max(root.left));
        int right = Math.max(0,max(root.right));
        //结果取最大的
        ans = Math.max(ans,left+right+root.val);

        //返回左右节点中最大的+当前的值 因为只能走一边
        return Math.max(left,right)+root.val;
    }
}
