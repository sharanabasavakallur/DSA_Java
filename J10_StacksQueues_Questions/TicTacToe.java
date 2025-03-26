package J10_StacksQueues_Questions;

import java.util.Scanner;

//XOX game
public class TicTacToe {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        //initialize board with empty char's
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                board[row][col]=' ';
            }
        }
        int no_of_moves=0;
        char player='X';//or 'O' this is who's gonna make first move
        boolean gameOver=false;
        Scanner sc=new Scanner(System.in);
        while(!gameOver){
            //printing board so that player can visualize the board and make a move
            printBoard(board);
            //asking current player(here 'X') to make a move by giving input row,col i.e, if 0,0 means first row first column..
            //before that check if atleast one spot is empty in the board
            if(no_of_moves==9){
                System.out.println("Its a tie!!");
                return;
            }
            System.out.println("player "+player+" move: ");
            int row=sc.nextInt();
            int col=sc.nextInt();

            if(board[row][col]==' '){
                board[row][col]=player;

                //after making move checking whether player has won or not if not ask other player(here player 'O') to make a next move
                gameOver= haveWon(player,board);
                if(gameOver){
                    printBoard(board);
                    System.out.println("player "+player+" won!");
                    return;
                }
                else{//if game isn't over then change the current player to make next move
                    player=(player=='X') ? 'O' : 'X';
                }
                no_of_moves+=1;
            }else{//if that spot is not empty
                System.out.println("invalid move!, try again..");
            }
        }
    }

    public static void printBoard(char[][] board){
        for(int row=0;row<board.length;row++){//row.length is 3 in 2d array there are 3 subarrays
            for(int col=0;col<board[0].length;col++){//board[0].length is 3 coz 0th row has 3 cols infact every row has 3 cols that's why it does matter board[row].length or board[0].length
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }

    public static boolean haveWon(char player,char[][] board){
        //check for rows
        for(int row=0;row<board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
                return true;
        }

        //check for cols
        for(int col=0;col<board[0].length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
                return true;
        }

        //check for diagonals
        if(board[1][1]==player){//common spot for both diagonals
            if(board[0][0]==player && board[2][2]==player)//right diagonal
                return true;
            if(board[0][2]==player && board[2][0]==player)//left diagonal
                return true;
        }
        //if none of the above condition passes then
        return false;
    }
}
