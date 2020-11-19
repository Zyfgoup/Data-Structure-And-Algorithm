package List;

/**
 * @Author Zyfgoup
 * @Date 2020/8/3 13:14
 * @Description
 */
public interface MyList<T> {

    void add(T t);
    void delete(T t);
    void update(int index,T t);
    boolean contains(T t);

}
