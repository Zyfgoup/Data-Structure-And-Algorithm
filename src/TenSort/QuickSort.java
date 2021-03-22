package TenSort;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2021/3/14 15:29
 * @Description
 */
public class QuickSort {

    public static void main(String[] args){
        int[] arr = {7,45,4,6,78,13,79,34,56,22,2};
        sort(arr,0,10);
        System.out.println(Arrays.toString(arr));

    }

    public static void  sort(int[] arr,int begin,int end){
        if(begin<end){
            int p = partition(arr,begin,end);
            sort(arr,begin,p);
            sort(arr,p+1,end);
        }

    }

    private static int partition(int[] arr, int begin, int end) {

        //简单点去第一个做为枢纽
        int privot = arr[begin];
        int left = begin+1;
        int right = end;

        while(left<=right){
            while(arr[left]<=privot){
                left++;
            }
            while(arr[right]>privot){
                --right;
            }

            if(left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        //出循环了 表示交叉了  此时right指向小于privot  left指向大于privot
        arr[begin] = arr[right];
        arr[right] = privot;
        return right;

    }
}
