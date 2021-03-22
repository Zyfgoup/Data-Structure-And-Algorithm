package 笔试;

import java.util.Scanner;

public class 是否同一星期几 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] arr = new int[n][6];

        for(int i=0;i<n;i++){
            for(int j=0;j<6;j++){
                arr[i][j] = cin.nextInt();
            }

            if(arr[i][0]<arr[i][3]){
                int sum1 = getDay(arr[i][0],arr[i][1],arr[i][2]);
                int sum2 = getDay(arr[i][3],arr[i][4],arr[i][5]);
                int sum3 = 0;
                for(int k=arr[i][0];k<arr[i][3];k++){
                    //计算 第一个年份到第二个年份之间的天数  所以月份为12  天 31
                    sum3 += getDay(k,12,31);
                }
                if((sum3+sum2-sum1)%7 == 0){
                    System.out.println("True");
                }else{
                    System.out.println("False");
                }
            }else if(arr[i][0]==arr[i][3]){
                int sum1 = getDay(arr[i][0],arr[i][1],arr[i][2]);
                int sum2 = getDay(arr[i][3],arr[i][4],arr[i][5]);
                if((Math.abs(sum1-sum2))%7 == 0){
                    System.out.println("True");
                }else{
                    System.out.println("False");
                }
            }else{
                int sum2 = getDay(arr[i][0],arr[i][1],arr[i][2]);
                int sum1 = getDay(arr[i][3],arr[i][4],arr[i][5]);
                int sum3 = 0;
                for(int k=arr[i][3];k<arr[i][0];k++){
                    //计算 第一个年份到第二个年份之间的天数  所以月份为12  天 31
                    sum3 += getDay(k,12,31);
                }
                if((sum3+sum2-sum1)%7 == 0){
                    System.out.println("True");
                }else{
                    System.out.println("False");
                }
            }

        }



    }


    public static int getDay(int y,int m,int d){
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;
        for(int i=0;i<m-1;i++){
            if(i==1 && isRun(y)){
                sum+=1;
            }
            sum+=months[i];
        }
        sum+=d;

        return sum;

    }

    public static  boolean isRun(int year){
        if((year%4==0 && year%100!=0) || year%400 == 0){
            return true;

        }
        return false;
    }
}