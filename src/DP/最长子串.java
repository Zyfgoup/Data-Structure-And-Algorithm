package DP;

/**
 * @Author Zyfgoup
 * @Date 2020/8/24 18:27
 * @Description 最长公共子串
 *
 * 如果s1[i] == s2[j]
 * dp[i][j] = dp[i-1][j-1]+1
 * 不相等的话 因为子串是连续的
 * dp[i][j] = 0
 *
 */
public class 最长子串 {

    public static int method1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //取字符时i-1 j-1
                char a = s1.charAt(i - 1);
                char b = s2.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }


            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( method1("asdcvf","r"));
    }
}
