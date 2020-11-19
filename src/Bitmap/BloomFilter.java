package Bitmap;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Author Zyfgoup
 * @Date 2020/8/30 18:42
 * @Description 简化版布隆过滤器
 *
 */
public class BloomFilter {
    public static final int NUM_SLOTS = 1024*1024*8; //位图长度
    public static final int NUM_HASH = 8 ;// 8个哈希函数

    private BigInteger bitmap = new BigInteger("0");//位图


    public void add(String value){
        for(int i=0;i<NUM_HASH;i++){
            //根据传入参数不同来模拟不同的哈希函数
            int hashcode = getHash(value,i);
            //testBit() 判断某一位上面是否为1
            if(!bitmap.testBit(hashcode)){
                //不为1 标注
                //bitmap与1左移求出的hashcode位  做 或操作  有1为1  这样1都保留下来
                bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
            }
        }

    }

    private int getHash(String value, int i) {
        value = value+i;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] bytes = value.getBytes();
            md5.update(bytes);
            BigInteger bigInteger = new BigInteger(md5.digest());
            //取余
            return Math.abs(bigInteger.intValue())%NUM_SLOTS;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //判断每个哈希函数求出的值对应的下标是否为1
    public boolean check(String message){
        for(int i=0;i<NUM_HASH;i++){
            int hashcode = getHash(message,i);
            //有一个不为1  不存在
            if(!bitmap.testBit(hashcode)){
                return false;
            }
        }

        //不一定存在 哈希冲突的问题 但是哈希函数很多 都冲突的概率很小
        return true;


    }

    public static void main(String[] args){
        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.add("zyfgoup111.com");
        bloomFilter.add("asdas21.com");
        System.out.println(bloomFilter.check("zyfgoup111.com"));
        System.out.println(bloomFilter.check("asdas1231.com"));



    }



}
