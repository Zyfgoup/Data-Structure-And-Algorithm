package LeetCode;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2020/10/9 16:43
 * @Description
 */
public class fibonaqiSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int arr[] = {1,8,10,89,100,230};
        System.out.println(fibSearch(arr,100));
    }
    //首先得到一个斐波那契数列，mid的值是low+F(k-1)-1
    public static int[] fib(){
        int f[] = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    //斐波那契查找算法
    public static int fibSearch(int[] arr,int key){
        int low = 0;
        int high = arr.length -1;
        int k = 0;//表示斐波那契分割的值
        int mid = 0;//存放黄金分割点的值
        int f[] = fib();//得到斐波那契数列
        //找到k值
        while (high>=f[k] - 1){
            k++;
        }
        //复制到新的数组
        int temp[] = Arrays.copyOf(arr,f[k]);
        //得到f[k]的值可能会大于a的长度,将新数组的多余的部分用数组中的最后一个数字填充
        for (int i = high+1; i <temp.length ; i++) {
            temp[i] = arr[high];
        }
        //使用while循环，找到key
        while (low<=high){//满足这个条件就可以继续找
            mid = low+f[k-1]-1;//找到的黄金分割点
            if(key<temp[mid]){//查找的值小于该点的时候就往后找
                high = mid - 1;
                k--;
            }else if(key>temp[mid]){
                low = mid + 1;
                k-=2;
            }else{
                if(mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }

}
