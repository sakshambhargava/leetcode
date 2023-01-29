class LFUCache {
    HashMap<Integer, CacheTuple> cache;
    TreeMap<CacheTuple, Integer> freqMap;
    int stamp;
    int capacity;
    
    class CacheTuple implements Comparable<CacheTuple> {
        int frequency;
        int value;
        int stamp;
        
        public CacheTuple(int frequency, int value, int stamp) {
            this.frequency = frequency;
            this.value = value;
            this.stamp = stamp;
        }
        
        public int compareTo(CacheTuple that) {
            if (this.frequency == that.frequency) {
                return this.stamp - that.stamp;
            }
            return this.frequency - that.frequency;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new TreeMap<>();
        this.stamp = 0;
    }
    
    public int get(int key) {
        if (capacity <= 0) {
            return -1;
        }
        if (!cache.containsKey(key)) {
            return -1;
        }
        CacheTuple tuple = cache.get(key);
        CacheTuple newTuple = new CacheTuple(tuple.frequency + 1, tuple.value, ++stamp);
        freqMap.remove(tuple);
        cache.put(key, newTuple);
        freqMap.put(newTuple, key);
        return tuple.value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (cache.containsKey(key)) {
            CacheTuple tuple = cache.get(key);
            CacheTuple newTuple = new CacheTuple(tuple.frequency + 1, value, ++stamp);
            freqMap.remove(tuple);
            cache.put(key, newTuple);
            freqMap.put(newTuple, key);
        } else {
            if (freqMap.size() >= capacity) {
                int oldKey = freqMap.pollFirstEntry().getValue();
                cache.remove(oldKey);
            }
            CacheTuple newTuple = new CacheTuple(1, value, ++stamp);
            cache.put(key, newTuple);
            freqMap.put(newTuple, key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
