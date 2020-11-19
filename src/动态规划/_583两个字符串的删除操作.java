package 动态规划;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2020/11/18 14:53
 * @Description
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，
 * 每步可以删除任意一个字符串中的一个字符。
 *
 * 示例：
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"

 */
public class _583两个字符串的删除操作 {
    //备忘录
    int[][] memo;

    public int minDistance(String word1, String word2) {
        //求出最长子序列
        int lcslen = longestCommonSubsequence(word1,word2);

        //减去长度
        return word1.length()-lcslen+word2.length()-lcslen;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];

        for(int[] row :memo){
            Arrays.fill(row,-1);
        }
        return dp(text1,0,text2,0);
    }

    public  int dp(String s1,int i,String s2,int j){
        if(i==s1.length() || j == s2.length()){
            return 0;
        }

        //先看备忘录
        if(memo[i][j]!=-1)
            return memo[i][j];

        //s[i]==s[j] 则继续往下找
        //不等于 则找i+1 j  i j+1 因为都会重复计算 s[i]=s[j] 所以可以用备忘录
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j] = 1+dp(s1,i+1,s2,j+1);
        }else{
            memo[i][j] = Math.max(dp(s1,i,s2,j+1),dp(s1,i+1,s2,j));
        }

        return memo[i][j];
    }
}
