import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel{
    private JPanel panel1;
    public JButton menuButton;
    private Board board;
    private JTextField score0TextField;
    private JTextField level1TextField;

    public BoardPanel() {
        this.setBounds(0, 0, 800, 600);
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        this.add(panel1);
    }

    public Board getBoard() {
        return this.board;
    }

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new BoardPanel().setVisible(true);
            }
        });
    }
}
