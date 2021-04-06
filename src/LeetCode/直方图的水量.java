package LeetCode;

/**
 * @Author Zyfgoup
 * @Date 2021/4/4 23:45
 * @Description
 */
public class 直方图的水量 {

    /**
     * 暴力遍历  遍历计算每一个下标处的存水量
     * 找出每一个下标的左边和右边的最大
     * 然后取左右最大中的较小 与当前比较
     * 如果大于当前的高度(画图理解一下就好了) 才能存水
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;

        for(int i=1;i<height.length-1;i++){
            int leftMax = 0;
            int rightMax = 0;

            //找左边最大
            for(int j=i-1;j>=0;j--){
                if(height[j]>=leftMax){
                    leftMax = height[j];
                }
            }

            //如果比当前的高度小 那肯定存不了水  直接下一位
            if(height[i]>=leftMax)
                continue;

            //同理找右边的
            for(int j=i+1;j<height.length;j++){
                if(height[j]>=rightMax){
                    rightMax = height[j];
                }
            }
            if(height[i]>=rightMax)
                continue;


            int max = Math.min(leftMax,rightMax);
            sum += max-height[i];
        }
        return sum;
    }


    /**
     *  总体积-柱子体积=水的体积
     *  那么就可以看成全部是柱子  那么就是有好几层
     *  左右指针来判断每一层的长度
     *  某一边指针指到的height[i] >= 当前计算的层数 就停止移动  然后计算当前层数的长度  right-left+1
     *  然后层数+1 继续移动 找到下一层的长度
     * @param height
     * @return
     */
    public int trap1(int[] height){
        return 0;
    }
}
