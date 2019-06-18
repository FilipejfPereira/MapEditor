package org.academiadecodigo.bootcamp.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.io.Serializable;

public class Cell implements Serializable {

    private int col;
    private int row;
    private Rectangle rectangle;
    private boolean painted = false;
    private Color color;


    public Cell (int col, int row,int cellSize){
        this.col = col;
        this.row = row;
        rectangle = new Rectangle(col*cellSize,row*cellSize,cellSize,cellSize);
        rectangle.fill();
        rectangle.draw();
    }

    public Cell (int col, int row,int cellSize,Color color){
        this.col = col;
        this.row = row;
        rectangle = new Rectangle(col*cellSize,row*cellSize,cellSize,cellSize);
        rectangle.setColor(color);

        rectangle.draw();
        rectangle.fill();
    }


        public void paintItself(){
            if(!painted){
                setPainted(true);
                rectangle.setColor(Color.BLUE);
                rectangle.draw();
                rectangle.fill();
            }else{
                setPainted(false);
                rectangle.setColor(Color.BLACK);
                rectangle.draw();


            }
}

    public void moveDirection(int dir){


    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public boolean isPainted() {
        return painted;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
