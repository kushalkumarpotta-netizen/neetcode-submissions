class Solution {
    public int lengthOfLongestSubstring(String s) {
        int MAX = 0;
        if(s == null)
        {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;

        while(right < s.length())
        {
            char c = s.charAt(right);
            if(set.contains(c))
            {
                set.remove(s.charAt(left));
                left++;
            }
            else if(!set.contains(c))
            {
                set.add(c);
                MAX = Math.max(MAX,right-left+1);
                right++;
            }
        }

        return MAX;
    }
}
