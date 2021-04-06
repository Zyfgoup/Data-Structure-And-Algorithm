package LeetCode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2021/4/1 0:42
 * @Description
 */
public class _78子集 {
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        list.add(new ArrayList<Integer>());
        List<Integer> temp  = new ArrayList<>();
        dfs(nums,0,temp);
        return list;
    }

    public static void dfs(int[] nums,int i,List temp){
        if(i == nums.length){
            return;
        }
        for(int j=i;j<nums.length;j++){
            temp.add(nums[j]);
            dfs(nums,j+1,temp);

            //用新List装 不然最后都是空的
            list.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }
    }
}
