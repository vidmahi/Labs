import mayflower.*;

public class PieceActor extends Actor
{
    //INSTANCE VARIABLES
    
    TicTacToe myGame;
    int r;
    int c;
    
    //CONSTRUCTOR
    public PieceActor(TicTacToe game, int row, int col) 
    {
        //Initialize instance variables here
        
        myGame = game;
        r = row;
        c= col;
        
        //Set this Actor's image. Blank pieces should display the empty.png image!
        
        setPicture("img/test.png");
    }
    
    //METHODS
    /*
     *    Checks if this piece is clicked using the isClicked() method
     *    If it is clicked then:
     *        1. Check if the game is over. No pieces can be played if the game is over.
     *        1. Check if this is an empty piece. Pieces cannot be played on top of other pieces.
     *        2. Make this PieceActor display the current player's piece.
     *        3. Tell the game to put the current player's piece in the correct row,col using the addPiece() method.
     *        3. Tell the game it is the next player's turn using the nextPlayer() method.
     */
    public void update()
    {
        if (isClicked())
        {
            //System.out.println("entered isclicked");
            if (myGame.isGameOver())
            {
                
            }
            else
            {
                //System.out.println("entered else game not over");
                //System.out.println("getpiece = " + myGame.getPiece(r,c));
                if(myGame.getPiece(r,c) == null)
                {
                    //System.out.println("currentplayer = "+ myGame.getCurrentPlayer());
                    if (myGame.getCurrentPlayer() == TicTacToePiece.X)
                    {
                        setPicture("img/x.png");
                        myGame.addPiece(r,c);
                        myGame.nextPlayer();
                    }
                    else
                    {
                        setPicture("img/o.png");
                        myGame.addPiece(r,c);
                        myGame.nextPlayer();
                    }
                }
                else
                {
                
                }
            }
        }
    }
}

