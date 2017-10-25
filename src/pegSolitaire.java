/*
 * To change this license header, choose License Headers in Project 
Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;

/**
 *
 * @author Kadir
 */
public class pegSolitaire {

    public static void main(String[] args) {
        int countMoves = 0;
        //int[][] allMoves = new int[1000][2];
        //int pegs = 0;

        int[][] initialBoard = setupGameboard();
        System.out.println("Initial board:\n\n");
        printBoard(initialBoard);

        possibleMoves(initialBoard, countMoves);//,allMoves);

    }

    public static boolean possibleMoves(int[][] gameboard, int countMoves) 
{//,int[][] allMoves) {
        int height = 7;
        int width = 7;
        int[][] newboard = gameboard;
        if (checkResult(gameboard) == true) { //&& gameboard[3][3] == 1) {
            System.out.println("Final board:\n\n");
            printBoard(gameboard);
            return true;
        } else {
            for (int row = 0; row < gameboard.length; row++) {
                for (int col = 0; col < gameboard.length; col++) {
                    //move right
                    if (col < width - 2 && gameboard[row][col] == 1 && 
gameboard[row][col + 2] == 0 && gameboard[row][col + 1] == 1) {
                        //System.out.println("gameboard[x][y]: " + 
gameboard[row][col] + " gameboard[x + 2][y]" + gameboard[row + 2][col] + " 
gameboard[x + 1][y]" + gameboard[row + 1][col]);
                        //System.out.println("Iteration row:" + row + " 
col:" + col);
                        printBoard(newboard);
                        newboard[row][col] = 0;
                        newboard[row][col + 2] = 1;
                        newboard[row][col + 1] = 0;
                        //System.out.println("Iteration row:" + row + " 
col:" + col);
                        //printBoard(newboard);
                        countMoves++;
                        if (possibleMoves(newboard, countMoves) == true) {
                            return true;
                        } else {
                            possibleMoves(newboard, countMoves);
                            newboard[row][col] = 1;
                            newboard[row][col + 2] = 0;
                            newboard[row][col + 1] = 1;
                        }

                    }
                    //move left
                    if (col > 1 && gameboard[row][col] == 1 && 
gameboard[row][col - 2] == 0 && gameboard[row][col - 1] == 1) {
                        newboard[row][col] = 0;
                        newboard[row][col - 2] = 1;
                        newboard[row][col - 1] = 0;
                        //System.out.println("Iteration "+col);
                        //printBoard(newboard);
                        countMoves++;
                        if (possibleMoves(newboard, countMoves) == true) {
                            return true;
                        } else {
                            possibleMoves(newboard, countMoves);
                            newboard[row][col] = 1;
                            newboard[row][col - 2] = 0;
                            newboard[row][col - 1] = 1;
                        }
                    }
                    //move up
                    if (row < height - 2 && gameboard[row][col] == 1 && 
gameboard[row + 2][col] == 0 && gameboard[row + 1][col] == 1) {
                        newboard[row][col] = 0;
                        newboard[row + 2][col] = 1;
                        newboard[row + 1][col] = 0;
                        //System.out.println("Iteration "+col);
                        //printBoard(newboard);
                        countMoves++;
                        if (possibleMoves(newboard, countMoves) == true) {
                            return true;
                        } else {
                            possibleMoves(newboard, countMoves);
                            newboard[row][col] = 1;
                            newboard[row + 2][col] = 0;
                            newboard[row + 1][col] = 1;
                        }

                    }
                    //move down
                    if (row > 1 && gameboard[row][col] == 1 && gameboard[row 
- 2][col] == 0 && gameboard[row - 1][col] == 1) {
                        newboard[row][col] = 0;
                        newboard[row - 2][col] = 1;
                        newboard[row - 1][col] = 0;
                        //System.out.println("Iteration "+col);
                        //printBoard(newboard);
                        countMoves++;
                        if (possibleMoves(newboard, countMoves) == true) {
                            return true;
                        } else {
                            possibleMoves(newboard, countMoves);
                            newboard[row][col] = 1;
                            newboard[row - 2][col] = 0;
                            newboard[row - 1][col] = 1;
                        }
                    }

                }
            }
        }
        //System.out.println("No of Moves" + countMoves);
        //printBoard(newboard);

        return false;
    }

    public static boolean checkResult(int[][] board) {
        int count = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[x][y] == 1) {
                    count++;
                }
            }
        }
        if (count == 1 && board[3][3]==1) {
            return true;
        } else {
            return false;
        }
    }

    public static int[][] setupGameboard() {//String gameType) {
        //int height = 7;
        //int width = 7;
        //int emptyPart = 2;
        int[][] gameboard = new int[7][7];

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                gameboard[i][j] = -1;
            }
        }
    

        //switch (gameType) {
        //case "English":
        gameboard[3][3] = 0; //0 no peg
        gameboard[0][2] = 1; //1 means there is a peg
        gameboard[0][3] = 1;
        gameboard[0][4] = 1;
        gameboard[1][2] = 1;
        gameboard[1][3] = 1;
        gameboard[1][4] = 1;
        gameboard[2][0] = 1;
        gameboard[2][1] = 1;
        gameboard[2][2] = 1;
        gameboard[2][3] = 1;
        gameboard[2][4] = 1;
        gameboard[2][5] = 1;
        gameboard[2][6] = 1;
        gameboard[3][0] = 1;
        gameboard[3][1] = 1;
        gameboard[3][2] = 1;
        gameboard[3][4] = 1;
        gameboard[3][5] = 1;
        gameboard[3][6] = 1;
        gameboard[4][0] = 1;
        gameboard[4][1] = 1;
        gameboard[4][2] = 1;
        gameboard[4][3] = 1;
        gameboard[4][4] = 1;
        gameboard[4][5] = 1;
        gameboard[4][6] = 1;
        gameboard[5][2] = 1;
        gameboard[5][3] = 1;
        gameboard[5][4] = 1;
        gameboard[6][2] = 1;
        gameboard[6][3] = 1;
        gameboard[6][4] = 1;
        // break;
        //}
        //System.out.println(Arrays.deepToString(gameboard).replace("], ", 
"]\n").replace("[[", "[").replace("]]", "]"));
        return gameboard;
    }

    public static void printBoard(int[][] board) {
        System.out.println(Arrays.deepToString(board).replace("-1", " 
").replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
    }
}


