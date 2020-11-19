package 链表;

import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/8/4 12:24
 * @Description
 */
public class 翻转链表 {

    public static void main(String[] args) {
        ListNode listNode1= new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3= new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

       ListNode result =  Reverse(listNode1);
        while(result!=null){
            System.out.println(result.data+",");
            result = result.next;
        }

    }


    public static  ListNode Reverse(ListNode l1){
        ListNode head = null;

        while(l1!=null){
            //先保存原链表的
            ListNode p = l1.next;

            //操作当前节点
            l1.next = head;
            head = l1;
            l1 = p;
        }
        return head;
    }
}
