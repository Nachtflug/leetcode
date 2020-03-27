package algorithm;

/**
 * 999. 车的可用捕获量
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 */
public class NumRookCaptures {

    public static int numRookCaptures(char[][] board) {

        int caps = 0;

        DONE:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    for (int direction = 0; direction < 4; direction++) {
                        if (meetsPawn(i, j, direction, board))
                            caps ++;
                    }
                    break DONE;
                }
            }
        }

        return caps;
    }

    private static boolean meetsPawn(int i, int j, int direction, char[][] board) {
        int width = board[i].length;
        while (direction == 0 ? --i > 0 :
               direction == 1 ? ++i < board.length :
               direction == 2 ? --j > 0 :
                                ++j < width) {

            if (board[i][j] == 'B')
                return false;
            if (board[i][j] == 'p')
                return true;
        }
        return false;
    }

}
