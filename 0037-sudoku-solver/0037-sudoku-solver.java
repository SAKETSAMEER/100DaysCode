class Solution {
    int rowmask[]=new int[9],
        colmask[]=new int[9],
        subox[][]=new int[3][3];
    char board[][];
    public void solveSudoku(char[][] board) {
        this.board=board;
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') continue;
                int num=board[i][j]-'0';
                colmask[j]|=(1<<num);
                rowmask[i]|=(1<<num);
                subox[i/3][j/3]|=(1<<num);
            }
        }
        recurse(0, 0);
    }
    private boolean recurse(int i, int j) {
        for(int r=i, c=j; r<9; r++, c=0) {
            for(; c<9; c++) {
                if(board[r][c]=='.') {
                    for(int k=1, mask=rowmask[r]|colmask[c]|subox[r/3][c/3]; k<=9; k++) {
                        if((mask&(1<<k))==0) {
                            board[r][c]=(char)(k+'0');
                            //change masks
                            int oldr=rowmask[r], oldc=colmask[c], subbox=subox[r/3][c/3];
                            rowmask[r]|=(1<<k);
                            colmask[c]|=(1<<k);
                            subox[r/3][c/3]|=(1<<k);
                            if(recurse(r, c)) return true;

                            //restore default masks
                            rowmask[r]=oldr; colmask[c]=oldc; subox[r/3][c/3]=subbox;
                        }
                    }
                    board[r][c]='.';
                    return false;
                }
            }
        }
        return true;
    }
}