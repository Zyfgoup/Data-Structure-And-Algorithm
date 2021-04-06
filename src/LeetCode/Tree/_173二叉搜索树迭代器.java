package LeetCode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Zyfgoup
 * @Date 2021/3/28 23:04
 * @Description 注意是二叉搜索树  根节点大于左节点小于右节点
 *
 * 提前把所有的值遍历并且保存起来的做法并不好，不是面试官想要的。
 * 举个场景：想通过 BST 的迭代器，判断 BST 中有没有 数值x。此时哪怕 数值x 是 BST 迭代器的第一个元素，
 * 上面的方法也会先把所有的值都遍历出来，时间复杂度到了O(N)
 *
 * 所以，设计迭代器的时候，应避免提前把所有的值都遍历出来；最好能设计成遍历过程中求 next 节点。那就需要用迭代方法了。

 * 把递归转成迭代，基本想法就是用栈。
 * 迭代总体思路是：栈中只保留左节点。
 * 思路必须从递归的访问顺序说起：
 * 中序遍历的访问顺序是 左子树 -> 根节点 -> 右子树 的顺序，并且对 左子树 和 右子树 也进行递归。
 *
 调用 next() 方法的时候，如果栈顶元素有右子树，则把所有右边节点即其所有左孩子全部放到了栈中，
 *
 */
public class _173二叉搜索树迭代器 {


}

class BSTIterator {
    private Deque<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        queue = new ArrayDeque<>();
        init(root,queue);
    }

    public void init(TreeNode root,Deque queue) {
        if (root == null) {
            return;
        }
            init(root.left, queue);
            queue.push(root);
            init(root.right, queue);

    }

    public int next(){
        return queue.removeLast().val;
    }

    public boolean hasNext() {
        return queue.size()>0;
    }
}

class BSTIterator1 {
    private Deque<TreeNode> stack;

    public BSTIterator1(TreeNode root) {
        stack = new ArrayDeque<>();
        init(root);
    }

    /*
        栈先进后出  将左子树所有入栈 所以第一个出的就是小的节点
     */
    public void init(TreeNode root) {
        while(root!=null){
            stack.addLast(root);
            root = root.left;
        }
    }

    public int next(){
        TreeNode cur = stack.pollLast();
        TreeNode node = cur.right;
        //当前cur如果有右节点 那么说明当前是中序遍历的中 那么就可以将右节点为根节点 下面又是一个树  跟初始化一样的情况
        while(node!=null){
            stack.addLast(node);
            node = node.left;
        }

        return cur.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
