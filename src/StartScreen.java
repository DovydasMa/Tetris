import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends javax.swing.JFrame
{
    private  BoardPanel bPanel;

    public StartScreen()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setMinimumSize(new Dimension(800, 600));
        bPanel = new BoardPanel();
        this.setContentPane(bPanel);

        bPanel.menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuButtonActionPerformed(e);
            }
        });

        initControls();
        StartGame();
    }

    public void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
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
                bPanel.getBoard().moveBlockRight();
            }
        });
        am.put("left",  new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bPanel.getBoard().moveBlockLeft();
            }
        });
        am.put("down",  new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bPanel.getBoard().dropBlock();
            }
        });
        am.put("up",  new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bPanel.getBoard().rotateBlock();
            }
        });
    }

    public void StartGame(){
        new GameThread(bPanel.getBoard()).start();
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