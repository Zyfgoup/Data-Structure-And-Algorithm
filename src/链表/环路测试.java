package 链表;

import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/8/4 0:29
 * @Description 快慢指针
 */
public class 环路测试 {

    public static ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;


//slow走一步  fast走两步 如果存在环则必定slow和fast会重合
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if (s == f) {
                break;
            }
        }

        //如果是空或者一个节点 或者不是环 返回null
        if(f == null || f.next == null) {
            return null;
        }

        while(head!=s){
            head = head.next;
            s = s.next;
        }
        return s;


    }

    public static void main(String[] args) {
        ListNode listNode1= new ListNode("1");
        ListNode listNode2= new ListNode("2");
        ListNode listNode3= new ListNode("3");
        ListNode listNode4= new ListNode("4");
        ListNode listNode5= new ListNode("5");

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode2;

        System.out.println(detectCycle(listNode1).data);



    }
}
