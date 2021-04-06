package LeetCode.双指针;

/**
 * @Author Zyfgoup
 * @Date 2021/4/6 19:08
 * @Description
 */
public class _80删除有序数组中的重复项2 {
    public static void main(String[] args) {
        System.out.println( removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int slow = 0;
        int fast = 0;
        int temp  = nums[0];
        int count = 0;
        while(fast<nums.length){
            if(nums[fast] == temp){
                count++;
                if(count<=2){
                    nums[slow++] = nums[fast++];
                }else{
                    fast++;
                }
            }else{
                temp = nums[fast];
                count = 1;
                nums[slow++] = nums[fast++];

            }
        }


        return slow;

    }
}
