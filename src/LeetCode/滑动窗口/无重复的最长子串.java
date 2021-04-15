package LeetCode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Zyfgoup
 * @Date 2020/8/20 0:27
 * @Description 滑动窗口
 * abcabcbb
 * 从0开始遍历 如果不存在则添加进map 要维护一个start end下标来计算长度
 * 如果在map中时 则要滑动窗口
 * 例如abc都能顺利添加 然后又到a 此时已经存在 所以start = 重复的字符的下标+1 然后继续遍历
 *
 */
public class 无重复的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;

        int n = s.length();
        int max = 0;
        int start = 0;
        Map<Character,Integer> map  = new HashMap<>();//存放字符和对应的下标

        //这里i就相当于end
        for(int i=0;i<n;i++){

            //如果存在
            if(map.containsKey(s.charAt(i))){

                //因为有可能重复的值的下标比现在的start还小 例如abba 当遍历最后a时 获取到下标为0
                //所以求当前和获取重复的值的下标的+1的最大值作为start

                //滑动
                start = Math.max(start,map.get(s.charAt(i))+1);
            }


            //不管存不存在都要放进去  如果存在会覆盖之前的 然后求max
            map.put(s.charAt(i),i);
            max = Math.max(max,i-start+1);
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
