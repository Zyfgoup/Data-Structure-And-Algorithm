package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Zyfgoup
 * @Date 2020/9/1 0:08
 * @Description
 *
 * Deque 用ArrayDeque实现类
 *
 * push是addFirst()
 *
 * poll是removeFirst()
 * 其实是栈
 *
 * 建议使用 addLast()+pollLast()  == 栈
 * addLast()+pollFirst == 队列
 */
public class TestDeque {
    public static void main(String[] args) {
       stack();
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
        Deque<Integer> queue = new ArrayDeque<>();
       queue.push(1);
       queue.push(2);
       queue.push(3);
        System.out.println(queue.toString());
        System.out.println(queue.pollLast());
        System.out.println(queue.peekLast());


    }
}
