package LeetCode.Array;

/**
 * @Author Zyfgoup
 * @Date 2021/3/22 21:29
 * @Description
 * 用数组实现
 */
public class 大数阶乘 {
    public static void main(String[] args) {
        m1(10);
    }


    public static void m1(int n) {
        int[] arr = new int[10000];
        int res = 0;
        int jin = 0;
        arr[0] = 1;
        int count = 1; //计数  但不准确  可能会多一些0  遍历的时候从后面遍历 找第一个不是0的

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < count; j++) {
                int temp = arr[j] * i;
                if (temp + jin < 10) {
                    arr[j] = temp + jin;
                    jin = 0;
                } else {
                    arr[j] = (temp + jin) % 10;
                    jin = (temp + jin) / 10;
                    count++;
                }
            }
        }

        for (int i = count; i >= 0; i--) {
            if (arr[i] != 0) {
                for (int j = i; j >= 0; j--) {
                    System.out.print(arr[j]);
                }
                break;
            }


        }


    }

}
