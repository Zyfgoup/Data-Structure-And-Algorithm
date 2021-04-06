package LeetCode.Array;

/**
 * @Author Zyfgoup
 * @Date 2021/3/30 23:27
 * @Description
 */
public class _74搜索二维矩阵 {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target =3;
        System.out.println(binarySearch(matrix,target));
    }

    public static boolean binarySearch(int[][] matrix,int target){
        int begin = 0;
        int end = matrix.length*matrix[0].length-1;

        while(begin<=end){
            int mid = (begin+end)/2;
            int i = mid/matrix[0].length;
            int j = mid%matrix[0].length;

            if(matrix[i][j]<target){
                begin = mid+1;
            }else if(matrix[i][j]>target){
                end = mid-1;
            }else{
                return true;
            }
        }
        return  false;

    }
}
