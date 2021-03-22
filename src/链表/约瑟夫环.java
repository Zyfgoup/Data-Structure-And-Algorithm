package 链表;

import java.util.Scanner;

/**
 * @Author Zyfgoup
 * @Date 2021/3/13 16:28
 * @Description
 */
public class 约瑟夫环 {
        public static void main(String[] args){
            Scanner cin = new Scanner(System.in);
            int n = cin.nextInt();
            System.out.println(m1(n));
        }
        public static int m1(int n){
            if(n==1){
                return 1;
            }
            Node head = new Node(1);
            Node cur = head;

            for(int i=2;i<=n;i++){
                Node node = new Node(i);
                cur.next = node;
                cur = node;
            }

            cur.next = head;

            cur = head;
            Node pre = null;

            int i=1;

            //不指向同一个
            while(cur!=pre){

                //一直加 取模
                if(i%3==0){

                    //上一个的next指向当前的next
                    //然后指针移动
                    cur = cur.next;
                    pre.next = cur;
                }else{

                    //指针移动
                    pre = cur;
                    cur = cur.next;
                }
                ++i;
            }

            return cur.value;


        }
    }

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }


}
