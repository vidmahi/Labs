import mayflower.*;


//TODO:
/*
 *    1. Store the TicTacToeClient constructor parameter in an instance variable
 *    2. The update method should check if this piece is clicked and then send a request to "play [row] [col]" to the server
 *    3. Implement the setPiece method to change the picture this PieceActor is displaying
 */
public class PieceActor extends Actor
{
    //INSTANCE VARIABLES
    int row, col;
    
    TicTacToeClient myGame;
    
    //CONSTRUCTOR
    //NEW
    public PieceActor(TicTacToeClient client, int row, int col) 
    {
        //TODO: store the client parameter in an instance variable
        
        myGame = client;
        
        //Initialize instance variables here
        this.row = row;
        this.col = col;
        
        //Set this Actor's image. Blank pieces should display the blank.png image!
        setPicture("img/empty.png");
    }
    
    //METHODS
    /*
     *    Checks if this piece is clicked using the isClicked() method
     *    If it is clicked then:
     *        1. Send a request to the server to "play [row] [col]"
     */
    public void update()
    {
        //TODO: implement this method
        
        if(this.isClicked())
        {
            myGame.send("play " + row + " " + col);
        }
        
    }
    
    /*
     *    Use the setPicture method to change this PieceActor's image to X or O as specified by the parameter
     */
    public void setPiece(TicTacToePiece piece)
    {
        System.out.println("Setting piece " + row + ", " + col + " to " + piece);    //useful output for debugging
        if (piece == TicTacToePiece.X)
        {
            setPicture("img/x.png");
        }
        else
        {
            setPicture("img/o.png");
        }
    }
}
