import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row;
        int column;

        System.out.println("\n *** Minesweeper Game ***\n ");
        System.out.println("Enter Game Size");

        System.out.print("Enter the number of row : ");
        row = input.nextInt();
        System.out.print("Enter the number of columns : ");
        column = input.nextInt();

        if (row > 1 && column > 1) {
            MineSweeper mine = new MineSweeper(row, column);
            mine.run();
        }else{
            System.out.println("You have entered invalid !");
        }
    }
}