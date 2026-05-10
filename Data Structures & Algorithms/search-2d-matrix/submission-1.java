class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while(left<=right)
        {
            int mid = (left + right)/2;

            //finding mid element
            int row = mid/n;
            int col = mid%n;

            //mid val
            int val = matrix[row][col];

            if(val > target)
            {
                right = mid - 1;
            }
            else if(val < target)
            {
                left = mid + 1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
