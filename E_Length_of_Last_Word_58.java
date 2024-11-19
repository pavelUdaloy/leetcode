public class E_Length_of_Last_Word_58 {

    public static void main(String[] args) {
        System.out.println(new E_Length_of_Last_Word_58().lengthOfLastWord("Hello World"));
        System.out.println(new E_Length_of_Last_Word_58().lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(new E_Length_of_Last_Word_58().lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();

        int lastSymbolIndex = -1;
        int firstSymbolIndex = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (lastSymbolIndex == -1 && chars[i] != ' ') {
                lastSymbolIndex = i;
            } else if (lastSymbolIndex != -1 && firstSymbolIndex == -1 && chars[i] == ' ') {
                firstSymbolIndex = i + 1;
            }
        }
        if (firstSymbolIndex == -1) {
            firstSymbolIndex = 0;
        }
        return lastSymbolIndex - firstSymbolIndex + 1;
    }
}
