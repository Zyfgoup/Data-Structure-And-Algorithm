package LeetCode.双指针;

import 链表.ListNode;

/**
 * @Author Zyfgoup
 * @Date 2020/9/29 16:57
 * @Description
 */
public class 判断链表是否有环 {


    /**
     * 双指针 一个走一步 一个走两步  如果有环 则一定会重合
     * 关键就是一个while条件 是要判断如果没有环时  会退出循环 那么就是没有next了
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode l1 = head;
        ListNode l2 = head;

        while(l1!=null && l2!=null &&l2.next!=null){
            if(l1==l2){
                return true;
            }

            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
}
