package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Zyfgoup
 * @Date 2020/9/6 16:01
 * @Description
 */
public class 剑指offer32从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return null;
        }

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while(!queue.isEmpty()){
            int size = queue.size();

            //逐个遍历当前层的节点
            for(int i=0;i<size;i++) {
                //出队列 节点值放进list
                TreeNode temp = queue.poll();
                ans.add(temp.val);

                //子节点放进队列
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }



        }

      return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}
