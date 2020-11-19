package LeetCode.Array;

/**
 * @Author Zyfgoup
 * @Date 2020/8/20 16:48
 * @Description 滑动窗口
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 */
public class 长度最小的子数组 {
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0)
            return 0;
        int minlen = s+1;
        int left = 0;
        int sum=0;
        int index=0;
        while(index<nums.length){
            //加上当前下标的值
            sum+=nums[index];

            while(sum>=s){
                //求出最短
                minlen = Math.min(minlen,index-left+1);

                //缩小左边窗口
                sum-=nums[left++];
            }
            index++;
        }

        //如果minlen没有变化  返回0
        if(minlen==s+1){
            return 0;
        }

        return minlen;
    }

    public static void main(String[] args) {
        System.out.println( minSubArrayLen(3,new int[]{1,1}));
    }
}
