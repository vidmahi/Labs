public class TicTacToe implements ITicTacToe
{
    //INSTANCE VARIABLES
    
    private TicTacToePiece[][] board;
    private TicTacToePiece piece;
    private TicTacToePiece currentPlayer;
    
    //CONSTRUCTORS
    public TicTacToe() 
    {
        //Initialize instance variables here
        board = new TicTacToePiece[3][3];
        
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j]= null;
            }
        }
        
        piece = null;
        currentPlayer = TicTacToePiece.X;
    }
    
    //METHODS
    /*
     *    Return the current player's piece (X or O)
     */
    public TicTacToePiece getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    /*
     *    Change the current player from X to O, or from O to X
     */
    public void nextPlayer()
    {
        if (currentPlayer == TicTacToePiece.X)
        {
            currentPlayer = TicTacToePiece.O;
        }
        else if (currentPlayer == TicTacToePiece.O)
        {
            currentPlayer = TicTacToePiece.X;
        }
    }
    
    /*
     *    Add the specified piece to the board at the specified row,col and return true
     *    If there is already a piece at that location, do not add the piece and return false
     */
    public boolean addPiece(int row, int col)
    {
        if (board[row][col] ==null)
        {
            board[row][col] = currentPlayer;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*
     *    Return the piece that is located at the specified row, col
     *    If there is no piece at that location, return null
     */
    public TicTacToePiece getPiece(int row, int col)
    {
        if (board[row][col] !=null)
        {
            return board[row][col];
        }
        else
        {
            return null;
        }
    }
    
    /*
     *    Return true if there is at least 1 empty space left on the board
     *    Return false if all spaces have a piece in them
     */
    public boolean hasEmptySpace()
    {
        int count = 0;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == null)
                {
                    count++;
                }
            }
        }
        if (count > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*    Return null if there is no winner
     *    Return the appropriate TicTacToePiece (X or Y) if there is a winner.
     *    Hint: use the helper methods: checkRowsForWinner(), checkColsForWinner(), and checkDiagsForWinner()
     */
    public TicTacToePiece getWinner()
    {
        if (checkRowsForWinner() == null && checkColsForWinner() == null && checkDiagsForWinner() == null)
        {
            return null;
        }
        else
        {
            if (checkRowsForWinner() != null)
            {
                return checkRowsForWinner();
            }
            else if (checkColsForWinner() != null)
            {
                return checkColsForWinner();
            }
            else
            {
                return checkDiagsForWinner();
            }
        }
    }
    
    /*
     *    Return true if there is a winner or if there are no empty spaces left on the board
     *    Otherwise, return false
     */
    public boolean isGameOver()
    {
        
        if (getWinner() != null || hasEmptySpace() == false)
        {
            return true;
        }
        else
        {
             return false;
        }
       
    }
    
    //HELPER METHODS
    /*
     *    If a, b, and c are all the same TicTacToe piece, then return that piece
     *    Otherwise, return null
     */
    private TicTacToePiece checkForWinner(TicTacToePiece a, TicTacToePiece b, TicTacToePiece c)
    {
        
        if (a == null || b== null ||c == null)
            return null;
        
        if((a == TicTacToePiece.X && b == TicTacToePiece.X  && c == TicTacToePiece.X) || (a == TicTacToePiece.O && b == TicTacToePiece.O  && c == TicTacToePiece.O))
        {
            //System.out.println(a +","+b+","+c);
            return a;
        }
        else
        {
            return null;
        }
    }
    
    /*
     *    Use the checkForWinner() helper method to check each of the 3 rows for a winner
     *    Return the first non-null winner that is found (starting from row 0)
     *    If no non-null winners are found, return null
     */
    private TicTacToePiece checkRowsForWinner()
    {
        int j = 0;
        for (int i = 0; i < board.length; i++)
        {
                TicTacToePiece p = null;
                p = checkForWinner(board[i][j], board[i][j+1], board[i][j+2]);
                if (p!= null)
                {
                    return p;
                }
        }
        
        return null;
    }
    
    /*
     *    Use the checkForWinner() helper method to check each of the 3 columns for a winner
     *    Return the first non-null winner that is found (starting from column 0)
     *    If no non-null winners are found, return null
     */
    private TicTacToePiece checkColsForWinner()
    {
        int i = 0;
        for (int j = 0; j < board[0].length; j++)
        {
                TicTacToePiece p = null;
                p = checkForWinner(board[i][j], board[i+1][j], board[i+2][j]);
                if (p!= null)
                {
                    return p;
                }
        }
        return null;
    }
    
    /*
     *    Use the checkForWinner() helper method to check both of the diagonals for a winner
     *    Check the top left -> bottom right diagonal first
     *    Check the top right -> bottom left diagonal second
     *    Return the first non-null winner that is found
     *    If no non-null winners are found, return null
     */
    private TicTacToePiece checkDiagsForWinner()
    {
        TicTacToePiece p = null;
        int i = 0;
        int j = 0;
        int k = 2;
        
        if (checkForWinner(board[i][j], board[i+1][j+1], board[i+2][j+2]) != null)
        {
            return board[i][j];
        }
        else if (checkForWinner(board[i][k], board[i+1][k-1], board[i+2][k-2]) != null)
        {
            return board[i][k];
        }
        else
        {
            return null;
        }
    }
    
    
}
