package algorithm;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        s = s.replaceAll("[^\\w]", "").toLowerCase();
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}
