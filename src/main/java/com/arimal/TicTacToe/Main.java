package com.arimal.TicTacToe;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        char[][] board = {{' ',' ',' '},
                          {' ',' ',' '},
                          {' ',' ',' '}};

        printBoard(board);

        Scanner scanner = new Scanner(System.in);

        while(true){
            playerTurn(board,scanner);

            if(isGameFinished(board)){
                break;
            }

            computerTurn(board);

            if(isGameFinished(board)){
                break;
            }

            printBoard(board);
        }

//        scanner.close();
    }

    private static boolean isGameFinished(char[][] board){

        if (hasContestantWon(board,'X')){
            printBoard(board);
            System.out.println("The player has won!");
            return true;
        } else if (hasContestantWon(board,'O')) {
            printBoard(board);
            System.out.println("The Computer has won!!");
            return true;
        }

        for(int i = 0 ; i< board.length;i++){
            for(int j = 0 ; j < board[i].length;j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return false;
    }

    private static boolean hasContestantWon(char[][] board, char sym) {
        if ((board[0][0] == sym && board[0][1] == sym && board[0][2] == sym) ||
            (board[1][0] == sym && board[1][1] == sym && board[1][2] == sym) ||
            (board[2][0] == sym && board[2][1] == sym && board[2][2] == sym) ||

            (board[0][0] == sym && board[1][0] == sym && board[2][0] == sym) ||
            (board[0][1] == sym && board[1][1] == sym && board[2][1] == sym) ||
            (board[0][2] == sym && board[1][2] == sym && board[2][2] == sym) ||

            (board[0][0] == sym && board[1][1] == sym && board[2][2] == sym) ||
            (board[0][2] == sym && board[1][1] == sym && board[2][0] == sym)){
            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] board){
        Random rand = new Random();
        int compTurn;
        while(true){
            compTurn = rand.nextInt(9)+1;
            if(isValidMove(board,compTurn)){
                break;
            }
        }
        System.out.println("Computer chose the position: "+ compTurn);
        placeMove(board,Integer.toString(compTurn),'O');
    }
    private static void playerTurn(char[][] board, Scanner scanner) {

        String userInput;
        while (true){
            System.out.println("Where would you like to play?");
            userInput = scanner.nextLine();
            if(isValidMove(board, Integer.parseInt(userInput))){
                break;
            }else {
                System.out.println(userInput + "Is not a valid move!");
            }
        }
        placeMove(board,userInput,'X');
    }


    private static boolean isValidMove(char[][] board, int position){
        return switch (position) {
            case 1 -> (board[0][0] == ' ');
            case 2 -> (board[0][1] == ' ');
            case 3 -> (board[0][2] == ' ');
            case 4 -> (board[1][0] == ' ');
            case 5 -> (board[1][1] == ' ');
            case 6 -> (board[1][2] == ' ');
            case 7 -> (board[2][0] == ' ');
            case 8 -> (board[2][1] == ' ');
            case 9 -> (board[2][2] == ' ');
            default -> false;
        };
    }


    private static void placeMove(char[][] board,String position, char symbol){
        switch (position){
            case "1":
                board[0][0]= symbol;
                break;
            case "2":
                board[0][1]= symbol;
                break;
            case "3":
                board[0][2]= symbol;
                break;
            case "4":
                board[1][0]= symbol;
                break;
            case "5":
                board[1][1]= symbol;
                break;
            case "6":
                board[1][2]= symbol;
                break;
            case "7":
                board[2][0]= symbol;
                break;
            case "8":
                board[2][1]= symbol;
                break;
            case "9":
                board[2][2]= symbol;
                break;
            default:
                System.out.println("Try again!!");
        }

    }

    private static void printBoard(char[][] board){
        System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]);

    }
}