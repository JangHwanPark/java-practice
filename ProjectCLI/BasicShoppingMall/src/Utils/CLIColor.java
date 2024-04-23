package src.Utils;

public class CLIColor {
    // 터미널 커스텀 유틸리티 클래스 (ANSI 이스케이프 코드)
    public static final String red = "\u001B[31m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String white = "\u001B[37m";
    public static final String exit = "\u001B[0m";

    private static String getColorCode(String color) {
        return switch (color.toLowerCase()) {
            case "red" -> red;
            case "yellow" -> yellow;
            case "blue" -> blue;
            case "purple" -> purple;
            case "cyan" -> cyan;
            default -> white;
        };
    }

    public static void printColorln(String message, String color) {
        System.out.println(getColorCode(color) + message + exit);
    }

    public static void printColor(String message, String color) {
        System.out.print(getColorCode(color) + message + exit);
    }

    public static void resetColor() {
        System.out.print(exit);
    }
}