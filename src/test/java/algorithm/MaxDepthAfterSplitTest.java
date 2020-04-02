package algorithm;

import java.util.Arrays;

public class MaxDepthAfterSplitTest {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(MaxDepthAfterSplit.maxDepthAfterSplit("((()))")));
        System.out.println(Arrays.toString(MaxDepthAfterSplit.maxDepthAfterSplit("()(())()")));
        System.out.println(Arrays.toString(MaxDepthAfterSplit.maxDepthAfterSplit("(()())")));

    }

}
