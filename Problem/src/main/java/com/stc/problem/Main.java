package com.stc.problem;

import java.util.Scanner;

public class Main {

    final static Util util = Util.INSTANCE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Your String : ");
        String text = scanner.next();
        char[] fullText = text.toCharArray();

        if (!text.contains("(")
                || (fullText.length >= 1 && fullText.length <= 2000)
                || util.validateTextIsLowerCase(fullText)
                || util.validateBracketsBalanced(text)) {
            System.out.println(fullText);
            return;
        }

        StringBuilder fullString = new StringBuilder();

        while (text.contains("(")) {
            fullString.append(text.substring(0, text.indexOf("(")));
            text = text.substring(text.indexOf("("));
            String reverseText = text.substring(text.indexOf("("), text.indexOf(")") + 1);
            fullString.append(util.reverseString(reverseText));
            text = text.substring(text.indexOf(")") + 1);
        }
        if (fullString.length() < fullText.length)
            fullString.append(util.reverseString(text.substring(text.indexOf(")") + 1)));
        System.out.println(fullString);
    }

}
