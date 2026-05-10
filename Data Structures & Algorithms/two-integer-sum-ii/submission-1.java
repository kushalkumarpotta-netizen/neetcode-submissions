class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int i = 0;
        int j = len-1;
        int res[] = new int[2];

        while(i<j)
        {
            if(numbers[i]+numbers[j] < target)
            {
                i++;
            }
            else if(numbers[i]+numbers[j] > target)
            {
                j--;
            }
            else
            {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
        
    }
}
