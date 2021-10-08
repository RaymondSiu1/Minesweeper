import java.io.*;
import java.util.*;

public class MinesweeperGame {
    boolean[][] mines;
    int[][] revealed;
    boolean[][] revealchecker;
    boolean[][] flag;
    boolean[][] correct;
    int rows = 0;
    int cols = 0;
    int datarow = 0;
    int datacol = 0;
    int mineTotal = 0;
    int counter = 0;
    int totalcount = 0;
    
    public MinesweeperGame() {
    	
    	//enter amount of rows and columns
        rows = 10;
        cols = 10;
        boolean[][] data = new boolean[rows][cols];
        
        //enter amount of mines
        mineTotal = 1;
        
        //where mines are located
        data[0][0] = true;

        
        revealed = new int[rows][cols];
        revealchecker = new boolean[rows][cols];
        flag = new boolean[rows][cols];
        correct = new boolean[rows][cols];
        mines = data;
    }

    public void printMineField() {
            for (int i = 0; i < rows; i++) {
                System.out.println();
                if (i < 10) {
                    System.out.print(" " + i);
                } else {
                    System.out.print(i);
                }
                System.out.print("|");
                for (int j = 0; j < cols; j++) {
                    if (revealchecker[i][j] == true) {
                        System.out.print(" " + revealed[i][j] + " |");
                    } else if (flag[i][j] == true) {
                        System.out.print(" F |");
                    } else {
                        System.out.print("   |");
                    }
                }
                if (i == rows - 1) {   //prints the x-axis
                    System.out.println();
                    for (int k = 0; k < cols; k++) {
                        if (k == 0) {
                            System.out.print("    " + k);
                        } else if (k < 10) {
                            System.out.print("   " + k);
                        } else {
                            System.out.print("  " + k);
                        }
                    }
                    System.out.println("\n");
                } 
            }
        }

    public void spacing(String[][]board) {
            for (int i = 0; i < rows; i++) {
                System.out.println();
                if (i < 10) {
                    System.out.print(" " + i);
                } else {
                    System.out.print(i);
                }
                System.out.print("|");
                for (int j = 0;j < cols; j++) {
                    System.out.print("   |");
                }
                if (i == rows - 1) {
                    System.out.println();
                    for (int k = 0; k < cols; k++) {
                        if (k == 0) {
                            System.out.print("    " + k);
                        } else if (k < 10) {
                            System.out.print("   " + k);
                        } else {
                            System.out.print("  " + k);
                        }
                    }
                    System.out.println("\n");
                }
            }
        }

     
    public int getNumAdjMines(int row, int col) {
        int adjMines = 0;
        if (row == 0 && col == 0) {
            if (mines[row + 1][col] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col + 1] == true) {
                adjMines ++;
            }
            if (mines[row][col + 1] == true) {
                adjMines ++;
            }
        } else if (row == rows - 1 && col == cols - 1) {
            if (mines[row - 1][col] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row][col - 1] == true) {
                adjMines ++;
            }
            return adjMines;
        } else if (row == 0 && col == cols - 1) {
            if (mines[row][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col - 1] == true) {
                adjMines ++;
            }
        }  else if (row == rows - 1 && col == 0) {
            if (mines[row - 1][col] == true) {
                adjMines ++;
            }
            if (mines[row][col + 1] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col + 1] == true) {
                adjMines ++;
            }
        } else if (row == rows - 1 && col == cols - 1) {
            if (mines[row][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col - 1] == true) {
                adjMines ++;
            }
        } else if (row == 0) {
            if (mines[row][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col + 1] == true) {
                adjMines ++;
            }
            if (mines[row][col + 1] == true) {
                adjMines ++;
            }
        } else if (col == 0) {
            if (mines[row - 1][col] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col + 1] == true) {
                adjMines ++;
            }
            if (mines[row][col + 1] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col + 1] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col] == true) {
                adjMines ++;
            }
        } if (row == rows - 1 && col < cols && col > 0) {
            if (mines[row][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col + 1] == true) {
                adjMines ++;
            }
            if (mines[row][col + 1] == true) {
                adjMines ++;
            }
        } else if (col == cols - 1 && row < rows && row > 0) {
            if (mines[row - 1][col] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col] == true) {
                adjMines ++;
            }
        } else if ( row > 0 && row < rows && col > 0 && col < cols) {
            if (mines[row + 1][col] == true) {
                adjMines ++;
            }
            if (mines[row][col + 1] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col + 1] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col] == true) {
                adjMines ++;
            }
            if (mines[row][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row + 1][col - 1] == true) {
                adjMines ++;
            }
            if (mines[row - 1][col + 1] == true) {
                adjMines ++;
            }
        }
        return adjMines;
    }

    private boolean isInBounds(int row, int col) {
        boolean bounds = true;
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            bounds = false;
        }
        return bounds;
    }

    public boolean isWon(boolean[][] correct, int totalcount) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (correct[i][j] == true) {
                    totalcount++;
                }
            }
        }
        if (totalcount == rows * cols) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLost(int row, int col) {
        if (mines[row][col] == true) {
            return true;
        } else {
            return false;
        }
    }

    public void printWin() {
        System.out.println("Congratulations, you won!");
        System.exit(0);
    }

    /**
     *Prints the specified message after the user loses.
     */
    public void printLoss() {
        System.out.println("You have revealed a mine and lost.");
        System.exit(0);
    }
    

    public void check(String[] commands) {
        int rrow = Integer.parseInt(commands[1]);
        int rcol = Integer.parseInt(commands[2]);
        if (isInBounds(rrow,rcol) == true) {
            if (isLost(rrow,rcol) == true) {
                printLoss();
            }
            revealchecker[rrow][rcol] = true;
            if (revealchecker[rrow][rcol] != mines[rrow][rcol]) {
                correct[rrow][rcol] = true;
            }
            if (isWon(correct, totalcount)) {
                printWin();
            }
            revealed[rrow][rcol] = getNumAdjMines(rrow,rcol);
            printMineField();
        } else {
            System.out.println("Error. Coordinates is out of bounds.");
        }
    }

    public void initialPrint() {
        printMineField();
    }
    
    public void play(String ucommand) {
        System.out.println();
        String command = ucommand.trim().replaceAll(" +", " ");
        String[] commands = command.split(" ");
        int blankspace = 0;
        while (commands[blankspace] == "") {
            blankspace++;
        }
        if (commands[blankspace].equals("Open") || commands[blankspace].equals("o")) {
            check(commands);
        } else if (commands[blankspace].equals("Flag") || commands[blankspace].equals("f")) {
            int rrow = Integer.parseInt(commands[1]);
            int rcol = Integer.parseInt(commands[2]);
            if (isInBounds(rrow,rcol) == true) {
                flag[rrow][rcol] = true;
                if (flag[rrow][rcol] == mines[rrow][rcol]) {
                    correct[rrow][rcol] = true;
                }
                if (isWon(correct,totalcount)) {
                    printWin();
                }
                printMineField();
            } else {
                System.out.println("Out of bounds.");
            }
        } else { 
            System.out.println("Input Error: Command not recognized!");
        }
        System.out.println();
    }
}
