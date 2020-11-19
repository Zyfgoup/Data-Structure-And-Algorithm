package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Zyfgoup
 * @Date 2020/8/13 16:46
 * @Description
 * 给你一个N*N的矩阵，每次删除（行列和）最大的一行、一列，直到删完。求，每一步删除的行i和列j。
 * 请注意，行列交点处的数字，求和只算一次。
 *
 *  砍一次后 数组还是N-1*N-1 那么就是一个子问题 dfs
 */
public class 网易笔试_十字斩 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        List<ArrayList<Integer>> arr = new ArrayList<>();

        //分别记录行 列的和
        List<Integer> rows = new ArrayList<>();
       List<Integer> cols = new ArrayList<>();
       for(int i=0;i<n;i++){
           rows.add(0);
           cols.add(0);
       }

        for(int i=0;i<n;i++){
           ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++){

              int value = cin.nextInt();
              temp.add(value);
             rows.set(i,rows.get(i)+value);
             cols.set(j,cols.get(j)+value);
            }
            arr.add(temp);
        }



        dfs(arr,rows,cols);
    }

    private static void  dfs(List<ArrayList<Integer>> arr, List<Integer> rows, List<Integer> cols) {
        if(arr.size()==0){
            return;
        }

        if(arr.size()==1){
            System.out.println("1 1");
            return ;
        }

        int maxi=0;
        int maxj=0;
        int max = -1;

        for(int i=0;i<rows.size();i++){
            for(int j=0;j<cols.size();j++){

                //i j位置会重叠一次 所以要减去一个
                if(rows.get(i)+cols.get(j)-arr.get(i).get(j)>max){
                    max = rows.get(i)+cols.get(j)-arr.get(i).get(j);
                    maxi = i;
                    maxj = j;
                }
            }
        }
        System.out.println(maxi+1+" "+(maxj+1));

        //删完要改变三个数组 才能递归

        //修改rows 每个数都要减去arr[i][maxj] 然后maxi后面的都往前移动一位
        for(int i=0;i<rows.size();i++){
            rows.set(i,rows.get(i)-arr.get(i).get(maxj));
        }

        rows.remove(maxi);

        //修改cols
        for(int j=0;j<cols.size();j++){
            cols.set(j,cols.get(j)-arr.get(maxi).get(j));
        }

        cols.remove(maxj);

        //arr
        //一行去掉
       arr.remove(maxi);

       //其余行该列也去掉
       for(int i=0;i<arr.size();i++){
           arr.get(i).remove(maxj);
       }


       //把改变完后的矩阵看成一个新的问题 递归
       dfs(arr,rows,cols);

    }
}
