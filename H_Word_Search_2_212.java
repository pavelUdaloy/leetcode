import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class H_Word_Search_2_212 {

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'},{'e', 't', 'a', 'e'},{'i', 'h', 'k', 'r'},{'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> result = findWords(board, words);
        System.out.println(result);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if (words.length == 0) {
            return result.stream().toList();
        }

        Set<String> uniqueWords = new HashSet<>();

        int maxLength = words[0].length();
        int minLength = words[0].length();
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            uniqueWords.add(word);
            if (maxLength < word.length()) {
                maxLength = word.length();
            }
            if (minLength > word.length()) {
                minLength = word.length();
            }
        }

        if (maxLength == 0) {
            return result.stream().toList();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String found = check(board, i, j);
                // тут проблема в том что слова не просто в горизонталь или вертикаль могут,
                // - они могут змейкой в матрице распологаться
            }
        }

        return result.stream().toList();
    }

    private static String check(char[][] board, int i, int j) {
        return null;
    }
}
