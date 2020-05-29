package tictactoe;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] tictac = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};          // M x M array for my grid
        int coordI;
        int coordJ;
        int k = 0;
        printGrid(tictac);

        while (true) {
            System.out.print("Enter the coordinates: ");

            try {
                coordI = scanner.nextInt();
                coordJ = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("You should enter numbers!"); // if exception, try again
                scanner.nextLine();
                continue;
            }

            if ((coordI < 1 || coordI > 3) || (coordJ < 1 || coordJ > 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (checkCell(coordI, coordJ, tictac)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                switch (k % 2) {
                    case 0:
                        tictac[coordI - 1][coordJ - 1] = 'X';
                        printGridAndRotate(tictac);
                        break;

                    case 1:
                        tictac[coordI - 1][coordJ - 1] = 'O';
                        printGridAndRotate(tictac);
                        break;
                }
                if (checkWinCondition(tictac) == 'X') {
                    System.out.println("X wins");
                    break;
                }
                if (checkWinCondition(tictac) == 'O') {
                    System.out.println("O wins");
                    break;
                }
                if (checkWinCondition(tictac) == 'D') {
                    System.out.println("Draw");
                    break;
                }
            }
            k++;
        }
    }

    public static char checkWinCondition(char[][] arr) {

        int countX = 0;
        int countO = 0;
        int countEmpty = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'X') {
                    countX++;
                } else if (arr[i][j] == 'O') {
                    countO++;
                } else {
                    countEmpty++;
                }
            }
        }

        boolean firstLineX = arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X';
        boolean secondLineO = arr[1][0] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O';
        boolean secondLineX = arr[1][0] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X';
        boolean thirdLineX = arr[2][0] == 'X' && arr[2][1] == 'X' && arr[2][2] == 'X';
        boolean thirdLineO = arr[2][0] == 'O' && arr[2][1] == 'O' && arr[2][2] == 'O';
        boolean firstLineO = arr[0][0] == 'O' && arr[0][1] == 'O' && arr[0][2] == 'O';
        boolean firstColumnX = arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X';
        boolean secondColumnO = arr[0][1] == 'O' && arr[1][1] == 'O' && arr[2][1] == 'O';
        boolean secondColumnX = arr[0][1] == 'X' && arr[1][1] == 'X' && arr[2][1] == 'X';
        boolean thirdColumnO = arr[0][2] == 'O' && arr[1][2] == 'O' && arr[2][2] == 'O';
        boolean thirdColumnX = arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X';
        boolean firstColumnO = arr[0][0] == 'O' && arr[1][0] == 'O' && arr[2][0] == 'O';
        boolean firstDiagX = arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X';
        boolean firstDiagO = arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O';
        boolean secondDiagX = arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X';
        boolean secondDiagO = arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O';

        boolean winX = firstLineX || secondLineX || thirdLineX || firstColumnX || secondColumnX || thirdColumnX || firstDiagX || secondDiagX;
        boolean winO = firstLineO || secondLineO || thirdLineO || firstColumnO || secondColumnO || thirdColumnO || firstDiagO || secondDiagO;


        if (winX) {
            return 'X';
        }
        if (winO) {
            return 'O';
        }
        if (countEmpty == 0) {
            return 'D';
        }

        return 'N';
    }


    public static boolean checkCell(int i, int j, char[][] chars) {
        if (chars[i - 1][j - 1] != ' ') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkGrid(char[][] chars) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == '_') {
                    count++;
                }
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method can print my grid
     * and all cells
     *
     * @param arr
     */
    public static void printGrid(char[][] arr) {

        System.out.println("---------");
        System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
        System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
        System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
        System.out.println("---------");
    }

    /**
     * Method rotates my matrix
     *
     * @param arr1
     * @name tictac
     * Also it prints my grid and all cells
     */
    public static void printGridAndRotate(char[][] arr1) {

        char[][] arr = turnToLeft(arr1);

        System.out.println("---------");
        System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
        System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
        System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
        System.out.println("---------");
    }

    /**
     * Method rotates matrix to the left
     *
     * @param arr
     * @return result[][]
     */
    public static char[][] turnToLeft(char[][] arr) {
        int m = arr.length;
        char[][] result = new char[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result[m - j - 1][i] = arr[i][j];
            }
        }
        return result;
    }

    /**
     * Method rotates matrix to the right
     *
     * @param arr
     * @return result[][]
     */
    public static char[][] turnToRight(char[][] arr) {
        int m = arr.length;
        char[][] result = new char[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result[j][m - i - 1] = arr[i][j];
            }
        }
        return result;
    }
}