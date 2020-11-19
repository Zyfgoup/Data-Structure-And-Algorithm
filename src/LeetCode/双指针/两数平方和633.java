package LeetCode.双指针;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/9/25 16:31
 * @Description
 * 题目描述：判断一个非负整数是否为两个整数的平方和。
 *
 * 可以看成是在元素为 0~target 的有序数组中查找两个数，使得这两个数的平方和为 target，如果能找到，则返回 true，表示 target 是两个整数的平方和。
 *
 * 本题和 167. Two Sum II - Input array is sorted 类似，只有一个明显区别：一个是和为 target，一个是平方和为 target。本题同样可以使用双指针得到两个数，使其平方和为 target。
 *
 * 本题的关键是右指针的初始化，实现剪枝，从而降低时间复杂度。设右指针为 x，左指针固定为 0，为了使 02 + x2 的值尽可能接近 target，我们可以将 x 取为 sqrt(target)。
 *
 * 因为最多只需要遍历一次 0~sqrt(target)，所以时间复杂度为 O(sqrt(target))。又因为只使用了两个额外的变量，因此空间复杂度为 O(1)。
 */
public class 两数平方和633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));

        System.out.println(Math.ceil(5.5)); //向上舍入
        System.out.println(Math.round(5.5)); //四舍五入
        System.out.println(Math.floor(5.5));

    }

    public static  boolean judgeSquareSum(int target) {
        int i = 0;

        //平方和  所以最大j为target的开方
        int j = (int)Math.sqrt(target);
        System.out.println(j);

        while(i<j){
            int res = i*i + j*j;
            if( res == target)
                return true;
            else if(res>target)
                j--;
            else
                i++;
        }

        return false;


    }
}
