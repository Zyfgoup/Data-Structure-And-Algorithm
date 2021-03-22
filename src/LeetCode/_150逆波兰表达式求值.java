package LeetCode;

import java.util.Stack;

/**
 * @Author Zyfgoup
 * @Date 2021/3/20 23:41
 * @Description
 */
public class _150逆波兰表达式求值 {

    public static void main(String[] args) {
        String[] s = {"4","13","5","/","+"};
        System.out.println(evalRPN(s));
    }

    public static  int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i] .equals("+")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                int v3 = v1 + v2;
                stack.push(v3);
            }
            else if(tokens[i] .equals("-")){
                int v1 = stack.pop();
                int v2 = stack.pop();
                int v3 = v2-v1;
                stack.push(v3);

            }else if(tokens[i] .equals("*") ){
                int v1 = stack.pop();
                int v2 = stack.pop();
                int v3 = v1 * v2;
                stack.push(v3);

            }
            else if(tokens[i] .equals("/") ){
                int v1 = stack.pop();
                int v2 = stack.pop();
                int v3 = v2/v1;
                stack.push(v3);

            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
            return stack.pop();

    }
}
