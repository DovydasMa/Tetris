import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    private TetrisBlock block;
    private Color[][] background;

    public Board()
    {


        this.setBounds(40, 20, 500, 500);
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        setGridColumns(10);
        setGridCellSize(this.getBounds().width / getGridColumns());
        setGridRows(15);

        background = new Color[gridRows][gridColumns];
    }

    private void setGridRows(int size) { this.gridRows = size; }
    private void setGridColumns(int size) { this.gridColumns = size; }
    private void setGridCellSize(int size) { this.gridCellSize = size; }
    private int getGridRows() { return this.gridRows; }
    private int getGridColumns() { return this.gridColumns; }
    private int getGridCellSize() { return this.gridCellSize; }

    public void spawnBlock(){
        /*some other shapes
        int[][]{{1, 0}, {1, 0}, {1, 0}, {1, 0}}
        int[][]{{1, 1}, {1, 1}};
        int[][]{{1, 0}, {1, 1}, {1, 0}};
        int[][]{{0, 1}, {1, 1}, {1, 0}};
        */

        block = new TetrisBlock( new int[][] { {1, 0},{1, 0}, {1, 1} }, Color.red );
        block.spawn(gridColumns);
    }
    public boolean moveBlockDown(){

        if (checkBottom() == false)
        {
            moveBlockToBackground();
            return false;
        }

        block.moveDown();
        repaint();

        return true;
    }
    public void moveBlockRight(){
        if(block == null)
            return;
        if(!checkRight())
            return;

        block.moveRight();
        repaint();
    }
    public void moveBlockLeft(){
        if(block == null)
            return;
        if(!checkLeft())
            return;

        block.moveLeft();
        repaint();
    }
    public void dropBlock(){

        while( checkBottom() ){

            block.moveDown();
        }
        repaint();


    }
    public void rotateBlock(){
        block.rotate();

    }

    private boolean checkBottom(){
        if(block.getBottomEdge() == gridRows-5){
            return false;
        }

        int[][]shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();

        for(int col = 0; col < w; col++){
            for(int row = h - 1; row >= 0; row--){
                if(shape[row][col] != 0){
                    int x = col + block.getX();
                    int y = row + block.getY() + 1;
                    if(y < 0) break;
                    if(background[y][x] != null)
                        return false;
                    break;
                }
            }
        }

        return true;
    }
    private boolean checkLeft(){
        if(block.getLeftEdge() == 0){
            return false;
        }
        int[][]shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();

        for(int row = 0; row < h; row++){
            for(int col = 0; col < w; col++){
                if(shape[row][col] != 0){
                    int x = col + block.getX() - 1;
                    int y = row + block.getY();
                    if(y < 0)
                        break;
                    if(background[y][x] != null)
                        return false;
                    break;
                }
            }
        }
        return true;
    }
    private boolean checkRight(){
        if(block.getRightEdge() == gridColumns){
            return false;
        }
        int[][]shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();

        for(int row = 0; row < h; row++){
            for(int col = w - 1; col >= 0; col--){
                if(shape[row][col] != 0){
                    int x = col + block.getX() + 1;
                    int y = row + block.getY();
                    if(y < 0)
                        break;
                    if(background[y][x] != null)
                        return false;
                    break;
                }
            }
        }
        return true;
    }

    private void moveBlockToBackground()
    {
        int[][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();

        int xPos = block.getX();
        int yPos = block.getY();

        Color color = block.getColor();

        for(int r = 0; r < h; r++)
        {
            for (int c = 0; c < w; c++)
            {
                if(shape[r][c] == 1)
                {
                    background[r + yPos][c + xPos] = color;
                }
            }
        }
    }

    private void drawBlock(Graphics g)
    {
        if(block != null) {
            for (int row = 0; row < block.getHeight(); row++) {
                for (int col = 0; col < block.getWidth(); col++) {
                    if (block.getShape()[row][col] == 1)    //if element of block at current position colored, draw it
                    {
                        //draws tetriminoes
                        int x = (block.getX() + col) * gridCellSize;
                        int y = (block.getY() + row) * gridCellSize;


                        drawGridSquare(g, block.getColor(), x, y);
                    }
                }
            }
        }
    }

    private void drawBackground(Graphics g)
    {
        Color color;
        for(int r = 0; r < gridRows; r++)
        {
            for (int c = 0; c < gridColumns; c++)
            {
                color = background[r][c];

                if(color != null)
                {
                    int x = c * gridCellSize;
                    int y = r * gridCellSize;

                    drawGridSquare(g, color, x, y);

                }
            }

        }
    }

    private void drawGridSquare(Graphics g, Color color, int x, int y)
    {
        g.setColor(color);
        g.fillRect(x, y, gridCellSize, gridCellSize);
        g.setColor(Color.black);
        g.drawRect(x, y, gridCellSize, gridCellSize);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawBackground(g);
        drawBlock(g);
    }

    public int clearLines(){
        boolean lineFilled;
        int linesCleared = 0;
        for(int r = gridRows - 1; r >= 0; r--){
            lineFilled = true;
            for(int c = 0; c < gridColumns; c++){
                if(background[r][c] == null){
                    lineFilled = false;
                    break;
                }
            }
            if(lineFilled){
                linesCleared++;
                clearLine(r);
                shiftDown(r);
                clearLine(0);
                r++;
                repaint();
            }
        }
        return linesCleared;
    }
    private void clearLine(int r){
        for(int i = 0; i < gridColumns; i++){
            background[r][i] = null;
        }
    }
    private void shiftDown(int r){
        for(int row = r; row > 0; row--){
            for(int col = 0; col < gridColumns; col++){
                background[row][col] = background[row - 1][col];
            }
        }
    }
}