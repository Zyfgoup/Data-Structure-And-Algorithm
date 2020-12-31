package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Zyfgoup
 * @Date 2020/12/23 16:59
 * @Description
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 */
public class _116填充每个节点的下一个右侧节点 {


    public static TreeNode connnect(TreeNode root){
        if(root == null){
            return null;
        }
        connectTwoNode(root.left,root.right);
        return  root;
    }

    /**
     * 连接 node1 node2  node1.next = node2
     * @param node1
     * @param node2
     * @return
     */
    public static void  connectTwoNode(TreeNode node1,TreeNode node2){

        //边界
        if(node1==null || node2 ==null){
            return;
        }

        //连接两个节点
        node1.next = node2;

        //递归下去连接各个相邻的节点
        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node1.right,node2.left);
        connectTwoNode(node2.left,node2.right);
    }

    //层序遍历树 从上到下 从左到右 使用队列 一个出 两个左右节点进
    public static  void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()!=0){
            int size = queue.size();

            //树的一层的遍历
            while(size-->0){
                //出队列
                TreeNode temp = queue.poll();
                //next 如果本层还有节点则指向队列头  size==0则到本层最后一个 指向null
                temp.next = size == 0?null:queue.peek();

                //左右节点入队
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
