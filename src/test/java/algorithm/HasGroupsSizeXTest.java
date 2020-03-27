package algorithm;

public class HasGroupsSizeXTest {

    public static void main(String[] args) {
        System.out.println(HasGroupsSizeX.hasGroupsSizeX(new int[]{}));
        System.out.println(HasGroupsSizeX.hasGroupsSizeX(new int[]{1}));
        System.out.println(HasGroupsSizeX.hasGroupsSizeX(new int[]{1, 2}));
        System.out.println(HasGroupsSizeX.hasGroupsSizeX(new int[]{1, 1, 2}));
        System.out.println(HasGroupsSizeX.hasGroupsSizeX(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(HasGroupsSizeX.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 3, 3}));
        System.out.println(HasGroupsSizeX.hasGroupsSizeX(new int[]{1, 1, 2, 2, 3, 3, 1, 2, 3}));
        System.out.println(HasGroupsSizeX.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2, 3, 3})); //true
        System.out.println(HasGroupsSizeX.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2, 1, 1})); //true
    }

}
