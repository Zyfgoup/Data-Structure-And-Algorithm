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
public class _107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root ==null){
            return new ArrayList<>();
        }

        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>(); //��һ����������

            //���������ǰ��Ľڵ�
            for(int i=0;i<size;i++) {
                //������ �ڵ�ֵ�Ž�list
                TreeNode temp = queue.poll();
                list.add(temp.val);

                //�ӽڵ�Ž�����
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }

            //��ͷ��
            ans.addFirst(list);
        }

        return ans;

    }
}
