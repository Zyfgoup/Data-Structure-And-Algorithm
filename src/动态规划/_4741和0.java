package 动态规划;

/**
 * @Author Zyfgoup
 * @Date 2021/3/17 0:55
 * @Description
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 */
public class _4741和0 {

    /**
     * 01背包问题
     *
     * 0和1的个数 可以看成背包的容量  然后在这样的容量下 能放进最多个字符串  那就是只有要和不要
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(String str:strs){

            //统计当前字符串的01数量
            int zeros = 0;
            int ones = 0;
            for(char c : str.toCharArray()){
                if(c == '0'){
                    zeros++;
                }
                if(c == '1'){
                    ones++;
                }
            }


            /**
             * 这里不好理解 从后遍历  压缩状态
             * 从m n开始 到当前的字符串的01数量  表示这时候都可以选择是否把该字符串放入包里
             * 但是要的是最大子集，所以都要遍历更新一下
             * 第一次的时候 都是0  但是第二次了 此时dp[i][j]就不是0了 而是有以前的值了
             *
             *
             *
             * 三维数组 就比较好理解了   i表示能选的字符串  这样的话就是正这遍历
                dp[i][j][k] = dp[i - 1][j][k];
             * dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cnt[0]][k - cnt[1]] + 1);
             *

             */
            for(int i=m;i>=zeros;i--){
                for(int j=n;j>=ones;j--){
                    dp[i][j] = Math.max(dp[i][j],1+dp[i-zeros][j-ones]);
                }
            }
        }
        return dp[m][n];
    }
}

