import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Zyfgoup
 * @Date 2020/8/20 20:06
 * @Description  最近最少使用
 */
public class LRUCache {
    private int capasity = 0;
    private Map<Integer,Integer> map= new LinkedHashMap<>();

    public LRUCache(int i){
        this.capasity = i;
    }

    //默认为10
    public LRUCache(){
        this.capasity = 10;
    }

    public int get(int key){
        if(map.containsKey(key)){
            int temp = map.get(key);

            //使用了 remove 然后放到最新
            map.remove(key);
            map.put(key,temp);
            return temp;
        }
        return -1;

    }

    public void put(int key,int value){
        //不存在的情况要判断是否到了容量上限
        if(map.size()==capasity){
            Set<Integer> integers = map.keySet();
            for(Integer i:integers){
                map.remove(i);
                break;
            }
        }
        map.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println( cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

}
