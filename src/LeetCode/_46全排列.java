package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/8/6 0:18
 * @Description
 */
public class _46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        method1(nums,result,0);
        return result;
    }

    private void method1(int[] nums, List<List<Integer>> result,int k) {
        if(k==nums.length){
            List<Integer> list = new ArrayList<>();
           for(int i=0;i<nums.length;i++){
               list.add(nums[i]);
           }
           result.add(list);
        }

        //从k开始，每个元素与K交换
        for(int i=k;i<nums.length;i++){
            swap(nums,i,k);
            method1(nums,result,k+1);
            swap(nums,i,k);
        }
    }

    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    public static void main(String[] args) {
        _46全排列 test1 = new _46全排列();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = test1.permute(nums);

        System.out.println(permute);
    }
}
