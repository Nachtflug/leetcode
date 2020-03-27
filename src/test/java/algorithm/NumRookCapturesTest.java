package algorithm;

public class NumRookCapturesTest {

    public static void main(String[] args) {

        System.out.println(NumRookCaptures.numRookCaptures(
                new char[][]{
                        new char[]{'.','.','.','.','.','.','.','.'},
                        new char[]{'.','.','.','p','.','.','.','.'},
                        new char[]{'.','.','.','R','.','.','.','p'},
                        new char[]{'.','.','.','.','.','.','.','.'},
                        new char[]{'.','.','.','.','.','.','.','.'},
                        new char[]{'.','.','.','p','.','.','.','.'},
                        new char[]{'.','.','.','.','.','.','.','.'},
                        new char[]{'.','.','.','.','.','.','.','.'}}

        ));

    }

}
