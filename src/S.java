import java.util.HashSet;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Zyfgoup
 * @Date 2020/9/2 16:14
 * @Description
 */
public class S  {

   public synchronized void  func1() throws InterruptedException {

            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                Thread.sleep(100);
            }

    }

    public static void main(String[] args) {
        S e1 = new S();
        S e2 = new S();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()-> {
            try {
                e1.func1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(()-> {
            try {
                e2.func1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }
}
