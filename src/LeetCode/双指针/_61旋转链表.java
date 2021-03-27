package LeetCode.双指针;

import 链表.ListNode;

/**
 * @Author Zyfgoup
 * @Date 2021/3/27 15:15
 * @Description
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 等于将链表后面k%len个节点放在前面  那就需要找到k+1节点 然后断开就可以了
 * 快慢指针 快指针先走k  然后快慢指针一起走 等快指针到尾时  慢指针即为k+1
 */
public class _61旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        //计算长度
        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            len++;
            cur = cur.next;
        }

        k = k%len;

        if(k==0){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(k>0){
            k--;
            fast = fast.next;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        //新的头
        ListNode newHead = slow.next;

        //断开
        slow.next = null;

        //后面接到第一个上
        fast.next = head;

        return newHead;

    }
}
