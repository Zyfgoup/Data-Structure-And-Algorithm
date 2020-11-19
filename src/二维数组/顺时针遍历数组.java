package 二维数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/11/18 10:08
 * @Description
 *
 * 每一层都是一口字  关键是要判定有多少层， 然后控制四条边
 * 然后注意上右下左时 会有元素重复要去掉
 *
 * 根据 1 2 3 4 5
 *     6 7 8 9 10
 *     11 12 13 14 15
 *
 *     1 2 3
 *     4 5 6
 *     7 8 9
 *     10 11 12
 *
 *     可以发现有多少层是根据行列中小的值+1/2来决定的
 *
 *     要考虑只有一行或者一列的时候 只遍历上 或者上右就行
 *     下左 需要加上判断是不是只有一行了
 */
public class 顺时针遍历数组 {


    //spiral 螺旋式
    public static  List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0 || matrix==null){
            return res;
        }
        //  -1是为了方便后面
        int n = matrix.length-1;
        int m = matrix[0].length-1;

        //层数
        int level = (Math.min(matrix.length,matrix[0].length)+1)/2;

        //只要确定了层数 就可以发现 层数确定了 相对应的遍历的下标就可以确定了
        for (int i = 0; i < level; i++) {

            //遍历上  i为遍历层数 层数就能确定的当前的行
            //行不变 列++
            for(int j=i;j<=m-i;j++){
                res.add(matrix[i][j]);
            }

            //遍历右
            //列不变 行++
            for(int j=i+1;j<=n-i;j++){
                res.add(matrix[j][m-i]);
            }

            //遍历下
            //行不变 列--
            // j一开始为m-i-1 因为右边第一个已经在遍历右时打印了
            //判断是不是只有最后一行了 n-i>is
            for(int j=m-i-1;j>=i && n-i>i;j--){
                res.add(matrix[n-i][j]);
            }

            //遍历左
            //列不变 行--  n-i-1同理上
            //j>=i+1 是因为最后一个在遍历上的打印了
            for(int j=n-i-1;j>=i+1 && m-i>i;j--){
                res.add(matrix[j][i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3,  4,  5  },
                { 6,  7,  8,  9,  10 },
                { 11, 12, 13, 14, 15 },
                {16,17,18,19,20},
        };
        int[][] matrix2 = {
                { 1,  2,  3 },
                { 4,  5,  6 },
                { 7,  8,  9 },
                { 10, 11, 12 },
                { 13, 14, 15 }
        };
        List<Integer> resultList1 = spiralOrder(matrix);
        System.out.println(Arrays.toString(resultList1.toArray()));
        List<Integer> resultList2 = spiralOrder(matrix2);
        System.out.println(Arrays.toString(resultList2.toArray()));
    }
}
