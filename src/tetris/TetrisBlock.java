import java.awt.*;

public class TetrisBlock {

    private int[][] shape;
    private Color color;
    private int height;
    private int width;
    private int x=0 ;
    private int y=0 ;



    public TetrisBlock(int shape[][], Color color) {

        this.shape = shape;
        this.color = color;
        height = shape.length;
        width = shape[0].length;

    }


    public void spawn( int gridWidth){

        y = -getHeight();
        x = (gridWidth - getWidth()) / 2 ;
    }

    public int[][] getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void  moveDown(){
        y++;
    }

    public void  moveLeft(){
        x--;
    }
    public void  moveRight(){
        x++;
    }
    public void rotate(){


    }


    public int getBottomEdge(){
        return y + getHeight();
    }
    public int getLeftEdge(){
        return x;
    }
    public  int getRightEdge(){
        return x + getWidth();
    }


}