package 笔试.GBits;

import java.util.Scanner;

public class Main{
    
   public static void main(String[] args){
       Scanner cin = new Scanner(System.in);
       int n = cin.nextInt();
       int sum1 = 0;
       int sum2 = 0;
       for(int i=0;i<n;i++){
           if((i+1)%2!=0){
               sum1+=cin.nextInt();
           }
           if(i%2!=0){
               sum2+=cin.nextInt();
           }
       }
       
       System.out.println(Math.abs(sum1-sum2));
       
       
   } 
    
}