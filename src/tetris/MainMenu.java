import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private MainMenuPane menu;

    public MainMenu()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setMinimumSize(new Dimension(800, 600));
        menu = new MainMenuPane();
        setContentPane(menu);
    }

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
}
