import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPane extends JPanel {
    private JButton startGameButton;
    private JPanel panel1;
    private JButton quitGameButton;

    public MainMenuPane() {
        this.setBounds(40, 20, 500, 500);
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(panel1);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGameButtonActionPerformed(e);
            }
        });
        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitGameButtonActionPerformed(e);
            }
        });
    }

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Tetris.start();
    }

    private void quitGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new MainMenuPane().setVisible(true);
            }
        });
    }
}
