package 笔试;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Zyfgoup
 * @Date 2021/3/7 13:08
 * @Description
 */
public class _闭合标点符合检测 {

    public  static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        System.out.println(m1(s));

    }

    //双引号忽略出栈 计数来解决 最后算长度如果为0 或者flag2的倍数则符合
    public static boolean m1(String s){
        int flag = 0;
        Stack<Character> stack = new Stack<>();
        int len =s.length();
        for (int i = 0; i <len ; i++) {
            char c = s.charAt(i);
            if(c == '{'){
                stack.push(c);
            }

            //要插入 但是不用处
            if(c == '\"'){
                ++flag;
            }


            if(c == '{')
                stack.push(c);

            if(c =='}'){
                Character peek = stack.peek();
                if(peek == '{'){
                    stack.pop();
                }else
                    return false;
            }

            if(c ==']'){
                Character peek = stack.peek();
                if(peek == '['){
                    stack.pop();
                }else
                    return false;
            }
        }

        //要用且  栈为空 和 “”数量为偶数或者0
        if(stack.size()==0 && flag%2==0){
            return true;
        }
        return false;
    }
}
