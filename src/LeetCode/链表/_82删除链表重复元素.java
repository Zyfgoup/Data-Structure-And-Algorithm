package LeetCode.链表;

import 链表.ListNode;

/**
 * @Author Zyfgoup
 * @Date 2021/3/25 13:53
 * @Description
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
 * 只保留原始链表中 没有重复出现 的数字。
 *
 *
 * 注意思路 无非就是遍历一个个和递归  要么要原链表上  要么新链表  新链表就要有头作为空 然后有个tail控制移动
 * 主要 tail.next最后要指向null  不然可能带着原来的
 */
public class _82删除链表重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        //新的链表 为空
        ListNode dummy = new ListNode();

        //控制新链表的指针移动
        ListNode tail = dummy;

//遍历链表
        while(cur!=null){

            //没有重复的
            if(cur.next == null || cur.val != cur.next.val){
                tail.next = cur;
                tail = cur;
            }

            //相同原链表指针移动 注意 这里是有相同的都不要
            while(cur.next!=null && cur.val==cur.next.val){
                cur = cur.next;
            }
            //如果是上面循环出来的 表示当前节点与下一个值不相同 但是有过相同的不能要 也是移动
            //不管相不相同 指针都要移动
            cur = cur.next;

        }
        tail.next = null;

        return dummy.next;
    }
}
