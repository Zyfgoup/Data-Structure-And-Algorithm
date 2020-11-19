package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Zyfgoup
 * @Date 2020/9/6 15:38
 * @Description leetcode 107
 */
public class _107二叉树的层次遍历 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root ==null){
            return new ArrayList<>();
        }

        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>(); //放一层数的数据

            //逐个遍历当前层的节点
            for(int i=0;i<size;i++) {
                //出队列 节点值放进list
                TreeNode temp = queue.poll();
                list.add(temp.val);

                //子节点放进队列
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }

            //从头插
            ans.addFirst(list);
        }

        return ans;

    }
}
