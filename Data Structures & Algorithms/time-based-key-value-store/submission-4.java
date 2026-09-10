class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<>());

        int l = 0, r = list.size()-1;
        int mid, num;
        Pair<Integer, String> pair;

        while (l <= r) {
            mid = l + (r-l)/2;
            pair = list.get(mid);
            num = pair.getKey();

            if (num <= timestamp){
                l = mid + 1;
                res = pair.getValue();
            }
            else r = mid - 1;
        }
        return res;
    }


    private static class Pair<K, V>{

        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public V getValue(){
            return value;
        }

        public K getKey(){
            return key;
        }
    }

}
