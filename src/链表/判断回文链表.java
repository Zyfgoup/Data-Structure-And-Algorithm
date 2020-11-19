package 链表;

import java.util.Stack;

/**
 * @Author Zyfgoup
 * @Date 2020/8/4 12:44
 * @Description
 *
 * 长度为奇偶两种情况
 * 用栈解决  前半部分入栈 然后出栈与链表后半比较  需要先遍历获得链表长度  然后length/2入栈
 *
 * 快慢指针 慢的走一步 快的走两步  如果快指针不能再走时 此时慢指针指向的时 中间位置
 * 然后将slow.next开始到尾进行翻转链表
 *
 * 主要是注意奇数偶数的情况 实际上不需要注意 因为都是翻转slow.next
 * 但是要清楚 奇数时不比较中间那个值
 * 偶数时则对半分
 *
 * a b b c b b a
 * a b c d d c b a
 *
 * 中间部分不比较 例如c或者d d
 *
 */
public class 判断回文链表 {
    public static boolean isPalindrome(ListNode head) {



        return method2(head);
    }

    private static boolean method2(ListNode head) {
        if(head==null) return true;

        ListNode p = head;
        ListNode slow = head;
        ListNode fast = head;

        //出循环后
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }


        //传入slow的next
        ListNode secondNode = reverse(slow.next);



        //要以翻转后的链表作为条件 因为原链表长度比较长
        while(secondNode!=null){
            if(!p.data.equals(secondNode.data)){
                return false;
            }
            p = p.next;
            secondNode = secondNode.next;
        }

        return true;


    }


    //栈
    private static boolean method1(ListNode head) {
        ListNode p = head;

        int size = 0;
        while(p!=null){
            size++;
            p = p.next;
        }

        Stack<Object> stack = new Stack<>();
        for(int i=0;i<size/2;i++){
            stack.push(head.data);
            head = head.next;
        }
        //不是偶数 指针再移动一位 不比较中间的
        if(size%2!=0){
            head = head.next;
        }

        while(head!=null){
            if(!head.data.equals(stack.pop())){

                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode1= new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3= new ListNode(3);
        ListNode listNode5= new ListNode(4);
        ListNode listNode6 = new ListNode(2);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode6;

        System.out.println(isPalindrome(listNode1));
    }

    public static  ListNode reverse(ListNode l1){
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
