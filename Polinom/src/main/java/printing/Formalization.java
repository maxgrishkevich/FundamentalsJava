package printing;

public class Formalization {
    public static String GREEN = "\u001B[32m";
    public static String BLACK_BOLD = "\033[1;30m";
    public static String RESET = "\u001B[0m";

    public static void title(String title) {
        System.out.println(BLACK_BOLD + "\n" + title + ": " + RESET);
    }

    public static String result(double result) {
        return GREEN + doubleFormat(result) + RESET;
    }

    public static double doubleFormat(double doubleNum) {
        return Math.round(doubleNum * 100.0) / 100.0;
    }
}
