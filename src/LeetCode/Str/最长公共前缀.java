package LeetCode.Str;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2020/8/11 16:23
 * @Description
 */
public class 最长公共前缀 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }


        //最长的公共前缀 最多也就是最短的元素
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLen = Math.min(minLen,strs[i].length());
        }
        String ans = strs[0].substring(0,minLen);

        for(int i=1;i<strs.length;i++){
            int j=0;
            //比第一个字符串与第2、3.。。。比较
            for(;j<ans.length()&&j<minLen;j++){
                if(ans.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
            }
            //每比一次就把ans变为1和2的最长公共前缀  然后再与3比.....
            ans = ans.substring(0,j);

        }
        return ans;
    }
}
