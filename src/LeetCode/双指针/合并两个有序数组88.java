package LeetCode.双指针;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2020/9/28 16:18
 * @Description
 * 把归并结果存到第一个数组上。
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class 合并两个有序数组88 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,0,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,2,nums2,3);

      Arrays.stream(nums1).forEach(value -> System.out.print(value));
    }

    //放置与数组1的下标是根据两个数组的有效数字个数来决定的
    //m-1 n-1作为两个数组开始放置时候的小标
    //选择从大的开始放 那么就是比较大小的 大的先放进 nums1[index--] = big[下标--]
    //如果某个已经放完了 那么就直接放另外一个数组
    //直到控制两个数组的有效数字下标都小于0
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;//放置时候的下标
        int i=m-1;
        int j=n-1;
        while(i>=0 || j>=0){

            //如果第一个数组的都放完了 直接放第二个数组的
            if(i<0){
                nums1[index--] = nums2[j--];
            }else if(j<0){
                //第二个数组先放完了
                nums1[index--] = nums1[i--];
            }else if(nums1[i]<nums2[j]){
                nums1[index--] = nums2[j--];
            }else{
                nums1[index--] = nums1[i--];
            }


        }
    }

}
