import java.util.HashSet;
import java.util.Set;

/**
 * @Author Zyfgoup
 * @Date 2020/8/20 19:24
 * @Description
 */
public class Test1 {
    public static void main(String[] args) {
        method1(6,3);

        Set<Integer> set = new HashSet<>();
    }


    public static  void  method1(int n,int m){
        int count = 1;
        int[][] res = new int[n][m];
        int max = n*m;
        int leftup = 0;
        int leftdown = n-1;
        int rightup = 0;
        int rightdown = m-1;

        while(leftup<=leftdown && rightup<=rightdown){
            int left = leftup;
            int right = rightup;

            //横向
            while(right<=rightdown &&count<=max){
                res[left][right++] = count++;
            }
            right--;
            left++;

            //竖向
            while(left<=leftdown &&count<=max){
                res[left++][right] = count++;
            }
            left--;
            right--;

            //倒着横向
            while(right>=rightup &&count<=max){
                res[left][right--] = count++;
            }
            right++;
            left--;



            while(left>leftup &&count<=max){
                res[left--][right] = count++;
            }
            left++;
            right++;


            leftup++; //上边界
            rightdown--; //右边界
            rightup++;//左边界
            leftdown--;//下边界

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }

    }
}
