package LeetCode.双指针;

import 链表.ListNode;

/**
 * @Author Zyfgoup
 * @Date 2020/11/26 11:06
 * @Description
 * 快指针一次前进两步，慢指针一次前进一步，当快指针到达链表尽头时，慢指针就处于链表的中间位置。
 * 当链表的长度是奇数时，slow恰巧停在中点位置；如果长度是偶数，slow最终的位置是中间偏右：
 *
 *
 * 寻找链表中点的一个重要作用是对链表进行归并排序。
 * 回想数组的归并排序：求中点索引递归地把数组二分，最后合并两个有序数组。对于链表，合并两个有序链表是很简单的，难点就在于二分。
 *
 */



public class _876寻找链表的中点 {
    public ListNode middleNode(ListNode head) {
        if(head.next==null || head==null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
