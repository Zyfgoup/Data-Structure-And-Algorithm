package LeetCode.双指针;

import 链表.ListNode;

/**
 * @Author Zyfgoup
 * @Date 2020/11/25 17:11
 * @Description
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

 */
public class _142环形链表2 {

    //快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head;

        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            //相遇 表示有环
            if(slow == fast){
                //从头开始走 和慢指针再继续走 相遇的点就是环开始的点
                ListNode temp = head;
                while(temp!=slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }



}
