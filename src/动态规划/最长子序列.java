package 动态规划;

/**
 * @Author Zyfgoup
 * @Date 2020/8/24 18:27
 * @Description
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 * abcde
 * ace
 *
 * dp[i][j] 表示第一个字符串的前i个字符和第2个字符串的前j个字符的公共子序列
 * 那么当 当前s1[i]跟s2[j]相等时
 * dp[i][j] = dp[i-1][j-1]+1;
 * 不相等的话 因为求最长  所以是两个字符串都
 * dp[i][j] = max(dp[i-1][j],dp[i][j-1])
 *
 */
public class 最长子序列 {
    public static  int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];


        //注意 这里长度是n+1 m+1
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //取字符时i-1 j-1
                char a = text1.charAt(i-1);
                char b = text2.charAt(j-1);
                if(a==b){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];



    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
}
