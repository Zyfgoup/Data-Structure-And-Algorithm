package 笔试;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author Zyfgoup
 * @Date 2021/3/7 12:40
 * @Description
 */
public class _阶乘后几个0 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        BigDecimal value = new BigDecimal(s);
        String res = get(value).toString();
        int size = res.length();
        int count = 0;
        for(int i=size-1;i>=0;i--){
            char c = res.charAt(i);
            if(c == '0'){
                ++count;
            }else{
                break;
            }
        }
        System.out.println(count);




    }

    //栈溢出
    public static  BigDecimal get(BigDecimal value){
        if(value.compareTo(BigDecimal.ONE)==0) {
            return BigDecimal.ONE;
        }
        BigDecimal next = value.subtract(BigDecimal.ONE);
        return value.multiply(get(next));


    }

    //每有一个5
    public static int trailingZeros(long n) {
        int count=0;
        while (n>=5) {
            count+=n/5;
            n/=5;
        }
        return count;
    }


}
