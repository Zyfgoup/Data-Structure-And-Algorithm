package LeetCode.单调栈;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author Zyfgoup
 * @Date 2020/11/16 16:46
 * @Description
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
 * 如果不存在，对应位置输出 -1 。
 * 重点注意是：对应位置
 *

 *
 *输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 *
 *
 * 把数组想象成站着的人 先求出nums2里的每个值的下一个更大元素 然后放进Map里  4看不到 num2中有比它高的
 * 1 能看到对应num2的3
 * 2什么也看不到
 */
public class _496下一个更大的元素 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
       Arrays.stream(nextGreaterElement(nums1,nums2)).forEach(s-> System.out.print(s+" "));

    }



    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();


        //倒序
        for (int i = nums2.length-1; i >=0 ; i--) {

            //如果不为空 且栈顶比当前的值小 说明看不到  出栈
            while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                stack.pop();
            }

            //如果为空 则表示当前值前面看不到别的数值 放-1  或者是栈顶
            map.put(nums2[i],stack.isEmpty()?-1:stack.peek());

            //每个数都会入栈一次 也会出栈
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElement1(int[] findNums, int[] nums) {
        Stack < Integer > stack = new Stack < > ();
        HashMap < Integer, Integer > map = new HashMap < > ();
        int[] res = new int[findNums.length];

        //顺序遍历
        for (int i = 0; i < nums.length; i++) {
            //如果当前元素大于栈顶 则为栈顶元素的下一个更大元素 直接存入map
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        //遍历完后 栈不为空 那么其中的元素都找不到更大的元素
        while (!stack.empty())
            map.put(stack.pop(), -1);

        //for 根据值去map找即可
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }


}
