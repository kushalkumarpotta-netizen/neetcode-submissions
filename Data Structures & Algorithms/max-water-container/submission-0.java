class Solution {
    public int maxArea(int[] heights) {
        int MAX = 0;

        int i = 0;
        int j = heights.length - 1;

        while(i < j)
        {
            int tempHeight = (j - i) * Math.min(heights[i],heights[j]);
            MAX = Math.max(tempHeight,MAX);
            
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return MAX;
    }
}
