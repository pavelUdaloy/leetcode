import java.util.Arrays;

public class M_Word_Search_79 {

    public static void main(String[] args) {
        char[][] board1 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new M_Word_Search_79().exist(board1, "ABCCED"));

        char[][] board2 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new M_Word_Search_79().exist(board2, "SEE"));

        char[][] board3 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new M_Word_Search_79().exist(board3, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        char firstLetter = word.charAt(0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == firstLetter) {
                    if (word.length() == 1) {
                        return true;
                    }
                    char[][] board2 = copyArray(board);
                    board2[i][j] = '8';
                    if (check(board2, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int letterIndex, int letterN, int letterM) {
        if (word.length() - 1 == letterIndex) {
            return true;
        }
        char letter = word.charAt(letterIndex + 1);

        if (letterN != 0 && board[letterN - 1][letterM] == letter) {
            char[][] board2 = copyArray(board);
            board2[letterN - 1][letterM] = '8';
            if (check(board2, word, letterIndex + 1, letterN - 1, letterM)) {
                return true;
            }
        }
        if (letterM != 0 && board[letterN][letterM - 1] == letter) {
            char[][] board2 = copyArray(board);
            board2[letterN][letterM - 1] = '8';
            if (check(board2, word, letterIndex + 1, letterN, letterM - 1)) {
                return true;
            }
        }
        if (letterN != board.length - 1 && board[letterN + 1][letterM] == letter) {
            char[][] board2 = copyArray(board);
            board2[letterN + 1][letterM] = '8';
            if (check(board2, word, letterIndex + 1, letterN + 1, letterM)) {
                return true;
            }
        }
        if (letterM != board[0].length - 1 && board[letterN][letterM + 1] == letter) {
            char[][] board2 = copyArray(board);
            board2[letterN][letterM + 1] = '8';
            if (check(board2, word, letterIndex + 1, letterN, letterM + 1)) {
                return true;
            }
        }
        return false;
    }

    private char[][] copyArray(char[][] array) {
        if (array == null) {
            return null;
        }
        char[][] copiedArray = new char[array.length][];

        for (int i = 0; i < array.length; i++) {
            copiedArray[i] = new char[array[i].length];
            copiedArray[i] = Arrays.copyOf(array[i], array[i].length);
        }

        return copiedArray;
    }
}
