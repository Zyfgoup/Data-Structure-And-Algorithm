package LeetCode.Str;

/**
 * @Author Zyfgoup
 * @Date 2020/8/24 22:49
 * @Description
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * s+s
 * 假如不是重复的  abc S+S abcabc
 * 从1开始找abc 那么返回的就是下标3 那就是abc的长度
 *
 * 如果是重复子串构成的
 * abcabcabc  S+S abcabcabcabcabcabc
 * 那么从1开始找abcabcabc 就是返回的4 不是abcabcabc的长度
 */
public class 重复的子字符串 {
    public static boolean repeatedSubstringPattern(String s) {
        System.out.println((s+s).indexOf(s, 1));
        return (s+s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        repeatedSubstringPattern("abcabcabc");
    }
}
