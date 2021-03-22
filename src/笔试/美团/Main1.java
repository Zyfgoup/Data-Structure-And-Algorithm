package 笔试.美团;

import java.util.Scanner;

/**
 * @Author Zyfgoup
 * @Date 2021/3/20 16:32
 * @Description abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmn
 *
 * opqrstuvwxyz
 * meituan
 *
 * 59
 */
public class Main1 {



    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String n = cin.nextLine();
        String a = cin.nextLine();
        String s = n;
        int count =0;
        for(int i=0;i<a.length();i++){
            int i1 = s.indexOf(a.charAt(i));

            if(i1>-1){
                count+=i1+1;
               s=s.substring(i1+1);
            }else{
                s += n;
            }

        }

        System.out.println(count-a.length());
    }

}
