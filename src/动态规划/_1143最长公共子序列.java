package 动态规划;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2020/11/18 14:40
 * @Description
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 */
public class _1143最长公共子序列{

    //备忘录
    int[][] memo;

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
