package LeetCode.单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author Zyfgoup
 * @Date 2020/11/17 16:01
 * @Description
 * 对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
 * 比如说给你输入T = [73,74,75,71,69,76]，你返回[1,1,3,2,1,0]
 * 解释：第一天 73 华氏度，第二天 74 华氏度，比 73 大，所以对于第一天，
 * 要等一天就能等到一个更暖和的气温，后面的同理。
 */
public class _1118一月有多少天 {

    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,76};
        Arrays.stream(dailyTemperatures(arr)).forEach(a-> System.out.print(a));
    }

    public static int[] dailyTemperatures(int[] arr){
            int[] res = new int[arr.length];
            Stack<Integer> stack = new Stack<>();

            for(int i=arr.length-1;i>=0;i--){
                while(!stack.isEmpty() && arr[stack.peek()]<=arr[i])
                    stack.pop();

                //入栈的是下标  栈顶的下标减去当前值的下标则为相差的天数
                res[i] = stack.isEmpty()?0:stack.peek()-i;
                stack.push(i);
            }
            return res;
    }
}
