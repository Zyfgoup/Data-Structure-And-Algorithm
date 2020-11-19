package 链表;

/**
 * @Author Zyfgoup
 * @Date 2020/8/4 12:42
 * @Description  第一位为个位
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class 链表加法 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return method1(l1,l2,0);
    }


    //递归
    private ListNode method1(ListNode l1, ListNode l2, int i) {

        //边界 两个链表都到了尾部并且进位也为0时
        if(l1==null&&l2==null&&i==0) {
            return null;
        }

        int value = i;
        value += l1==null?0:(int)l1.data;
        value += l2==null?0:(int)l2.data;

        ListNode newNode = new ListNode(value%10);
        newNode.next = method1(l1==null?null:l1.next,l2==null?null:l2.next,value>=10?1:0);
        return newNode;
    }
}
