package 笔试.奇安信;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2021/3/24 16:26
 * @Description
 */
public class Demo2 {

    public static void main(String[] args) {
        int[][] arr = {{8,9},{9,10},{9,12},{14,16},{15,16}};
        System.out.println(AttendMeetings(arr));
    }

    public static  int AttendMeetings (int[][] times) {
        List<Time> list = new ArrayList<>();
       for(int i=0;i<times.length;i++){
           Time time = new Time();
           time.start = times[i][0];
           time.end = times[i][1];
           list.add(time);
       }

        Collections.sort(list);

       int count = 1;
       int end = list.get(0).end;
        for(int i=1;i<list.size();i++){
            Time time = list.get(i);
            if(time.start>=end){
                count++;
                end = time.end;
            }
        }
        return count;
    }
}

class Time implements Comparable{
    int start;
    int end;


    @Override
    public int compareTo(Object o) {
        int i =  this.end-((Time)o).end;
        if(i ==0 ){
            return this.start-((Time)o).start;
        }
        return i;
    }
}
