package 链表;

/**
 * @Author Zyfgoup
 * @Date 2020/8/3 19:24
 * @Description
 */
public class TestLinkedList {
    public static void main(String[] args) {
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.add("1");
//        myLinkedList.add("zyf");
//        myLinkedList.add("zzf");
//        myLinkedList.add("2");
//        System.out.println(myLinkedList.toString());
//
//        myLinkedList.delete("2");
//        myLinkedList.update(2,1111);
//        System.out.println(myLinkedList.toString());

        testDoubleLinkedList();
    }


    public static void testDoubleLinkedList(){

        MyDoubleLinkedList<Object> myDoubleLinkedList = new MyDoubleLinkedList<>();

        myDoubleLinkedList.add(1);
        myDoubleLinkedList.add(2);
        myDoubleLinkedList.add(3);
        myDoubleLinkedList.add(4);
        System.out.println(myDoubleLinkedList.toString());

        myDoubleLinkedList.delete(5);
        myDoubleLinkedList.update(2,1111);
        System.out.println(myDoubleLinkedList.toString());


    }
}
