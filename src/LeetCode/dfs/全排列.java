package LeetCode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2021/4/11 23:14
 * @Description
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,res,list);
        return res;


    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list){
        if(list.size()==nums.length){

            //注意放新的list 不然会全部为空 因为有回溯
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            dfs(nums,res,list);
            list.remove(list.size()-1);
        }
    }
}
