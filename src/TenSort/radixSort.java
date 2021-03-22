package TenSort;

/**
 * @Author Zyfgoup
 * @Date 2021/3/19 21:21
 * @Description
 * 基数排序
 */
public class radixSort {

    public static void main(String[] args) {

    }

    public int[] sort(int[] nums){
        int maxValue = 0;

        //找出最大值
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxValue){
                maxValue = nums[i];
            }
        }

        //基数排序
        int k = 1;

        int[] buf = new int[nums.length]; //装每轮排序后的数组


        while(maxValue>=k){
            int[] count = new int[10]; //计算每个位置有多少个元素
            for(int i=0;i<nums.length;i++){
                count[nums[i]/k%10]++;
            }

            //通过遍历后可以来确定 count[i]的值 就是在这一轮排序后的第几个
            //方便后面放入临时数组中的下标 假设 count[3] = 1  count[2]=1 count[1] =1
            //那么 遍历后  count[3] = 3 则表示这一轮中下标为3的数 在第三位 那么放到临时数组中就是3-1 buf[2]中
            //因为从0开始
            for(int i=1;i<10;i++){
                count[i]+=count[i-1];
            }


            //注意要倒序 因为count[i]在没有经过上面遍历之前本身可能大于1  那么此时遍历后值就比较大了
            //前面是正序来计算count
            // 那么就应该在原数组后面的值先插入到下标比较大的地方
            for(int i = nums.length-1;i>=0;i--){
                buf[count[nums[i]/k%10]-1] = nums[i];
                count[nums[i]/k%10]--;
            }

            for(int i=0;i<buf.length;i++){
                nums[i] = buf[i];
            }

            k*=10;

        }
        return nums;

    }
}
