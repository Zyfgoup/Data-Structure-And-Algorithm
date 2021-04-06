package LeetCode.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2021/4/1 0:20
 * @Description
 */
public class _486预测赢家 {

    //动态规划

    /**
     * 看懂了递归  dp公式也是一个思路
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {

        if(nums.length%2 == 0){
            return true;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = nums[i];
        }

        //从后遍历 是因为当前值需要使用到后面的值 所以从后遍历
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                int left = nums[i] - dp[i+1][j];
                int right = nums[j] - dp[i][j-1];

                dp[i][j] = Math.max(left,right);
            }
        }

//相等时 还是先手的赢
        return dp[0][n-1]>=0;
    }


    //递归

    /**
     * 当玩家先手选择左边 或者右边时  剩下的数组也是连续的  可以看成后手的人变成先手选择了
     * 子问题就出来了
     * 然后就是当只有一个时 那么就只能选这个
     *
     * 但是递归的是什么不好想
     * 这里递归的是净胜值
     * 因为只有一个时  返回的就是nums[i]  那么就表示当前先手的比后手的净胜nums[i]
     * 当前拿左边 那么剩下的就看以看成另外一个人先手拿的净胜值
     * 那么当前就是 左边-dfs
     * 拿右边同理
     * 然后取最大即可
     * 净胜值大于等于0 都是先手的赢  等于0表示相同 题目说明了为先手赢
     *
     * 其实如果元素为偶数个 先手一定赢 因为可以控制自己只拿奇数 或者 偶数项
     *
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner1(int[] nums) {
        return dfs(nums,0,nums.length-1)>=0;
    }

    public int dfs(int[] nums ,int i,int j){
        if(i == j){
            return nums[i];
        }

        int left = nums[i] - dfs(nums,i+1,j);
        int right = nums[j] - dfs(nums,i,j-1);
        return Math.max(left,right);
    }

}
