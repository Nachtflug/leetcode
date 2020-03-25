package algorithm;

public class BracketsValidationTest {

    public static void main(String[] args) {
        System.out.println(BracketsValidation.isValid("(){}[]"));
        System.out.println(BracketsValidation.isValid(""));
        System.out.println(BracketsValidation.isValid("[]}[]"));
        System.out.println(BracketsValidation.isValid("{[()]}[]"));
    }

}
