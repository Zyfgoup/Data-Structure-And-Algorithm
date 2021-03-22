package 笔试;

import java.util.Scanner;

/**
 * @Author Zyfgoup
 * @Date 2021/3/13 15:00
 * @Description
 */
public class 自由落体球 {



        public static void main(String[] args){
            Scanner cin = new Scanner(System.in);
            double n = cin.nextDouble();
            m1(n);
        }

        public static void  m1(double n){
            double init =100;
            double sum = 0;
            while(n-->0){
                if(n==0){
                    sum+=init;
                    init*=0.5;
                    break;
                }
                sum+=init;
                init*=0.5;
                sum+=init;

            }
            System.out.printf("%.6f",sum);
            System.out.print(" ");
            System.out.printf("%.6f",init);


        }
}

