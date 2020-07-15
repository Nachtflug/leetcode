package algorithm;

import java.util.*;

/**
 * 37. 解数独难度困难469编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SudokuSolver {

    private Distincter[] srow = new Distincter[9];
    private Distincter[] scol = new Distincter[9];
    private Distincter[] sarea = new Distincter[9];
    {
        for (int i = 0; i < 9; i++) {
            srow[i] = new Distincter();
            scol[i] = new Distincter();
            sarea[i] = new Distincter();
        }
    }
    
    public void solveSudoku(char[][] board) {
        LinkedList<BoxHolder> toFill = new LinkedList<>();
        init(board, toFill);
        dfs(board, toFill, new LinkedList<>(), new LinkedList<>());
    }

    private void init(char[][] board, LinkedList<BoxHolder> toFill) {
        List<int[]> filled = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    BoxHolder box = new BoxHolder(new int[]{i, j});
                    box.subscribe(srow[i], scol[j], sarea[getAreaIdx(i, j)]);
                    toFill.add(box);
                } else {
                    int n = board[i][j] - '0';
                    filled.add(new int[]{i, j, n});
                }
            }
        }
        for (int[] ints : filled) {
            int i = ints[0], j = ints[1], a = ints[2];
            srow[i].notify(a);
            scol[j].notify(a);
            sarea[getAreaIdx(i, j)].notify(a);
        }
    }


    private boolean dfs(char[][] board, LinkedList<BoxHolder> toFill, LinkedList<Object[]> moves, LinkedList<Integer> savePoints) {
        if (toFill.isEmpty())
            return true;
        toFill.sort(Comparator.comparingInt(BoxHolder::rank));
        boolean moved = false;
        BoxHolder item;
        while (true) {
            item = toFill.peekFirst();
            if (item == null)
                return true;
            if (item.rank() == 1) {
                toFill.poll();
                Integer a = item.getPossibleOne();
                move(board, moves, item, a);
                moved = true;
            } else
                break;
        }
        if (moved)
            return dfs(board, toFill, moves, savePoints);

        List<Integer> possibles = item.getPossibles();
        for (Integer availableInt : possibles) {
            toFill.poll();
            savePoints.push(moves.size());
            if (move(board, moves, item, availableInt) &&
                    dfs(board, toFill, moves, savePoints)) {
                return true;
            }

            Integer point = savePoints.pop();
            int undoSize = moves.size() - point;
            for (int i = 0; i < undoSize; i++) {
                Object[] move = moves.pop();
                BoxHolder holder = (BoxHolder) move[0];
                if (((int) move[2]) == 1) {
                    holder.set = false;
                    toFill.push(holder);
                    board[holder.idx[0]][holder.idx[1]] = '.';
                } else
                    holder.onRollback(((int) move[1]));
            }

        }
        return false;
    }


    private boolean move(char[][] board, LinkedList<Object[]> moves, BoxHolder b, Integer a) {
        int i = b.idx[0], j = b.idx[1];
        moves.push(new Object[]{b, a, 1});
        board[i][j] = (char) ('0' + a);
        b.set = true;
        return srow[i].tryNotify(a, moves) && scol[j].tryNotify(a, moves) && sarea[getAreaIdx(i, j)].tryNotify(a, moves);
    }

    public static class Distincter {

        private List<BoxHolder> subscribers = new ArrayList<>();

        public void onSubscribe(BoxHolder b) {
            subscribers.add(b);
        }

        public boolean tryNotify(int x, LinkedList<Object[]> moves) {
            for (BoxHolder subscriber : subscribers) {
                if (subscriber.set || !subscriber.contains(x)) continue;
                subscriber.onPut(x);
                moves.push(new Object[]{subscriber, x, -1});
                if (subscriber.isDead()) {
                    return false;
                }
            }
            return true;
        }

        public void notify(int x) {
            for (BoxHolder subscriber : subscribers) {
                subscriber.onPut(x);
            }
        }

    }

    public static class BoxHolder {

        public static final Map<Integer, Integer> SINGLE_MISS_SLOTS = new HashMap<>();
        public static final int[] TWO_POW = new int[10];
        static {
            for (int i = 1; i <= 9; i++) {
                TWO_POW[i] = 1 << i;
                SINGLE_MISS_SLOTS.put(TWO_POW[i], i);
            }
        }

        public int[] idx;
        public int slots;
        public int count;
        public boolean set = false;

        public BoxHolder(int[] idx) {
            this.idx = idx;
            slots = (1 << 10) - 2;
            count = 9;
        }

        public void onPut(int x) {
            int slots = ~TWO_POW[x];
            this.slots &= slots;
            count --;
        }

        public void onRollback(int x) {
            slots |= TWO_POW[x];
            count ++;
        }

        public boolean isDead() {
            return !set && slots == 0;
        }

        public boolean contains(int x) {
            return (slots & TWO_POW[x]) > 0;
        }

        public Integer getPossibleOne() {
            return SINGLE_MISS_SLOTS.get(slots);
        }

        public List<Integer> getPossibles() {
            List<Integer> ans = new ArrayList<>(9);
            for (int i = 1; i <= 9; i++) {
                if (contains(i))
                    ans.add(i);
            }
            return ans;
        }

        public int rank() {
            return count;
        }

        public void subscribe(Distincter... dist) {
            for (Distincter distincter : dist) {
                distincter.onSubscribe(this);
            }
        }

    }

    private int getAreaIdx(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }

    public static void main(String[] args) {

        char[][] board = {
                new char[]{'.','.','9','7','4','8','.','.','.'},
                new char[]{'7','.','.','.','.','.','.','.','.'},
                new char[]{'.','2','.','1','.','9','.','.','.'},
                new char[]{'.','.','7','.','.','.','2','4','.'},
                new char[]{'.','6','4','.','1','.','5','9','.'},
                new char[]{'.','9','8','.','.','.','3','.','.'},
                new char[]{'.','.','.','8','.','3','.','2','.'},
                new char[]{'.','.','.','.','.','.','.','.','6'},
                new char[]{'.','.','.','2','7','5','9','.','.'}};
        new SudokuSolver().solveSudoku(board);
        System.out.println(printBox(board));
    }

    private static String printBox(char[][] board) {
        return Arrays.deepToString(board).replaceAll("], \\[", "]\n[").replaceFirst("\\[", "").replace("]]", "]");
    }


}
