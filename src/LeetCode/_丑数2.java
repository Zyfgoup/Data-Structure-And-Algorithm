package LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @Author Zyfgoup
 * @Date 2021/4/11 17:18
 * @Description
 */
public class _丑数2 {
    int[] nums = new int[]{2,3,5};


    /**
     * 小顶堆  优先队列
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        Queue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.add(1L);

        for(int i=1;i<=n;i++){
            long temp = pq.poll();
            if(i==n){
                return (int)temp;
            }
            for(int num:nums){
                Long res = temp*num;
                if(!set.contains(res)){
                    set.add(res);
                    pq.add(res);
                }
            }


        }
        return -1;
    }
}
