import mayflower.*;
import mayflower.net.*;
import java.util.Scanner;

public class TicTacToeClient extends Client
{
    //instance variables :D
    //testing git branches
    private TicTacToeStage stage;
    private TicTacToe game;

    public TicTacToeClient() 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Use localhost to connect to a server running on your computer.");
        //System.out.print("IP Address > ");
        //String ip = in.next();
        String ip = "localhost";
        
        //System.out.print("Port > ");
        //int port = in.nextInt();
        int port = 1234;                //default server port
        
        System.out.println("Connecting...");
        connect(ip, port);            //connect to the server at the specified ip and port
    }
    
    /*
     *    Messages:
     *        youare [piece]
     *        addpiece [row] [col]
     *        winner disconnect
     *        error [message...]
     */
    public void process(String message)
    {
        //output the message recieved from the server. This is useful for debugging
        System.out.println("Message from server: " + message);
        
        //split message into an array of Strings separated by space characters
        //    "addpiece 1 2" would become the array ["addpiece", "1", "2"]
        String[] parts = message.split(" ");
        
        
        TicTacToePiece youAre;
        
        
        //use the first value in the array as the "command"
        //use if statements to determine which command to process
        if("youare".equals(parts[0]))
        {
            //TODO:
            //parts[1] contains "X" or "O", this is your piece
            //1. Create a TicTacToePiece variable to store your piece
            //2. Create a new TicTacToe game and store it in the game instance variable
            //3. Create a new TicTacToeStage and pass it this client, the game, and your piece
            //4. create a new Mayflower object with the stage you just created. This will open the GUI and start the game
            
            
            if(parts[1].equals("X"))
            {
                youAre = TicTacToePiece.X;
            }
            else if (parts[1].equals("O"))
            {
                youAre = TicTacToePiece.O;
            }
            else
                youAre = null;
            
            System.out.println("youare = " + youAre);
            
            
            game = new TicTacToe();
            
            
            stage = new TicTacToeStage(this, game, youAre);
            
            
            new Mayflower("TicTacToe", 800, 600, stage);
            
            
        }
        else if("addpiece".equals(parts[0]))
        {
            //TODO:
            //parts[1] contains the row
            //parts[2] contains the column
            //1. add a piece to the game at the specified (row, col)
            //2. tell the game it is the next player's turn
            //3. tell the stage to update the piece at (row, col) to the correct type (X or O) depending on which piece was just added to (row, col)
            
        
            game.addPiece(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            stage.updatePiece(game.getPiece(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            game.nextPlayer();
        }
        else if("error".equals(parts[0]))
        {
            //Output the error message sent from the server
            System.out.println(message);
        }
        else if("winner".equals(parts[0]))
        {
            //Congratulations, you win becuase you opponent quit!
            System.out.println("Opponent disconnected. You win!");
        }
        
    }
    
    public void onDisconnect(String message)
    {
        System.out.println("Disconnected from server.");
    }
    
    public void onConnect()
    {
        System.out.println("Connected!");
    }
    
    
}
