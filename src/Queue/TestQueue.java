package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Zyfgoup
 * @Date 2020/9/1 0:02
 * @Description
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.remove());


    }
}
