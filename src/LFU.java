import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 最不经常使用
 * @param <k>
 * @param <v>
 */

public class LFU<k, v> {
  private final int capcity;

  //一个记录key value

  //一个记录key 和对应的key的使用次数 和时间

  private Map<k, v> cache = new HashMap<>();

  private Map<k, HitRate> count = new HashMap<>();

  public LFU(int capcity) {
    this.capcity = capcity;
  }

  public void put(k key, v value) {
    v v = cache.get(key);
    if (v == null) {
      if (cache.size() == capcity) {
        removeElement();
      }
      count.put(key, new HitRate(key, 1, System.nanoTime()));
    } else {
      addHitCount(key);
    }
    cache.put(key, value);
  }

  public v get(k key) {
    v value = cache.get(key);
    if (value != null) {
      addHitCount(key);
      return value;
    }
    return null;
  }

  //移除元素
  private void removeElement() {

    //返回最小的 然后移除
    HitRate hr = Collections.min(count.values());
    cache.remove(hr.key);
    count.remove(hr.key);
  }

  //更新访问元素状态
  private void addHitCount(k key) {
    HitRate hitRate = count.get(key);
    hitRate.hitCount = hitRate.hitCount + 1;
    hitRate.lastTime = System.currentTimeMillis();
  }

  //内部类
  class HitRate implements Comparable<HitRate> {
    private k key;
    private int hitCount;
    private long lastTime;

    private HitRate(k key, int hitCount, long lastTime) {
      this.key = key;
      this.hitCount = hitCount;
      this.lastTime = lastTime;
    }

    @Override
    public int compareTo(HitRate o) {
      int compare = Integer.compare(this.hitCount, o.hitCount);
      return compare == 0 ? Long.compare(this.lastTime, o.lastTime) : compare;
    }
  }
}