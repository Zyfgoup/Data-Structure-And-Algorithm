package DFS;

/**
 * @Author Zyfgoup
 * @Date 2020/9/5 18:12
 * @Description
 *
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 随机给一个数字判断能否全部走完
 * 走过的不能走了
 */
public class 能否走遍全部格子 {

    static int count = 0;
    static boolean flag1 = false;
    static boolean[] flag = new boolean[13];

    public static void main(String[] args) {
        dfs(7);
        System.out.println(flag1);
        System.out.println(count);
    }

    static void   dfs(int n){
        if(n<1 || n>12){
            return;
        }

        if(flag[n] == true)
            return;


        count++;
        flag[n] = true;

        if(count == 12){
            flag1 = true;
            return;
        }

        dfs(n-1);
        dfs(n+1);
        dfs(n-4);
        dfs(n+4);
        count--;
    }
}
