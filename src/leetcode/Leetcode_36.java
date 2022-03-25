package leetcode;

public class Leetcode_36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] line = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] box = new int[3][3][9];

        // 遍历整个数组，上面三个数组每个格子分别对应字符的出现次数。如果出现次数>1就代表 不是数独
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.') {
                    int index = board[i][j] - '0' - 1;
                    line[i][index]++;
                    column[index][j]++;
                    box[i / 3][j / 3][index]++;

                    if (line[i][index] > 1 || column[j][index] > 1 || box[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
