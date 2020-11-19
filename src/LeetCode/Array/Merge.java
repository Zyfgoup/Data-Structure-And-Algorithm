package LeetCode.Array;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2020/8/19 18:40
 * @Description
 */
public class Merge {
    //两个数组有序 从后面开始插
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length-1; //控制新数组的下标
        m--;
        n--;

        while(n>=0){

            //如果下标m大于下标n的 就直接放到index 不用管原来的位置值没变 因为都是控制下标
            while(m>=0 && nums1[m]>nums2[n]){
                nums1[index--] = nums1[m--];
            }

            //如果m全部遍历完了 或者下标m小于等于于下标n的
            nums1[index--] = nums2[n--];
        }

    }


    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        Merge merge = new Merge();
        merge.merge(nums1,3,nums2,3);
        Arrays.stream(nums1).forEach(s-> System.out.print(s));

    }
}
