package LeetCode.Str;

/**
 * @Author Zyfgoup
 * @Date 2020/8/20 0:47
 * @Description 滑动窗口
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，
 * 从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 *输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 */
public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";

        //ASCII 128个字符
        int[] needs = new int[128]; //记录t中字符出现的次数
        int[] window = new int[128]; //记录s
        String res = "";

        for(int i=0;i<t.length();i++){
            needs[t.charAt(i)]++;
        }

        int right = 0;
        int left = 0;
        int minLen = s.length()+1;
        int count=0;//记录匹配的字符个数

        //遍历字符串s
        while(right < s.length()){
            char temp = s.charAt(right);
            window[temp]++;

            //如果这个字符在t字符中存在 且出现次数大于等于当前字符在s的出现次数才能匹配
            //如果小于了不能count++
            if(needs[temp]>0 && needs[temp] >= window[temp]){
                count++;
            }

            //如果匹配的个数到了t的长度
            while(count==t.length()){

                //长度
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    res = s.substring(left,right+1);
                }

                //缩小窗口
                //如果当前left指向的字符不是要匹配的则继续右移 直到移动到第一个匹配的字符 然后count--
                char temp1 = s.charAt(left);
                if(needs[temp1]>0 && needs[temp1]>=window[temp1]){
                    count--;
                }

                window[temp1]--;
                left++;

            }



            right++;


        }
        return res;
    }
}
