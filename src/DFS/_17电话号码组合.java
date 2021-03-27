package DFS;

import java.util.*;

/**
 * @Author Zyfgoup
 * @Date 2021/3/26 21:17
 * @Description
 * 可以用StringBuilder代替很多的S的对象
 * 因为S+=就会创建一个新的
 * 但是要主要递归后要回溯 调用deleteCharAt(s.length()-1)方法
 */
public class _17电话号码组合 {

    public static void main(String[] args) {
        List<String> list =   letterCombinations("23");
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() ==0 ){
            return list;
        }

        //可以不用map  用数组也行
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder s = new StringBuilder();

        for(int i=0;i<map.get(digits.charAt(0)).length();i++){
            dfs(list,s,digits,0,i,map);
            s.deleteCharAt(s.length()-1);

        }
        return list;

    }

    /**
     * 其实等于遍历添加每一个数字对应的字符串的每一位
     * 所以需要遍历递归 因为遍历的是下一位数字对应的字符串的每一个字符 都是一种情况
     * 然后继续遍历下一个
     * 知道s的长度等于初始字符串的长度
     *
     *
     * @param list
     * @param s
     * @param digits
     * @param index
     * @param i
     * @param map
     */

    public static void dfs(List<String> list,StringBuilder s,String digits,int index,int i,Map<Character, String> map){
        s.append(map.get(digits.charAt(index)).charAt(i));

        if(s.length() == digits.length()) {
            list.add(s.toString());
            return;
        }

        //获取下一位数字对应的字符串
        String next = map.get(digits.charAt(index + 1));

        //遍历它的每一位  然后每一位里又递归下一个数的字符串的每一位
        for(int j=0;j<next.length();j++){
            dfs(list,s,digits,index+1,j,map);
        }

    }
}
