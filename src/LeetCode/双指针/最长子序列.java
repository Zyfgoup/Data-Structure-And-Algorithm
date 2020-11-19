package LeetCode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/9/29 17:10
 * @Description 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。
 * 如果有多个相同长度的结果，返回字典序的最小字符串。
 * <p>
 * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，
 * 我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列
 */
public class 最长子序列 {

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"));
        System.out.println(findLongestWord(s, d));

    }


    public static String findLongestWord(String s, List<String> d) {
        String longestWord = ""; //表示当前匹配的字符串
        for (String target : d) {
            int l1 = longestWord.length();
            int l2 = target.length();

            //如果当前匹配的longestWord长度比当前遍历的target长 或者长度相等字典序小则不需要继续判断了
            if (l1 > l2 || l1 == l2 && longestWord.compareTo(target) < 0) {
                continue;
            }

            if (isSubstr(s, target)) {
                longestWord = target;
            }

        }
        return longestWord;
    }

    public static boolean isSubstr(String s, String target) {

        int i = 0;//s
        int j = 0;//target
        while (i < s.length() && j < target.length()) {

            //如果匹配  j++  不匹配i++
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;

            //判断j的长度等不等于target的长度  如果等于表示全部字符都匹配了
            if (j == target.length()) {
                return true;
            }

        }
        return false;
    }

}
