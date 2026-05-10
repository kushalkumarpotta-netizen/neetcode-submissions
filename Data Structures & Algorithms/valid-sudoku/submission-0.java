class Solution {
    public boolean isValidSudoku(char[][] board) {

        int r = board.length;
        int c = board[0].length;

        for(int i=0;i<r;i++)
        {
            HashSet<Character> row = new HashSet<>();
            for(int j=0;j<c;j++)
            {
                if(board[i][j] == '.') continue;

                if(row.contains(board[i][j]))
                {
                    return false;
                }
                row.add(board[i][j]);
            }
        }

        for(int j=0;j<c;j++)
        {
            HashSet<Character> col = new HashSet<>();
            for(int i=0;i<r;i++)
            {
                if(board[i][j] == '.') continue;

                if(col.contains(board[i][j]))
                {
                    return false;
                }
                col.add(board[i][j]);
            }
        }

        for(int i=0;i<r;i+=3)
        {
            for(int j=0;j<c;j+=3)
            {
                HashSet<Character> smlBox = new HashSet<>();
                for(int k=i;k<i+3;k++)
                {
                    for(int l=j;l<j+3;l++)
                    {
                        if(board[k][l] == '.')
                        {
                            continue;
                        }

                        if(smlBox.contains(board[k][l]))
                        {
                            return false;
                        }

                        smlBox.add(board[k][l]);
                    }
                }
            }
        }

        return true;
    }
}
