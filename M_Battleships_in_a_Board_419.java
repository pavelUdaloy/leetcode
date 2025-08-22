public class M_Battleships_in_a_Board_419 {

    public static void main(String[] args) {

    }

    public int countBattleships(char[][] board) {
        int counter = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' &&
                        (i + 1 >= board.length || board[i + 1][j] == '.') &&
                (j + 1 >= board[i].length || board[i][j + 1] == '.')) {
                    counter ++;
                }
            }
        }

        return counter;
    }
}
