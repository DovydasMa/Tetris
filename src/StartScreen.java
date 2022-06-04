import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartScreen extends javax.swing.JFrame
{

    private  Board board;
    public StartScreen()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setMinimumSize(new Dimension(600, 600));
        board = new Board();
        setContentPane(board);
        initControls();
        StartGame();
    }
    private void initControls(){
        InputMap im = this.getRootPane().getInputMap();
        ActionMap am = this.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("DOWN"), "down");
        im.put(KeyStroke.getKeyStroke("UP"), "up");



        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.moveBlockRight();
            }
        });
        am.put("left",  new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.moveBlockLeft();
            }
        });
        am.put("down",  new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.dropBlock();
            }
        });
        am.put("up",  new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.rotateBlock();
            }
        });
    }

    public void StartGame(){
        new GameThread(board).start();
    }

    @SuppressWarnings("unchecked")

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new StartScreen().setVisible(true);
            }
        });
    }
}