package LeetCode.双指针;

/**
 * @Author Zyfgoup
 * @Date 2020/9/27 16:59
 * @Description
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 *
 * 所谓的回文字符串，是指具有左右对称特点的字符串，例如 "abcba" 就是一个回文字符串。
 *
 * 使用双指针可以很容易判断一个字符串是否是回文字符串：令一个指针从左到右遍历，一个指针从右到左遍历，
 * 这两个指针同时移动一个位置，每次都判断两个指针指向的字符是否相同，
 * 如果都相同，字符串才是具有左右对称性质的回文字符串。
 *
 * 当遍历到不相同时，则删掉左边或者右边的继续遍历
 */
public class 回文字符串680 {

    public static void main(String[] args) {
        System.out.println(validPalindrome("abcbfa"));
    }

    public static boolean validPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){

                //左边或者右边删一个 其实就是指针移动
                return  isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
