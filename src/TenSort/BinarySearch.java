package TenSort;

/**
 * @Author Zyfgoup
 * @Date 2021/3/20 23:57
 * @Description
 */
public class BinarySearch {


    public int search(int[] arr,int k){
        if(arr[0]>k || arr[arr.length-1]<k){
            return -1;
        }
        int begin = k;
        int end = arr.length-1;
        while(begin<=end){

            //防止溢出  int  (end+begin)   >>相当于/2
            int mid = begin+(end-begin)>>2;
            if(arr[mid] == k)
                return mid;
            if(arr[mid]<k){
                begin = mid+1;
            }
            if(arr[mid]>k){
                end = mid-1;
            }

            mid = (begin+end)/2;
        }

        return -1;
    }
}
