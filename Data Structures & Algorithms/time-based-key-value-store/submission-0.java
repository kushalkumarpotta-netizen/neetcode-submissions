class TimeMap {

    private HashMap<String, List<Pair<Integer,String>>> map;

    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
        {
            return "";
        }

        List<Pair<Integer,String>> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;
        String res = "";

        while(left <= right)
        {
            int mid = (left + right)/2;

            if(list.get(mid).getKey() <= timestamp)
            {
                res = list.get(mid).getValue();
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return res;
    }
}
