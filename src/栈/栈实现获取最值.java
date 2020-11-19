package 栈;

import java.util.Stack;

/**
 * @Author Zyfgoup
 * @Date 2020/8/30 21:33
 * @Description 要求复杂度为O(1)
 * 用两个栈 一个栈放数据  一个维持最值
 */
public class 栈实现获取最值 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    public void push(int i){
        //放进栈1
        stack1.push(i);

        //维护当前栈1里的元素的最小值入栈2,所以栈2的栈顶就是当前栈1的元素的最值
        //那么就要比较当前要入栈的值 与 栈2的栈顶元素比较

        //为空直接插入
        if(stack2.empty()){
            stack2.push(i);
        }else{
            //如果小于当前栈2的栈顶 那么就要更新最小值
            if(i<stack2.peek()){
                stack2.push(i);
            }else{
                //不小于 那么就还是放栈顶的元素入栈2
                stack2.push(stack2.peek());
            }
        }
    }


    public Integer pop(){
        //栈1出栈顶元素
        //那么栈2也要出

        if(!stack1.empty() && !stack1.empty()){
            stack2.pop();
            return stack1.pop();
        }
        return null;
    }


    public Integer getMin(){
        if(!stack2.empty()){
            return stack2.peek();
        }

        return null;
    }
}
