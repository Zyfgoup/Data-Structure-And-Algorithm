package LeetCode.双指针;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Zyfgoup
 * @Date 2020/9/25 16:49
 * @Description
 * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
 *
 * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
 *
 * 时间复杂度为 O(N)：只需要遍历所有元素一次
 * 空间复杂度 O(1)：只需要使用两个额外变量
 */
public class 反转字符串中的元音字符345 {

    //把元音放在set里 然后判断
    private static final HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','o','u','i'
    ,'A','O','U','I','E'
    ));
    public static void main(String[] args) {
        System.out.println(reverseVowels("Leetcode"));
    }

    /**
     * 双指针判断 如果不是不存在与set 就移动
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        if(s==null || s.length()==0){
            return null;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;

        while(left<right){

            //找元音时要注意边界
            while(!set.contains(chars[left])&&left<right) {
                left++;
            }
            while(!set.contains(chars[right])&&left<right){
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            //交换后要移动指针 不然死循环了
            left++;
            right--;
        }

        return new String(chars);
    }
}
