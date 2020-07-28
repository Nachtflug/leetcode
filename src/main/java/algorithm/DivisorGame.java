package algorithm;

public class DivisorGame {

    static boolean[] firstWin = new boolean[1001];
    static {
        firstWin[1] = false;
        firstWin[2] = true;
        firstWin[3] = false;
        LOOP:
        for (int i = 4; i < 1001; i++) {
            if (!firstWin[i - 1]) {
                firstWin[i] = true;
                continue;
            }
            double root = Math.sqrt(i);
            for (int j = 2; j < root; j++) {
                if (i % j == 0) {
                    if (!firstWin[i - j] || !firstWin[i - i / j]) {
                        firstWin[i] = true;
                        continue LOOP;
                    }
                }
            }
        }
    }

    public boolean divisorGame(int n) {

        return firstWin[n];

    }

}
