package 笔试;

/**
 * @Author Zyfgoup
 * @Date 2021/3/16 11:52
 * @Description
 */
public class Demo {
    public static void main(String[] args) {
        String s1 = "1.2.1";
        String s2 = "1.10.2";
        String[] strings = m1(s1, s2);
        String res = "";
        for (String s:strings){
            res+=s+'.';
        }
        System.out.println(res.substring(0,res.length()-1));

    }

    public static String[] m1(String s1,String s2){
       String[] ss1 = s1.split(".");
       String[] ss2 = s2.split(".");

       int len =ss1.length>ss2.length? ss1.length:ss2.length;

       for(int i=0;i<len;i++){
           if(len>ss1.length){
               return ss2;
           }
           if(len>ss2.length){
               return ss1;
           }
           if(ss1[i].compareTo(ss2[i])>1){
               return ss1;
           }else if(ss1[i].compareTo(ss2[i])<-1){
               return ss2;
           }
       }

       return null;

    }

}
