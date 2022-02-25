import mayflower.*;
import java.awt.Color;

//Find the Mayflower documentation here: http://mrmaycs.com/mayflower/

public class TicTacToeStage extends Stage
{
    //INSTANCE VARIABLES
    private TicTacToe game;
    private Text winner;
    private Text turn;
    private Text endScreen;
    
    //CONSTRUCTOR
    public TicTacToeStage() 
    {
        setBackground("img/background.png");
        
        game = new TicTacToe();
        
        //Add a label to the top of the screen that displays the name of the game
        Text title = new Text("Tic Tac Toe", Color.WHITE);
        addActor(title, 0, 0);
        
        winner = new Text("", Color.WHITE);
        turn = new Text("", Color.WHITE);
        endScreen = new Text("", Color.WHITE);
        
        //TODO: Add a "blank" PieceActor to each of the 9 spots of the TicTacToe board
        //        Each PieceActor needs a reference to the TicTacToe object
        
        int r = 150;
        int c = 150;
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                //addActor((new PieceActor(game, i, j)), i, j);
                addActor((new PieceActor(game, i, j)), r, c);
                
                //c +=100;
                c +=105;
            }
            //c +=150;
            //c += 100;;
            c = 150;
            r +=105;
        }
        
        //addActor(new PieceActor(), 150,150);
        
    }
    
    //METHODS
    /*
     *    Check if the game is over
     *        If the game is over, display the text "Game Over!" on the screen
     *        If there is a winner, display the text "X wins!" or "O wins!" on the screen
     *        If there is not a winner, display the text "Tie Game!" on the screen
     *  If the game is NOT over
     *        Display the current player's turn on the screen: "It is X's turn" or "It is O's turn"
     */
    public void update()
    {
        if (game.isGameOver())
        {
            //Text endScreen = new Text("Game Over!", Color.WHITE);
            endScreen.setText("Game Over!");
            addActor(endScreen, 200, 0);
            //turn.setText("");
            if (game.getWinner() == TicTacToePiece.X)
            {
                //Text winner = new Text("X Wins!", Color.WHITE);
                winner.setText("X Wins!");
                addActor(winner, 200, 30);
                
            }
            else if (game.getWinner() == TicTacToePiece.O)
            {
                //Text winner = new Text("O Wins!", Color.WHITE);
                winner.setText("O Wins!");
                addActor(winner, 200, 30);
                
            }
            else
            {
                //Text winner = new Text("Tie Game!", Color.WHITE);
                winner.setText("Tie Game!");
                addActor(winner, 200, 30);
                
            }
        }
        else
        {
            if (game.getCurrentPlayer() == TicTacToePiece.X)
            {
                //Text turn = new Text("It is X's turn", Color.WHITE);
                turn.setText("It is X's turn");
                addActor(turn, 0, 30);
            }
            else
            {
                //Text turn = new Text("It is O's turn", Color.WHITE);
                turn.setText("It is O's turn");
                addActor(turn, 0, 30);
            }
        }
    }
}
