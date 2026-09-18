class TimeMap {
    class Value {
        String val;
        int time;
        public Value(int time, String val) {
            this.time = time;
            this.val = val;
        }
    }
    Map<String, List<Value>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Value(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
       if (!map.containsKey(key)) {
            return "";
       }
       List<Value> list = map.get(key);
       int left = 0;
       int right = list.size() - 1;
       String res = "";

       while (left <= right) {
            int mid = left + (right - left)/2;
            Value entry = list.get(mid);
            if (entry.time == timestamp) {
                return entry.val;
            }

            if (entry.time <= timestamp) {
                res = entry.val;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
       }

       return res;

    }

}
