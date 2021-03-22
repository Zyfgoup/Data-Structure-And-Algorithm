package 动态规划;

/**
 * @Author Zyfgoup
 * @Date 2021/3/22 22:24
 * @Description  子序列可以不是连续的  这个状态转移公式不好想
 *
 * dp[i] 表示 nums[0]到nums[i]的最长子序列
 *
 * nums[i] > nums[j]时
 * dp[i] = Math(dp[i],1+dp[j])
 *
 *
 *
 *
 */
public class 最长上升子序列 {

    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1){
            return 1;
        }

        int n = nums.length;
        int[] dp = new int[n];


        //遍历0-n
        for(int i=0;i<n;i++){
            dp[i] =1;  //自身就是上升序列1


            //遍历0到i
            for(int j=0;j<i;j++){

                //因为可以不是连续的 所以都要判断i是否大于j
                //如果大于 那么就表示 j到i是一个上升子序列 就需要比较
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }


        int max = 0;
        for(int i=0;i<n;i++){
            if(dp[i]>max)
                max = dp[i];
        }
        return max;

    }
}
