package LeetCode.单调栈;

import java.util.Stack;

/**
 * @Author Zyfgoup
 * @Date 2020/11/17 16:20
 * @Description
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 简单点就是复制数组长度多一倍即可 但是要控制结果数组的长度
    可以利用for循环里的n*2  但是下标都%取模n即可
 */
public class _503下一个更大的元素2 {



    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i= n*2-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }

            res[i%n] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);


        }
        return res;

    }
}
