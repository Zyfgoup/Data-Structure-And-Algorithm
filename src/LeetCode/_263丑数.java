package LeetCode;

/**
 * @Author Zyfgoup
 * @Date 2021/4/10 10:57
 * @Description
 */
public class _263丑数 {

    public boolean isUgly(int n) {
        if(n<=1){
            return false;
        }
        return dfs(n);

    }

    public boolean dfs(int n){
        boolean res = false;
        if(n==1){
            return true;
        }

        if(n%2==0){
            res =  dfs(n/2);
        }

        if(n%3 == 0){
            res = dfs(n/3);
        }

        if(n%5 == 0){
            res = dfs(n/5);
        }

        return res;

    }
}
