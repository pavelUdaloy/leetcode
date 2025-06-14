import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class H_LFU_Cache_460 {
    //["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
    //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
    public void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }

    class LFUCache {
        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!keyToVal.containsKey(key))
                return -1;

            int freq = keyToFreq.get(key);
            freqToLRUKeys.get(freq).remove(key);
            if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
                freqToLRUKeys.remove(freq);
                ++minFreq;
            }

            putFreq(key, freq + 1);
            return keyToVal.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0)
                return;
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                get(key);
                return;
            }

            if (keyToVal.size() == capacity) {
                final int keyToEvict = freqToLRUKeys.get(minFreq).iterator().next();
                freqToLRUKeys.get(minFreq).remove(keyToEvict);
                keyToVal.remove(keyToEvict);
            }

            minFreq = 1;
            putFreq(key, minFreq);
            keyToVal.put(key, value);
        }

        private int capacity;
        private int minFreq = 0;
        private Map<Integer, Integer> keyToVal = new HashMap<>();
        private Map<Integer, Integer> keyToFreq = new HashMap<>();
        private Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys = new HashMap<>();

        private void putFreq(int key, int freq) {
            keyToFreq.put(key, freq);
            freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());
            freqToLRUKeys.get(freq).add(key);
        }

        public static class Pair<FIRST, SECOND> {
            public FIRST first;
            public SECOND second;

            public Pair(FIRST first, SECOND second) {
                this.first = first;
                this.second = second;
            }
        }
    }
}


