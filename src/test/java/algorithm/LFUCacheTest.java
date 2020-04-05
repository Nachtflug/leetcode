package algorithm;

public class LFUCacheTest {

    public static void main(String[] args) {
        LFUCache cache2 = new LFUCache( 1 /* capacity (缓存容量) */ );

        cache2.put(2, 2);
        cache2.put(1, 1);
        System.out.println(cache2.get(2));       // 返回 2
        System.out.println(cache2.get(1));       // 返回 1
        System.out.println(cache2.get(2));       // 返回 2
        cache2.put(3, 3);    //
        cache2.put(4, 4);    //
        System.out.println(cache2.get(3));       // 返回 -1
        System.out.println(cache2.get(2));       // 返回 2
        System.out.println(cache2.get(1));       // 返回 1
        System.out.println(cache2.get(4));       // 返回 4



        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4



    }

}
