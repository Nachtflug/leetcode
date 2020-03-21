package algorithm;

/**
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 */
public class CanMeasureWater {

    /**
     * mx + ny = z
     * gcd(x, y) = d; mx + ny = m'd + n'd = z
     * (m' + n')d = z
     * m' + n' = z / d
     * 只要证明x和y的最大公约数整除z即可，当然，不能超出两杯子容量的上限
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;
        if (x + y == z || x == z || y == z || z == 0)
            return true;

        return z % gcd(x, y) == 0;

    }

    private static int gcd(int x, int y) {

        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        while (y != 0) {
            int d = x % y;
            x = y;
            y = d;
        }
        return x;
    }

}
