package LeetCode.Str;

import java.util.ArrayList;

/**
 * @Author Zyfgoup
 * @Date 2020/8/11 17:27
 * @Description
 *
 * “ac”
 * 回文串是a
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));

    }

    public static String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }



        //表示如果没有则返回第一个字符  也是回文串
        int maxLen = 1;
        int begin = 0;
        char[] arr = s.toCharArray();

        //i j表示串的两端的下标
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
               if(j-i+1>maxLen&&validPalindromic(arr,i,j)){
                   maxLen = j - i + 1;
                   begin = i;
               }
            }
        }

        //index  endindex  左闭又开
        return s.substring(begin,begin+maxLen);


    }

    private static  boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     *
     *一个回文串的头尾字符肯定是相同的
     * 如果头尾相同去除掉头尾后的子串如果是回文串 那么这个串就是回文串
     * 假设定义dp[i][j]表示字符串s[i]..s[j]是不是回文子串
     * 那么dp[i][j] = (s[i]==s[j] && dp[i+1][j-1])
     * 而初始化时 单个字符都是回文串 所以dp[i][i] = true;
     *
     * i<=j是必须的
     * i+1和j-1 如果是长度为i+1=j-1时 那么只有一个字符 肯定是true
     * 可以推出如果dp[i][j]如果是长度长度为3或者2的情况下
     * 如果s[i]==s[j] 那么就不需要状态转移了 肯定是回文串了
     * 所以就是j-i<3的情况
     *  @param s
     * @return
     */
    public  static String  dp(String s){
        if(s.length()<2){
            return s;
        }
        int maxLen = 1;
        int begin =0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            dp[i][i] = true;


        }


        //注意一个打表的顺序
        // 由于状态转移需要使用到i+1 j-1的状态
        //那么打表的顺序就很重要 不然就拿不到状态转移的值了

        //第一个for表示end
        //第二个是start 然后逐渐变短
        //而不是像暴力那样 先定start 然后不断变长的子串
        for(int j=1;j<s.length();j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    //长度小于3时  直接判断
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);



    }


}
