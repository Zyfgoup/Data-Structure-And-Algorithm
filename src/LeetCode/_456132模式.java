package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Zyfgoup
 * @Date 2021/3/24 22:54
 * @Description
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k]
 * 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false
 *

 */
public class _456132模式 {


    //暴力找k  遍历j  然后k是n-1到j的范围   i就是维护一个最小值  nums[j]左边的最小值
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int numsi = nums[0];
        for(int j=1;j<n;j++){
            for(int k = n-1;k>j;k--){
                if(numsi<nums[k] && nums[k]<nums[j]){
                    return true;
                }
                numsi = Math.min(numsi,nums[j]);
            }
        }
        return false;
    }


    /**
     * 单调栈解决
     * @param nums
     * @return
     */
    public boolean find132pattern1(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int numsk = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();


        //从后面遍历 找到nums[k]
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<numsk){
                return true;
            }

            //遍历找到次二大的值
            //当前值 可以看成numsj 那么栈里的元素 下标都比j大
            //只要找出比numsj小的里面最大的  就是次二大的
            //那么此时只要有一个比numsk小 则为132模式
            while(stack.size()!=0 && stack.peekLast()<nums[i]){

                //
                numsk =stack.removeLast();
            }

            //维护一个单调栈  入栈  栈底最大
            stack.addLast(nums[i]);
        }
        return false;
    }



}
