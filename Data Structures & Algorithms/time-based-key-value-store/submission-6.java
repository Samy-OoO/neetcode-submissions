class TimeMap {
    Map<String, List<Pair<Integer, String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>());
        timeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        List<Pair<Integer, String>> list = timeMap.get(key);
        if (list == null) return res;

        int l=0, r = list.size()-1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            Pair<Integer, String> pair = list.get(mid);
            int num = pair.getKey();

            if (num == timestamp) {
                res = pair.getValue();
                break;
            } else if (num < timestamp){
                res = pair.getValue();
                l = mid + 1;
            } else r = mid - 1;
        }

        return res;
    }

    class Pair<K,V>{
        final K time;
        final V val;

        Pair (K time, V val) {
            this.time = time;
            this.val = val;
        }

        public K getKey() {
            return this.time;
        }

        public V getValue() {
            return this.val;
        }
    }
}
