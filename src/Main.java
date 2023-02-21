import java.util.*;
import java.util.Map;

public class Main {
    private static final Map<String, Integer> wordCount = new HashMap<>();

//Количество слов в тексте
    public static void addWords(String s) {
        for (String word : s.split("\\s")) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        System.out.println("В тексте: " + wordCount.size() + " слов");
        printWordCount();
    }
//TOP10
    public static void printWordCount() {
        System.out.println("ТОП 10: ");
        wordCount.entrySet()
                .stream()
                .limit(10)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(word -> System.out.println(word.getValue() + " - " + word.getKey()));
    }
//Строка на вход
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scanner.nextLine();
        addWords(text);
    }
}