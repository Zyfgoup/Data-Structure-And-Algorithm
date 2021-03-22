package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Zyfgoup
 * @Date 2021/3/21 21:44
 * @Description
 */
public class _73矩阵置0 {

    //O(m+n空间)
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row.contains(i)||col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

    }


    //
    public void setZeroes1(int[][] matrix) {

        //记录第一行第一列是否有0
        boolean rowFlag = false;
        boolean colFlag = false;

        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                rowFlag = true;
                break;
            }
        }

        for(int j=0;j<matrix.length;j++){
            if(matrix[j][0] == 0){
                colFlag = true;
                break;
            }
        }


        //都从1开始遍历 因为第一行第一列做记录
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] ==0){
                    //用第一行第一列来标志是否要为0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

            }
        }

        //如果第一行或者第一列对应的 有0  则置0
        for(int i=1;i<matrix.length;i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowFlag){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }

        if(colFlag){
            for(int j=0;j<matrix.length;j++){
                matrix[j][0] = 0;
            }
        }

    }
}
