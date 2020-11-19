package List;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Random;

/**
 * @Author Zyfgoup
 * @Date 2020/8/24 16:54
 * @Description 跳表 维护很多层的索引 每个值的晋级概率为0.5 晋级以后还可以有概率晋级 那就相当于每两个节点维护一个索引 每个节点都有前后和上下的指针
 * 每层链表的首尾都是空的
 *
 */
public class SkipList {
    private Node head,tail;

    //节点晋升索引的概率
    private static final double PROMOTE_RATE = 0.5;

    //层数
    private int maxLevel;


    public SkipList(){
        head = new Node(Integer.MAX_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
    }

    //输出每层
    public void printlnList() {
        Node head1 = head;
        int count = maxLevel;
        while (count >= 0) {
            Node p = head1;
            System.out.print("head->");
            while (p.right.data != Integer.MAX_VALUE) {
                System.out.print(p.right.data + "->");
                p = p.right;
            }
            System.out.print("tail");
            head1 = head1.down;
            System.out.println();
            count--;
        }
    }

    public void insert(int data){
        Node p = findNode(data);
        if(p.data==data){
            return;
        }
        Node node = new Node(data);
        appendNode(p,node);

        //维护索引
        int currentLevel = 0;

        //随机来判断是否晋级
        Random random = new Random();
        while(random.nextDouble() < PROMOTE_RATE){
            if(currentLevel == maxLevel){
                addLevel();
            }

            //要晋级索引 就要找到上一层的索引的前一个
            while(p.up==null){
                //往前找 直到找到有晋级索引的
                p = p.left;
            }

            //找到了
            p = p.up;

            //维护链表的指针
            Node upperNode = new Node(data);
            appendNode(p,upperNode);

            //维护上下指针
            upperNode.down = node;
            node.up = upperNode;

            //然后新的一层的当前节点 也有可能可以晋级
            node = upperNode;
            currentLevel++;
        }

    }

    private void addLevel() {
        maxLevel++;

        //维护一个新的头尾  一开始的头尾始终是最高层的
       Node p1 = new Node(Integer.MAX_VALUE);
        Node p2 = new Node(Integer.MAX_VALUE);
       p1.right = p2;
       p2.left = p1;

       p1.down = head;
       p2.down = tail;
       head.up = p1;
       tail.up = p2;

       head = p1;
       tail = p2;
    }

    /**
     *
     * @param data
     * @return
     */
    public boolean remove(int data){
        //先找到该节点
        Node p = search(data);
        //为空 表示链表没有这个节点
        if(p == null){
            System.out.println("没有该节点");
            return false;
        }

        //删除最底层后 也要删除索引
        int currentLevel = 0;
        while(p!=null){


            p.right.left = p.left;
            p.left.right = p.right;

            //不是最底层 且节点左右都是头尾了 那就把整层都删除了
            //可以发现每层的索引节点不是固定的 不一定越高层就越少节点 可能某一层节点反而更少
            if(currentLevel!=0 && p.left.data== Integer.MAX_VALUE && p.right.data ==Integer.MAX_VALUE){
                removeLevel(p.left);
            }else{
                //往上删除
                currentLevel++;
            }

            p = p.up;
        }

        return true;
    }

    private void removeLevel(Node leftNode) {
        Node rightNode = leftNode.right;

        //如果是最底层
        if(leftNode.up == null){
            leftNode.down.up = null;
            rightNode.down.up = null;
        }else {
            //不是最高层 就把当前层的上一层和当前层的下一层维护指针
            leftNode.up.down = leftNode.down;
            leftNode.down.up = leftNode.up;

            rightNode.up.down = rightNode.down;
            rightNode.down.up = rightNode.up;
        }

        maxLevel--;

    }

    //添加节点
    private void appendNode(Node p, Node node) {
        node.right = p.right;
        node.left = p;
        p.right.left = node;
        p.right = node;
    }


    public Node search(int data){
        Node p = findNode(data);
        if(p.data == data){
            System.out.println("找到节点："+data);
            return p;
        }else{
            System.out.println("未找到节点："+data);
            return null;
        }
    }


    //这个方法是找到该值的节点或者是最接近且小于该值第一个的节点
    public Node findNode(int data){
        Node p = head;

        while(true){

            //判断当前节点的下一个节点是不是尾部 和 值是否小于等于要找的 是就往右找 不是往下一层找
            while(p.right.data!=Integer.MAX_VALUE && p.right.data<=data){
                p = p.right;
            }
            //没有下一层了 说明找到了 或者没有这个
            if(p.down == null){
                break;
            }

            //往下一层
            p = p.down;
        }

        return p;
    }

    public static void main(String[] args) {
        SkipList list=new SkipList();
        list.insert(50);
        list.insert(15);
        list.insert(13);
        list.insert(20);
        list.insert(100);
        list.insert(75);
        list.insert(99);
        list.insert(76);
        list.insert(83);
        list.insert(65);
        list.printlnList();
    }


}
