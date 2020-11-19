package List;

/**
 * @Author Zyfgoup
 * @Date 2020/8/24 17:08
 * @Description
 */
public class Node {
    public int data;
    //跳表结点的前后和上下都有指针
    public Node up, down, left, right;

    public Node(int data) {
        this.data = data;
    }
}
