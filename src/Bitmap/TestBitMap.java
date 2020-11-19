package Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/8/30 17:24
 * @Description
 * 一个int 4byte  32bit 那么就可以表示0到31
 * 那么要存储0到X的数据 那么就是用int数组 长度为n/32+1
 *
 * 当判读0到x的值中某个值存不存在可以用这种  前提是都是正整数
 */
public class TestBitMap {
    private int[] bitmap;

    //长度用long
    private  long length;

    /**
     * n>>5  表示右移5位  就是n/32 由于是从0开始 所以都是+1
     * 比如64
     * int[0] 表示0-31
     * int[1] 表示32-63
     * int[2] 表示64-95
     *
     * @param n 所需数组大小
     */
    public TestBitMap(long n){
        this.length = n;
        bitmap = new int[(int)(n>>5)+1];
    }

    public void setN(long value){
        if (value< 0 || value > length ) {
            throw new IllegalArgumentException("超出值的范围");
        }

        //bitmap的index = value >>5
        int index = (int)value >> 5;
        //首先要确定那个位置设置为1
        // 所以就是1 << value%32  value%32 是表示value在32位的哪一位来表示
        // 1 << 则就是1左移这么多位 那么就是该位变成1
        // 例如value 为8  8%32 = 8  1>>8  那么就是 000000001  -》 100000000
        // 又因为 value%32 == value& 31
        //然后就是bitmap[index] | 右边的值  或操作就是有1为1 所以就会把1全部保留下来 因为数据没有重复 所以不会存在位置重复
       bitmap[index] |= 1 << (value & 31);

    }

    public boolean isExist(long value) {
        if (value < 0 || value > length) {
            throw new IllegalArgumentException("超出值的范围");
        }

        int index = (int) value >> 5;
        int offest = (int) value & 31;
        int bitvalue = 1 << offest;
        //然后就是将bitmap[index] & bitvalue
        //因为bitmap[index]存的是这个 index*32-index+1*32-1这个范围的数
        //所以二进制的这个数和bitvalue 作 &操作 同1为1
        //结果如果是0 则不存在 不是0 则表示有1 那就是存在了
        return (bitmap[index] & bitvalue) != 0;
    }

        public void display(){
            System.out.println("BitMap位图展示");
            for(int i=0;i<bitmap.length;i++){
                List<Integer> list = new ArrayList<Integer>();
                int temp = bitmap[i];

                //每次取第一位 然后不断左移
                for(int j=0;j<32;j++){
                    list.add(temp & 1);
                    temp >>= 1;
                }
                //注意 在二进制表示中是从左往右 这里添加到list后是从右往左显示了
                System.out.println("bitmap["+i+"]" + list);
            }
        }

    public static void main(String[] args) {

        TestBitMap testBitMap = new TestBitMap(78);
        testBitMap.setN(34);
        testBitMap.setN(23);
        testBitMap.display();
        /**
         * BitMap位图展示
         * bitmap[0][0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0]
         * bitmap[1][0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         * bitmap[2][0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         */
    }

}
