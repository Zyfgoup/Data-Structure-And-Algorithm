package 链表;

import List.MyList;

import java.util.Map;

/**
 * @Author Zyfgoup
 * @Date 2020/8/3 13:11
 * @Description 实现链表
 */

public class MyLinkedList implements MyList<Object> {

    //头尾
    private ListNode first;
    private ListNode last;
    int size;


    @Override
    public void add(Object data) {
        //如果first 为空  first初始化  last指向first
        if(first == null){
            first = new ListNode(data);
            last = first;
        }else{
            //尾部的下一个指向新节点
            //然后更新尾部
            last.next = new ListNode(data);
            last = last.next;

        }

        size++;
    }

    @Override
    public void delete(Object o) {
        ListNode p  = first;
        ListNode pre = null;
        while(p!=null){
            if(p.data.equals(o)){

                //如果删除的是第一个节点 不能同pre
                if(p==first){
                    first  = first.next;
                }else {
                    pre.next = p.next;
                }


                size--;

                //如果删除了 直接break;
                break;
            }
            pre = p;
            p = p.next;
        }
    }

    @Override
    public void update(int index, Object o) {
            ListNode p = first;
            int count = 0;
            while(p!=null){
                if(count == index){
                    p.data = o;
                }
                p = p.next;
                count++;
            }

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public String toString() {
        ListNode p = first;
        StringBuilder sb = new StringBuilder();
        while(p !=null){
            sb.append(p.data);
            if(p.next != null){
                sb.append(",");
            }

            p = p.next;
        }

      return sb.toString();
    }
}
