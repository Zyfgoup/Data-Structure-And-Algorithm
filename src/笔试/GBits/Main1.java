package 笔试.GBits;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Zyfgoup
 * @Date 2021/3/31 21:04
 * @Description
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        String[] strings = new String[n];
        for (int i=0;i<n;i++){
            strings[i] = cin.next();
        }

        String word1 = cin.next();
        String word2 = cin.next();
        System.out.println(m(strings,word1,word2));
    }


    public static  int m(String[] strings,String word1,String word2){
        if(strings.length==0){
            return 0;
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            if(strings[i].equals(word1)) {
                list1.add(i);
                continue;
            }
            if(strings[i].equals(word2)) {
                list2.add(i);
            }

        }

        int min = Integer.MAX_VALUE;

        //相同时 返回的是两个相同的之间的距离 不是0
        if(word1.equals(word2)){
            for (int i = 0; i < list1.size()-1; i++) {
                if(min>Math.abs(list1.get(i+1)-list1.get(i))){
                    min = Math.abs(list1.get(i+1)-list1.get(i));
                }
            }
            return min;
        }

        for (Integer i:list1) {
            for (Integer j:list2) {
                    int temp = Math.abs(i-j);
                    if(temp<min) {
                        min = temp;
                    }
            }
        }




        return min;


        }
}
