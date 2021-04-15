package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Zyfgoup
 * @Date 2021/4/11 20:46
 * @Description
 */
public class 银行窗口 {

    public static void main(String[] args) {
        int[] t = new int[]{20,5,10,20,5,5};
        int m = 6;
        int n = 3;

        String res = "";


        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = t[i];
            res += (i+1)+",";
        }

        for(int i=n;i<m;i++){

            int min = Integer.MAX_VALUE;
           for(int k=0;k<arr.length;k++){
               if(arr[k]<min){
                   min  = arr[k];
               }
           }

            for(int j=0;j<arr.length;j++){
                if(arr[j]!=min){
                    arr[j] -= min;
                }else{
                    arr[j] = t[i];
                    res+=(j+1)+",";
                }
            }

        }

        System.out.println(res.substring(0,res.length()-1)+"。");

    }
}
