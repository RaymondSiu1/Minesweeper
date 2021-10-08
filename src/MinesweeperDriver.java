import java.util.Scanner;
//EDIT MINEFIELD AND MINES IN MineSweeperGame.java
public class MinesweeperDriver {
    public static void main(String[] args) {
    	System.out.println("Rules: Opening a mine loses and ends the game.\nOpening a square without a mine reveals a number that represents the amount of mines in adjacent (including diagonal) squares.\nThe game is won when all the squares not containing mines are revealed.\nYou are able to flag mines, which allow you to keep track sqaures that you believe contain mines.\n");
        Scanner sc = new Scanner(System.in);
        MinesweeperGame game = new MinesweeperGame();
        game.initialPrint();
        System.out.println("Enter \"Open/o x y\" to reveal a square and \"Flag/f x y\" to flag a square. x being the row and y being the column");
        while (true) {
            String command = sc.nextLine();
            game.play(command);
        }
    }
}
