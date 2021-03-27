package 笔试.奇安信;


import java.util.*;

/**
 * @Author Zyfgoup
 * @Date 2021/3/24 15:40
 * @Description
 */
public class Demo1 {

    public static void main(String[] args) {
        Scanner cin= new Scanner(System.in);
        int money = cin.nextInt();
        int n = cin.nextInt();
        List<Goods> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            Goods goods = new Goods();
            goods.maxNum = cin.nextInt();
            list.add(goods);
        }
        for(int i=0;i<n;i++){
            list.get(i).value = cin.nextInt();
        }
        for(int i=0;i<n;i++){
           list.get(i).tenValue = cin.nextInt();
        }

        Collections.sort(list);

        for (Goods goods : list) {
            System.out.println(goods.maxNum+","+goods.value+","+goods.tenValue);
        }

        int count = 0;
        for(int i=0;i<list.size();i++){
            Goods goods = list.get(i);
            if(money>=goods.value && goods.tenValue>goods.value){
                int num = goods.maxNum>money/goods.value?money/goods.value : goods.maxNum;
                count += num*goods.tenValue;
                money -= num*goods.value;
            }
        }
        System.out.println(count+money);

    }
}


class Goods implements Comparable{
    int maxNum;
    int value;
    int tenValue;

    //降序
    @Override
    public int compareTo(Object o) {
        Goods obj = (Goods) o;
        int i = (obj.tenValue-obj.value+obj.maxNum)-(this.tenValue-this.value+this.maxNum)+(obj.value-this.value);
        return i;
    }
}
