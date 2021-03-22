package TenSort;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2020/8/19 17:34
 * @Description
 */
public class HeapSort {

    public void heapsort(int[] arr){
        //堆化成大顶堆
        maxHeap(arr);
        for(int i=arr.length-1;i>=0;i--){

            //每次把第一个与最后一个交换  第一个是根总是最大的
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //然后堆化下去
            maxHeapDown(arr,0,i);
        }
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
    }

    //从最后节点的父节点开始
    //最后节点为arr.length-1  所以其父节点是(arr.length-1-1)/2  = arr.length/2-1
    private void maxHeap(int[] arr) {
        for(int i=arr.length/2-1;i>=0;i--) {
            maxHeapDown(arr, i, arr.length);
        }
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
        System.out.println();
    }

    /**
     *
     * @param arr
     * @param i 此时的根节点
     * @param length 数组的长度  这样设置只是为了在堆排序时 因为数组长度不断减短
     */
    private void maxHeapDown(int[] arr, int i, int length) {
        if(i>=length||(i*2+1)>=length||(i*2+2)>=length) {
            return;
        }

        int left = 2*i+1; //左节点
        int right = 2*i+2; //右节点

        int temp = arr[i];
        int min = left;


        //找到左右节点中大的那个
        if(arr[left]<arr[right]){
            min = right;
        }

        //如果节点中大的那个与根交换
        if(arr[min]>temp){
            arr[i] = arr[min];
            arr[min] = temp;
        }

        //递归 此时根节点为与i交换的min
        maxHeapDown(arr,min,length);

    }

    public static void main(String[] args) {
        int[] arr = {21,5,46,5,1,324,34,22,58};
        HeapSort heapSort = new HeapSort();
        heapSort.heapsort(arr);
    }
}
