import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row;
        int column;

        System.out.println(" *** Minesweeper Game *** ");
        System.out.println("Enter Game Size");

        System.out.print("Enter the number of row : ");
        row = input.nextInt();
        System.out.print("Enter the number of columns : ");
        column = input.nextInt();

        MineSweeper mine = new MineSweeper(row,column);
        mine.run();
    }
}