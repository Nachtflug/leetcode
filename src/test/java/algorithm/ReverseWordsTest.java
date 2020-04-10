package algorithm;

public class ReverseWordsTest {

    public static void main(String[] args) {

        System.out.println(ReverseWords.reverseWords(" help         me!"));
        System.out.println(ReverseWords.reverseWords("the sky is blue"));
        System.out.println(ReverseWords.reverseWords("th"));

        System.out.println(ReverseWordsWithoutExtraSpace.reverseWords(" help         me!"));
        System.out.println(ReverseWordsWithoutExtraSpace.reverseWords("the sky is blue"));
        System.out.println(ReverseWordsWithoutExtraSpace.reverseWords("th"));
    }

}
