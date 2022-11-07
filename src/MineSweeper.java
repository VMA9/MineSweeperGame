import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int colNumber;
    int size;
    boolean game = true;
    int[][] map;
    int[][] board;
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.size = rowNumber * colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
    }

    public void run() {
        int rrow, rcolumn, success = 0;
        prepareGame();
        print(map);
        System.out.println("Game has started !");
        while (game) {
            print(board);
            System.out.print("Row : ");
            rrow = input.nextInt() - 1;
            System.out.print("Column : ");
            rcolumn = input.nextInt() - 1;

            if (rrow < 0 || rrow >= rowNumber) {
                System.out.println("Invalid coordinate !");
                continue;
            }
            if (rcolumn < 0 || rcolumn >= colNumber) {
                System.out.println("Invalid coordinate !");
                continue;
            }
            if (map[rrow][rcolumn] != -1) {
                checkMine(rrow, rcolumn);
                success++;
                if (success == (size - (size / 4))) {
                    System.out.print("\nCongratulations you won ! \n");
                    break;
                }
            } else {
                game = false;
                System.out.print("\nGame Over !\n");
            }
        }
    }

    public void prepareGame() {
        int randomRow;
        int randomColumn;
        int counter = 0;
        while (counter != (size / 4)) {
            randomRow = random.nextInt(this.rowNumber);
            randomColumn = random.nextInt(this.colNumber);
            if (this.map[randomRow][randomColumn] != -1) {
                this.map[randomRow][randomColumn] = -1;
                counter++;
            }
        }
    }

    public void print(int[][] arr) {
        for (int[] i : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("|");
                if (i[j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(i[j] + " ");
            }
            System.out.println();
        }
    }

    public void checkMine(int checkRow, int checkColumn) {
        if (map[checkRow][checkColumn] == 0) {
            if ((checkColumn < colNumber - 1) && (map[checkRow][checkColumn + 1] == -1)) {
                board[checkRow][checkColumn]++;
            }
            if ((checkColumn > 0) && (map[checkRow][checkColumn - 1] == -1)) {
                board[checkRow][checkColumn]++;
            }
            if ((checkRow < rowNumber - 1) && map[checkRow + 1][checkColumn] == -1) {
                board[checkRow][checkColumn]++;
            }
            if ((checkRow > 0) && (map[checkRow - 1][checkColumn] == -1)) {
                board[checkRow][checkColumn]++;
            }
            if ((checkRow > 0) && (checkColumn > 0) && (map[checkRow - 1][checkColumn - 1] == -1)) {
                board[checkRow][checkColumn]++;
            }
            if ((checkRow < rowNumber - 1) && (checkColumn < colNumber - 1) && (map[checkRow + 1][checkColumn + 1] == -1)) {
                board[checkRow][checkColumn]++;
            }
            if ((checkRow < rowNumber - 1) && (checkColumn > 0) && (map[checkRow + 1][checkColumn - 1] == -1)) {
                board[checkRow][checkColumn]++;
            }
            if ((checkRow > 0) && (checkColumn < colNumber - 1) && (map[checkRow - 1][checkColumn + 1] == -1)) {
                board[checkRow][checkColumn]++;
            }
            if (board[checkRow][checkColumn] == 0) {
                board[checkRow][checkColumn] = -2;
            }
        }
    }
}
