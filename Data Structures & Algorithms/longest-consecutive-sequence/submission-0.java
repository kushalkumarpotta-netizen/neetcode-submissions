class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> lc = new HashSet<>();
        int max = 0;

        for(int n:nums)
        {
            lc.add(n);
        }

        for(int n:lc)
        {
            if(!lc.contains(n-1))
            {
                int length = 1;
                while(lc.contains(n+1))
                {
                    length++;
                    n++;
                }
                max = Math.max(length,max);
            }
        }
        return max;
    }
}
