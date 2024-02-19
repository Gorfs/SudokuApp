package Logic;
public class Board {
    private static int[][] board;

    public static int[][] getBoard(){
        return board;
    }

    public Board(){
        board = new int[9][9];
    }

    public static int[][] getCubes(){
        // returns an Array of Arrays and each smaller array represents a cube without the return lines
        int[][] result = new int[9][];
        int board_x;
        int board_y;
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                board_x = j / 3;
                board_y = j / 3;
                result[i][j] = board[board_x][board_y];
            }
        }

    return result;
    }

    // code to see if the board is solved
    public static boolean rowsSolved(){
        int sum = 0;
        for(int i = 0 ; i < 9; i++){
            int[] row = board[i];
            for(int j = 0 ; j < 9; j++){
                sum += row[j];
            }
            if(sum != 45){
                return false;
            }

        }
        return true;
    }

    public static boolean colsSolved(){
        int sum = 0;
        for(int i = 0 ; i < 9; i++){
            for(int j = 0 ; j < 9; j++){
                sum += board[j][i];
            }
            if(sum != 45){
                return false;
            }
        }
        return true;
    }

    public static boolean cubesSolved(){
        int sum = 0;
        int[][] cubes = getCubes();

        for(int i  = 0 ; i < 9; i++){
            sum = 0;
            for(int j = 0 ; j < cubes[i].length; j++){
                sum += cubes[i][j];
            }
            if(sum != 45){
                return false;
            }

        }
        return true;
    }

    public static boolean isSolved(){
        // check for rows
        return rowsSolved() && colsSolved() && cubesSolved();
    }
}
