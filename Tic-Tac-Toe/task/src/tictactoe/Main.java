package tictactoe;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        System.out.print("Enter cells: ");
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.next().toCharArray(); // array of full cells
        char[][] tictac = new char[3][3];          // M x M array for my grid
        int k = 0;
        int coordI;
        int coordJ;

        // filling of grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tictac[i][j] = arr[k];
                k++;
            }
        }


        printGrid(tictac);
        tictac = turnToRight(tictac);

        while (true) {
            System.out.print("Enter the coordinates: ");

            try {
                coordI = scanner.nextInt();
                coordJ = scanner.nextInt();
                //System.out.println();

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
                tictac[coordI - 1][coordJ - 1] = 'X';
                printGridAndRotate(tictac);
                /*if (checkGrid(tictac)){
                    break;
                }*/
                break;
            }
        }

        /*

        int countX = 0;
        int countO = 0;
        int countEmpty = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'X') {
                countX++;
            } else if (arr[i] == 'O') {
                countO++;
            } else {
                countEmpty++;
            }
        }

        boolean firstLineX = arr[0] == 'X' && arr[1] == 'X' && arr[2] == 'X';
        boolean secondLineO = arr[3] == 'O' && arr[4] == 'O' && arr[5] == 'O';
        boolean secondLineX = arr[3] == 'X' && arr[4] == 'X' && arr[5] == 'X';
        boolean thirdLineX = arr[6] == 'X' && arr[7] == 'X' && arr[8] == 'X';
        boolean thirdLineO = arr[6] == 'O' && arr[7] == 'O' && arr[8] == 'O';
        boolean firstLineO = arr[0] == 'O' && arr[1] == 'O' && arr[2] == 'O';
        boolean firstColumnX = arr[0] == 'X' && arr[3] == 'X' && arr[6] == 'X';
        boolean secondColumnO = arr[1] == 'O' && arr[4] == 'O' && arr[7] == 'O';
        boolean secondColumnX = arr[1] == 'X' && arr[4] == 'X' && arr[7] == 'X';
        boolean thirdColumnO = arr[2] == 'O' && arr[5] == 'O' && arr[8] == 'O';
        boolean thirdColumnX = arr[2] == 'X' && arr[5] == 'X' && arr[8] == 'X';
        boolean firstColumnO = arr[0] == 'O' && arr[3] == 'O' && arr[6] == 'O';
        boolean firstDiagX = arr[0] == 'X' && arr[4] == 'X' && arr[8] == 'X';
        boolean firstDiagO = arr[0] == 'O' && arr[4] == 'O' && arr[8] == 'O';
        boolean secondDiagX = arr[2] == 'X' && arr[4] == 'X' && arr[6] == 'X';
        boolean secondDiagO = arr[2] == 'O' && arr[4] == 'O' && arr[6] == 'O';

        boolean impossible = (Math.abs(countX - countO) >= 2) ||
                (firstLineX && secondLineO
                        || secondLineX && thirdLineO
                        || thirdLineX && firstLineO
                        || firstLineO && secondLineX
                        || secondLineO && thirdLineX
                        || thirdLineO && firstLineX
                        || firstColumnX && secondColumnO
                        || secondColumnX && thirdColumnO
                        || thirdColumnX && firstColumnO
                        || firstColumnO && secondColumnX
                        || secondColumnO && thirdColumnX
                        || thirdColumnO && firstColumnX);

        boolean notFinished = !(firstLineX
                || secondLineO
                || secondLineX
                || thirdLineX
                || thirdLineO
                || firstLineO
                || firstColumnX
                || secondColumnO
                || secondColumnX
                || thirdColumnO
                || thirdColumnX
                || firstColumnO
                || firstDiagX
                || firstDiagO
                || secondDiagX
                || secondDiagO);

        if (impossible) {
            System.out.println("Impossible");
        } else if (notFinished && countEmpty != 0) {
            System.out.println("Game not finished");
        } else if (firstLineX || secondLineX || thirdLineX || firstColumnX || secondColumnX || thirdColumnX || firstDiagX || secondDiagX) {
            System.out.println("X wins");
        } else if (firstLineO || secondLineO || thirdLineO || firstColumnO || secondColumnO || thirdColumnO || firstDiagO || secondDiagO){
            System.out.println("O wins");
        } else if (countEmpty == 0) {
            System.out.println("Draw");
        }*/

    }

    public static boolean checkCell(int i, int j, char[][] chars) {
        if (chars[i - 1][j - 1] != '_') {
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

