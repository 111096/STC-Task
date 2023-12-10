package com.stc.problem;

import java.util.ArrayDeque;
import java.util.Deque;

public enum Util {

    INSTANCE;

    public String reverseString(String text) {
        String firstText = text.substring(0, 1);
        String lastText = text.substring(text.length() - 1);
        char[] reverseChar = text.substring(1, text.length() - 1).toCharArray();
        StringBuilder reverseText = new StringBuilder(firstText);
        for (int i = reverseChar.length - 1; i >= 0; i--) {
            reverseText.append(reverseChar[i]);
        }
        reverseText.append(lastText);
        return reverseText.toString();
    }

    public boolean validateTextIsLowerCase(char[] charText) {
        for (char c : charText) {
            if (!Character.isLowerCase(c))
                return false;
        }
        return true;
    }

    static boolean validateBracketsBalanced(String expr) {
        Deque<Character> stack
                = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }
}
