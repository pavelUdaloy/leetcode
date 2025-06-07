public class TODO_E_Count_the_Number_of_Consistent_Strings_1684 {

    public static void main(String[] args) {
    }

    public int countConsistentStrings(String allowed, String[] words) {
        char[] chars = null;//s.toCharArray();

        int lastSymbolIndex = -1;
        int firstSymbolIndex = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (lastSymbolIndex == -1 && chars[i] != ' ') {
                lastSymbolIndex = i;
            } else if (lastSymbolIndex != -1 && firstSymbolIndex == -1 && chars[i] == ' ') {
                firstSymbolIndex = i + 1;
            }
        }
        return 0;
    }
}
