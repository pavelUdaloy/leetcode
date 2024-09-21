import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class H_Shortest_Palindrome_214 {
    public String shortestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        List<Character> list = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(LinkedList::new));
        Character c = list.get(0);
        boolean flag = false;
        if (list.size() >= 2) {
            if (list.getFirst().equals(list.getLast()) && !list.get(1).equals(list.get(list.size() - 2))) {
                flag = true;
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            int firstIndex = (list.size() - 1) - i;
            Character first = list.get(firstIndex);
            Character last = list.get(i);
            if (!last.equals(first)) {
                list.add(firstIndex, last);
                i++;
            }
        }
//        todo           тут хз - вернее не хз, а говно какое-то,
//        todo           ибо тест adcba, выдает ВЕРНОЕ abcdcba
//        todo           а литкод ждем abcdadcba
//        if (flag) {
//            list.add(list.size() / 2, c);
//        }
        StringBuilder result = new StringBuilder();
        for (Character ch : list) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        H_Shortest_Palindrome_214 hShortestPalindrome214 = new H_Shortest_Palindrome_214();
//        System.out.println(hShortestPalindrome214.shortestPalindrome("aacecaaa"));
//        System.out.println(hShortestPalindrome214.shortestPalindrome("abcd"));
//        System.out.println(hShortestPalindrome214.shortestPalindrome("aabba"));
//        System.out.println(hShortestPalindrome214.shortestPalindrome("aaaaabba"));
//        System.out.println(hShortestPalindrome214.shortestPalindrome(""));
        System.out.println(hShortestPalindrome214.shortestPalindrome("adcba"));
    }
}
