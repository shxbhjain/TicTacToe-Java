import java.util.*;

class tictactoe {
    public static void main(String[] args) {

        char[][] board = new char[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        int moves = 0;

        Scanner sc = new Scanner(System.in);

        while (!gameOver) {

            int row, col;
            printboard(board);
            System.out.println("Player " + player + " enter row and column (0-2):");

            if (sc.hasNextInt()) {
                row = sc.nextInt();
            } else {
                System.out.println("Invalid input. Enter numbers only.");
                sc.next();
                continue;
            }

            if (sc.hasNextInt()) {
                col = sc.nextInt();
            } else {
                System.out.println("Invalid input. Enter numbers only.");
                sc.next();
                continue;
            }

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Out of bounds. Try again.");
                continue;
            }

            if (board[row][col] == ' ') {

                board[row][col] = player;
                moves++;   
                gameOver = haveWon(board, player);

                if (gameOver) {
                    System.out.println("Player " + player + " has won");
                }
                else if (moves == 9) {
                    printboard(board);
                    System.out.println("Game is a draw!");
                    gameOver = true;
                }
                else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } 
            else {
                System.out.println("Invalid move. Try Again");
            }
        }

        printboard(board);
        sc.close();
    }

    public static void printboard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean haveWon(char[][] board, char player) {

        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
