public class NQueens
{
   final static int N = 12;

   private static boolean possibleQueen(boolean[][] board, int row, int column){
      for(int i = 0; i < N; i++)
          if(board[row][i] && i != column)
              return false;
      
      for(int i = 0; i < N; i++)
          if(board[i][column] && i != row)
              return false;

      
      for(int i = 0; i < N; i++){
          for(int j = 0; j < N; j++) {
              if(i == row && j == column)
                  continue;
              if(board[i][j]){
                  if(row-i == column-j || i-row == column-j)
                      return false;             
              }
          }
      }
      
      return true;
   }
   
   private static void printBoard(boolean[][] board){
        for(int i = 0; i < N; i++){
            for(int j = 0; j<N; j++){
                if(board[i][j])
                    System.out.print("Q ");
                else
                    System.out.print("_ ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
   }
   
   private static void solve(boolean[][] board, int column){
      if(column >= N){
          printBoard(board);
      }
      else {
        for(int row = 0; row < N; row++) {
             if(possibleQueen(board,row,column)){
                 board[row][column] = true;   
                 solve(board,column+1);
                 board[row][column] = false;
             }
             // printBoard(board);
        }
      }
   }
   
   public static void main(String[] args){
     boolean[][] board = new boolean[N][N];  

     printBoard(board);
     solve(board,0);    

  }
}