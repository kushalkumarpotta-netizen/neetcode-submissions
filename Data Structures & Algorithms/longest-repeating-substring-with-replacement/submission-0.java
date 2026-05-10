class Solution {
    public int characterReplacement(String s, int k) {
        int MAX = 0;
        if(s == null)
        {
            return 0;
        }

        int left = 0;
        int right = 0;
        int maxFreq = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        
        while(right<s.length())
        {
            char c = s.charAt(right);
            if(map.containsKey(c))
            {
                map.put(c,map.get(c) + 1);
            }
            else
            {
                map.put(c,1);
            }

            maxFreq = Math.max(maxFreq,map.get(c));

            while((right - left + 1) - maxFreq > k)
            {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            MAX = Math.max(MAX,right - left + 1);

            right++;
        }

        return MAX;
    }
}
