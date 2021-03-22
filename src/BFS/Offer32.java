package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Zyfgoup
 * @Date 2020/9/6 16:01
 * @Description 从上到下打印二叉树
 */
public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return null;
        }

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while(!queue.isEmpty()){
            int size = queue.size();

            //���������ǰ��Ľڵ�
            for(int i=0;i<size;i++) {
                //������ �ڵ�ֵ�Ž�list
                TreeNode temp = queue.poll();
                ans.add(temp.val);

                //�ӽڵ�Ž�����
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
