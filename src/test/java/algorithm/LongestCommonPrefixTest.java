package algorithm;

public class LongestCommonPrefixTest {

    public static void main(String[] args) {
        System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[]{"apple", "applepen", "applecare"}));
        System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[]{"apple", "mac", "applecare"}));
        System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[]{"", "mac", "applecare"}));
        System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[]{}));
        System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[]{"father", "farm", "fault"}));
    }

}
