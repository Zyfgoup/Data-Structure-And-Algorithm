package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Zyfgoup
 * @Date 2021/4/1 1:09
 * @Description  计算基本都是用栈
 */
public class _1006笨阶乘 {

    public static void main(String[] args) {
        System.out.println(clumsy(4));
    }

    public  static int clumsy(int N) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(N);
        N--;
        int index=0;
        while(N>0){

            //如果是乘除  就把栈顶取出来 运算放进去 加减就直接放  最后全部相加就可以了 不用考虑-  把-转换成+
            if(index%4 == 0 ){
                stack.addLast(stack.removeLast()*N);
            }else  if(index%4 == 1 ){
                stack.addLast(stack.removeLast()/N);
            } else  if(index%4 == 2 ){
                stack.addLast(N);
            } else{

                //  -某个数 可以看成+ （-n）
                stack.addLast(-N);
            }
            index++;
            N--;

        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.removeLast();
        }
        return sum;

    }

}
