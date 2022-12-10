import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {

        WordsChecker wordsChecker = new WordsChecker(TEXT);
        boolean ipsum = wordsChecker.hasWord("ipsum");
        System.out.println(ipsum);

        char[] arr = TEXT.toLowerCase(Locale.ROOT).toCharArray();

        Map<Character, Integer> symbols = new HashMap<>();

        for (char symbol : arr) {
            if (Character.isLetter(symbol)) {
                Integer integer = symbols.get(symbol);

                if (integer == null) {
                    symbols.put(symbol, 1);
                } else {
                    symbols.put(symbol, ++integer);
                }
            }
        }
        Integer max = getMax(symbols);
        Integer min = getMin(symbols);

        System.out.println("Макс. число символов: ");

        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        System.out.println("Мин. число символов: ");

        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (entry.getValue() == min) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    private static Integer getMax(Map<Character, Integer> symbols) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        return max;
    }

    private static Integer getMin(Map<Character, Integer> symbols) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (min > entry.getValue()) {
                min = entry.getValue();
            }
        }
        return min;
    }
}
