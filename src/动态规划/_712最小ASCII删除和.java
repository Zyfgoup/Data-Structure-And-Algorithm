package 动态规划;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2020/11/19 16:53
 * @Description
 */
public class _712最小ASCII删除和 {
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp(s1, 0, s2, 0);
    }

    //将 s1[i..] 和 s2[j..] 删除成相同字符串，
// 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    public int dp(String s1,int i,String s2,int j){
        int res = 0;

        //如果某个字符串到头了 那么另外一个字符串剩下的都要删除
        if(i==s1.length()){
            for(;j<s2.length();j++){
                res += s2.charAt(j);
            }
            return res;
        }
        if(j==s2.length()){
            for(;i<s1.length();i++){
                res += s1.charAt(i);
            }
            return res;
        }

        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        if(s1.charAt(i)== s2.charAt(j)){
            //相同不用删
            memo[i][j] = dp(s1,i+1,s2,j+1);
        }else{
            //不相同删一个  取最小
            memo[i][j] = Math.min(s2.charAt(j)+dp(s1,i,s2,j+1),s1.charAt(i)+dp(s1,i+1,s2,j));
        }

        return memo[i][j];

    }
}
