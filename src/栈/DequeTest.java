package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Zyfgoup
 * @Date 2021/3/24 22:38
 * @Description
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(10);
        stack.addLast(2);
        System.out.println(stack.toString());
        System.out.println(stack.peekLast());
        System.out.println(stack.removeLast());


    }
}
