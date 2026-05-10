class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
        {
            return "";
        }

        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> have = new HashMap<>();

        for(char c: t.toCharArray())
        {
            need.put(c, need.getOrDefault(c,0) + 1);
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        int haveCount = 0;
        int needCount = need.size();

        for(int right = 0;right < s.length(); right++)
        {
            char c = s.charAt(right);

            have.put(c,have.getOrDefault(c,0) + 1);

            if(need.containsKey(c) && need.get(c).intValue() == have.get(c).intValue())
            {
                haveCount++;
            }

            while(haveCount == needCount)
            {
                if((right-left+1) < minLen)
                {
                    start = left;
                    minLen = right - left + 1;
                }

                char leftChar = s.charAt(left);
                have.put(leftChar,have.get(leftChar) - 1);

                if(need.containsKey(leftChar) && have.get(leftChar) < need.get(leftChar))
                {
                    haveCount--;
                }

                left++;
            }
        }
        return minLen == Integer.MAX_VALUE
            ? ""
            : s.substring(start, start + minLen);
    }
}
