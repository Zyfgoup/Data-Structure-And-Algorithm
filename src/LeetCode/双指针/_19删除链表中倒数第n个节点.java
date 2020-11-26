package LeetCode.双指针;

import 链表.ListNode;

/**
 * @Author Zyfgoup
 * @Date 2020/11/26 13:32
 * @Description
 */
public class _19删除链表中倒数第n个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow,fast;
        slow=fast=head;

        while(n-->0){
            fast = fast.next;
        }
        //如果走到尾了  那么要删除的就是第一个节点
        if(fast==null){
            return head.next;
        }

        //走到最后一个节点 那么此时slow与fast 相差两个节点 所以要删的就是slow.next
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
