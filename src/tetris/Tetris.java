public class Tetris {
    private static StartScreen ss;
    private static MainMenu mm;

    public static void start() {
        ss.setVisible(true);
        ss.StartGame();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                ss = new StartScreen();
                mm = new MainMenu();
                mm.setVisible(true);
            }
        });
    }
}
