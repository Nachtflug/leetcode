package algorithm;

public class MinimumLengthEncodingTest {

    public static void main(String[] args) {

        System.out.println(MinimumLengthEncoding.minimumLengthEncoding(
                new String[]{"t", "at", "bt"}
        ));
        System.out.println(MinimumLengthEncoding.minimumLengthEncoding(
                new String[]{"time", "me", "", "call"}
        ));
        System.out.println(MinimumLengthEncoding.minimumLengthEncoding(
                new String[]{"time", "time", "time"}
        ));

    }


}
