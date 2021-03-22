package 笔试.途牛;

/**
 * @Author Zyfgoup
 * @Date 2021/3/20 15:37
 * @Description
 */
public class Main1 {

    public int[] findTopKinTwoSortedArray (int[] arr1, int[] arr2, int k) {
       int count = 0;
       int index1 = arr1.length-1;
       int index2 = arr2.length-2;
       int[] res = new int[k];
       while(count<k){
           res[count++] = arr1[index1--]+arr2[index2--];
       }
       return res;
    }
}
