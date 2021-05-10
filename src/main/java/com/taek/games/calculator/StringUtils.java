package com.taek.games.calculator;

public class StringUtils {

    public static boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static String trimAll(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
