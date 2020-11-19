package 链表;

import List.MyList;

import java.awt.*;

/**
 * @Author Zyfgoup
 * @Date 2020/8/3 19:27
 * @Description 双向链表
 */
public class MyDoubleLinkedList<T> implements MyList<T> {
    //头尾都是哑元 为空
    ListNode first = new ListNode(null);
    ListNode last = new ListNode(null);
    int size;

    public MyDoubleLinkedList(){
        first.next = last;
        last.pre = first;
    }

    @Override
    public void add(T t) {
        //由于last也是哑元 所以插在last的上一个的后面
        ListNode newNode = new ListNode(t);

        //先将last的上一个的next指向新节点
        last.pre.next = newNode;
        //新节点的下一个指向last
        newNode.next = last;
        //新节点的上一个指向last的上一个
        newNode.pre = last.pre;
        //更新last的上一个为新节点
        last.pre = newNode;
        size++;

    }

    @Override
    public void delete(T t) {
        //因为first是哑元
        ListNode p = first.next;

        //是否等于last来判断是否到尾部了
        while(p!=last){
            //找到节点
            if(p.data.equals(t)){
                //删除节点
                //当前节点的前节点的next指向当前节点的下一个节点
                p.pre.next = p.next;
                //当前节点的下一个节点的pre指向当前节点的上一个节点
                p.next.pre = p.pre;

                size--;
                break;
            }

            p = p.next;
        }

    }

    @Override
    public void update(int index, T t) {
        ListNode p = first.next;
        int count = 0;
        while(p!=last){
            if(count == index){
                p.data = t;
            }
            p = p.next;
            count++;
        }
    }

    @Override
    public boolean contains(T t) {
        return false;
    }

    @Override
    public String toString() {
        ListNode p = first.next;
        StringBuilder sb = new StringBuilder();

        //不等于last来判断是否遍历完了
        while(p !=last){
            sb.append(p.data);
            if(p.next != last){
                sb.append(",");
            }

            p = p.next;
        }

        return sb.toString();

    }
}
