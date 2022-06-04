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
    }

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Tetris.start();
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
