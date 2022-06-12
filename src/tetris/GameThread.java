import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread {

    private Board board;

    public GameThread(Board board) {
        this.board = board;

    }

    @Override
    public void run() {
        while (true)
        {

            board.spawnBlock();
            while( board.moveBlockDown() == true )
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }
    }
}