class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null)
        {
            return false;
        }  
        if(s1.length() > s2.length())
        {
            return false;
        }

        int left = 0;
        int right = s1.length() - 1;

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i = 0;i<s1.length();i++)
        {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }


        while(right<s2.length())
        {
            if(Arrays.equals(freq1,freq2))
            {
                return true;
            }

            right++;
            if (right < s2.length()) {
                freq2[s2.charAt(right) - 'a']++;
            }

            freq2[s2.charAt(left) - 'a']--;
            left++;
        }
        return false;
    }
}
