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
        String res = "";  
        if (!map.containsKey(key)) {
            return res;
        }
        List<Value> values = map.get(key);
        int l = 0;
        int r = values.size() - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            
            if (timestamp == values.get(m).time) {
                return values.get(m).val;
            } else if (timestamp < values.get(m).time) {
                r = m - 1;
            } else {
                res = values.get(m).val;
                l = m + 1;
            }

        }
        return res;
    }

}
