package 栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author Zyfgoup
 * @Date 2020/8/6 0:38
 * @Description 栈只能先进后出  队列先进先出
 * 所以只能用一个栈插  当要出栈时  将第一个栈所有放到另外一个栈中 就翻转了
 * 当插入时 又要放回第一个栈中  来回翻转很浪费时间
 * 如果在出队操作时是连续的  那么就不需要又翻转了  判断此时2栈是否为空 不为空就不用翻转了
 *
 * 使用LinkedList模拟栈更简单
 */
public class 两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    public void appendTail(int value) {
        //放的时候 如果2栈有东西 则需要先翻转回来
        if(!stack2.empty())
            swap(stack2,stack1);
        stack1.push(value);
        
    }

    public int deleteHead() {

        if(stack1.empty()&&stack2.empty()){
            return -1;
        }

        //2栈为null需要翻转
        if(stack2.empty())
            swap(stack1,stack2);


        int value = stack2.pop();
        return value;
    }

    private void swap(Stack<Integer> stack1, Stack<Integer> stack2) {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
    }
}
