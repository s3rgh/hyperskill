package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.next().toCharArray();
        int countX = 0;
        int countO = 0;
        int countEmpty = 0;
        System.out.println("---------");
        System.out.println("| " + arr[0] + " " + arr[1] + " " + arr[2] + " |");
        System.out.println("| " + arr[3] + " " + arr[4] + " " + arr[5] + " |");
        System.out.println("| " + arr[6] + " " + arr[7] + " " + arr[8] + " |");
        System.out.println("---------");

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
        }
    }
}

