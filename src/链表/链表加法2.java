package 链表;

import java.util.Stack;

/**
 * @Author Zyfgoup
 * @Date 2020/8/4 10:56
 * @Description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 顺序的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：8 -> 0 -> 7
原因：243 + 564 = 807

(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
 */
public class 链表加法2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;

        //长度可能不一样 所以要倒序加 利用栈
        Stack<Object> stack1 = new Stack<>();
        Stack<Object> stack2 = new Stack<>();


        while(l1!=null){
            stack1.push(l1.data);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2.data);
            l2 = l2.next;
        }

        int value = 0;
       while(!stack1.empty()||!stack2.empty()||value>0){
           int sum = value;
           sum += stack1.isEmpty()? 0: (int)stack1.pop();
           sum += stack2.isEmpty()? 0: (int)stack2.pop();
           ListNode node = new ListNode(sum % 10);

           //头插法
           node.next = head;
           head = node;

           value = sum / 10;

       }
       return head;
    }


    public static void main(String[] args) {
        ListNode listNode1= new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3= new ListNode(3);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5= new ListNode(6);
        ListNode listNode6 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode result = addTwoNumbers(listNode1,listNode4);
        while(result!=null){
            System.out.println(result.data+",");
            result = result.next;
        }
    }
}
