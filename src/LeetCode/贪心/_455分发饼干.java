package LeetCode.贪心;

import java.util.Arrays;

/**
 * @Author Zyfgoup
 * @Date 2020/12/29 13:48
 * @Description
 */
public class _455分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        if(g.length==0 || s.length ==0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = s.length-1;

        //遍历小孩的胃口 从大到小  这样也拿最大的饼干去喂 如果可以 下一个  不可以则小孩换下一个
        // 所以小孩都要走
        for(int i=g.length-1;i>=0;i--) {
            if (index >= 0 && s[index] >= g[i]) {
                //满足
                index--;
                count++;
            }
        }
        return count;
    }

}
