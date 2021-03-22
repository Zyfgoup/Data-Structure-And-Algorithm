package 笔试;

import java.util.*;

/**
 * @Author Zyfgoup
 * @Date 2021/3/18 19:45
 * @Description
 *
 * 5
 * 30 20 40 50 91
 * 1 2 1 2 3
 * 2 1 3 2 1
 * 6
 * 2 3 1 2 1 1
 */
public class 物品属性 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Good> list = new ArrayList<>();
        for(int i=0;i<n;i++){
           Good good = new Good();
            good.value = sc.nextInt();
            list.add(good);
        }
        for(int i=0;i<n;i++){

           list.get(i).i1  = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            list.get(i).i2  = sc.nextInt();
        }

        int perNum = sc.nextInt();
        int[] pers = new int[perNum];
        for(int i=0;i<perNum;i++){
            pers[i] = sc.nextInt();
        }

       Collections.sort(list);

        int[] res = new int[perNum];

        for(int i=0;i<perNum;i++){
            Iterator<Good> iterator = list.iterator();
            while(iterator.hasNext()){
                Good good = iterator.next();
                if(pers[i] == good.i1 || pers[i] == good.i2){
                    res[i] = good.value;
                    iterator.remove();
                    break;
                }
            }
        }

        for(int i=0;i<res.length-1;i++){
            if(res[i] == 0){
                res[i] = -1;
            }
            System.out.print(res[i]+" ");
        }

        if(res[res.length-1] == 0)
            res[res.length-1] = -1;

        System.out.print(res[res.length-1]);


    }

}

class Good implements Comparable{
    Integer value;
    Integer i1;
    Integer i2;

    @Override
    public int compareTo(Object good){
        return this.value.compareTo(((Good)good).value);
    }


}
