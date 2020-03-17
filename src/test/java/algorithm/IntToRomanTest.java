package algorithm;

public class IntToRomanTest {

    public static void main(String[] args) {
        System.out.println(IntToRoman.intToRoman(1994));
        System.out.println(IntToRoman.intToRoman(4));
        assert IntToRoman.intToRoman(3).equals("III");
        assert IntToRoman.intToRoman(4).equals("IV");
        assert IntToRoman.intToRoman(9).equals("IX");
        assert IntToRoman.intToRoman(58).equals("LVIII");
        assert IntToRoman.intToRoman(1994).equals("MCMXCIV");
    }

}
