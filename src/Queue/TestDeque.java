package Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Zyfgoup
 * @Date 2020/9/1 0:08
 * @Description
 */
public class TestDeque {
    public static void main(String[] args) {
       queue();
    }


    public static void stack(){
        Deque<Integer> stack = new LinkedList<>();
        stack.offerFirst(1);
        stack.offerFirst(2);
        stack.offerFirst(3);
        stack.offerFirst(4);
        System.out.println(stack.peekFirst());
        System.out.println(stack.pollFirst());
        System.out.println(stack.toString());
    }

    public static void queue(){
        Deque<Integer> queue = new LinkedList<>();
        queue.offerFirst(1);
        queue.offerFirst(2);
        queue.offerFirst(3);
        queue.offerFirst(4);
        queue.offerFirst(5);
        System.out.println(queue.toString());
        System.out.println(queue.pollLast());
        System.out.println(queue.peekLast());


    }
}
