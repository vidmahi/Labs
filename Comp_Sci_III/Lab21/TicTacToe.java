public class TicTacToe implements ITicTacToe
{
	//INSTANCE VARIABLES
	TicTacToePiece[][] board;
	TicTacToePiece currentPlayer;
	
	
	//CONSTRUCTORS
    public TicTacToe() 
    {
    	//Initialize instance variables here
    	board = new TicTacToePiece[3][3];
    	currentPlayer = TicTacToePiece.X;
    }
    
    //METHODS
    /*
     *	Return the current player's piece (X or O)
     */
    public TicTacToePiece getCurrentPlayer()
    {
    	return currentPlayer;
    }
    
    /*
     *	Change the current player from X to O, or from O to X
     */
    public void nextPlayer()
    {
    	if(currentPlayer == TicTacToePiece.X)
    		currentPlayer = TicTacToePiece.O;
    	else
    		currentPlayer = TicTacToePiece.X;
    }
    
    /*
     *	Add the specified piece to the board at the specified row,col and return true
     *	If there is already a piece at that location, do not add the piece and return false
     */
    public boolean addPiece(int row, int col)
    {
    	if(null != getPiece(row, col))
    		return false;
    	if(row < 0 || col < 0 || row >= 3 || col >= 3)
    		return false;
    	board[row][col] = currentPlayer;
    	return true;
    }
    
    /*
     *	Return the piece that is located at the specified row, col
     *	If there is no piece at that location, return null
     */
    public TicTacToePiece getPiece(int row, int col)
    {
    	if(row < 0 || col < 0 || row >= 3 || col >= 3)
    		return null;
    	return board[row][col];
    }
    
    /*
     *	Return true if there is at least 1 empty space left on the board
     *	Return false if all spaces have a piece in them
     */
    public boolean hasEmptySpace()
    {
    	for(int r=0; r<board.length; r++)
    		for(int c=0; c<board[r].length; c++)
    			if(board[r][c] == null)
    				return true;
    	return false;
    }
    
    /*	Return null if there is no winner
     *	Return the appropriate TicTacToePiece (X or Y) if there is a winner.
     *	Hint: use the helper methods: checkRowsForWinner(), checkColsForWinner(), and checkDiagsForWinner()
     */
    public TicTacToePiece getWinner()
    {
    	TicTacToePiece ret = null;
    	
    	ret = checkRowsForWinner();
    	if(ret != null) return ret;
    	
    	ret = checkColsForWinner();
    	if(ret != null) return ret;
    	
    	ret = checkDiagsForWinner();
    	if(ret != null) return ret;
    	
    	return null;
    }
    
    /*
     *	Return true if there is a winner or if there are no empty spaces left on the board
     *	Otherwise, return false
     */
    public boolean isGameOver()
    {
    	return !hasEmptySpace() || getWinner() != null;
    }
    
    //HELPER METHODS
    /*
     *	If a, b, and c are all the same TicTacToe piece, then return that piece
     *	Otherwise, return null
     */
    private TicTacToePiece checkForWinner(TicTacToePiece a, TicTacToePiece b, TicTacToePiece c)
    {
    	if(a == b && b == c)
    		return a;
    	return null;
    }
    
    /*
     *	Use the checkForWinner() helper method to check each of the 3 rows for a winner
     *	Return the first non-null winner that is found (starting from row 0)
     *	If no non-null winners are found, return null
     */
    private TicTacToePiece checkRowsForWinner()
    {
    	TicTacToePiece ret = null;
    	
    	for(int r=0; r<3; r++)
    	{
    		ret = checkForWinner(board[r][0], board[r][1], board[r][2]);
    		if(ret != null)
    			return ret;
    	}
    	
    	return ret;
    }
    
    /*
     *	Use the checkForWinner() helper method to check each of the 3 columns for a winner
     *	Return the first non-null winner that is found (starting from column 0)
     *	If no non-null winners are found, return null
     */
    private TicTacToePiece checkColsForWinner()
    {
    	TicTacToePiece ret = null;
    	
    	for(int c=0; c<3; c++)
    	{
    		ret = checkForWinner(board[0][c], board[1][c], board[2][c]);
    		if(ret != null)
    			return ret;
    	}
    	
    	return ret;
    }
    
    /*
     *	Use the checkForWinner() helper method to check both of the diagonals for a winner
     *	Check the top left -> bottom right diagonal first
     *	Check the top right -> bottom left diagonal second
     *	Return the first non-null winner that is found
     *	If no non-null winners are found, return null
     */
    private TicTacToePiece checkDiagsForWinner()
    {
    	TicTacToePiece ret = null;
    	
    	ret = checkForWinner(board[0][0], board[1][1], board[2][2]);
		if(ret != null) return ret;
    	
    	ret = checkForWinner(board[2][0], board[1][1], board[0][2]);
		if(ret != null) return ret;
    	
    	return ret;
    }
    
    
}