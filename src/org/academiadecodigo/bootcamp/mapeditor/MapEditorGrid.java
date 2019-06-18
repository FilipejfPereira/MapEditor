package org.academiadecodigo.bootcamp.mapeditor;


import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import javax.swing.*;
import java.io.*;

public class MapEditorGrid implements Serializable {
    private int cols;
    private int rows;
    private int cellSize = 35;
    private Rectangle rectangle;
    private Cell[][] cells;
    private Painter painter;




    public MapEditorGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        rectangle = new Rectangle(0,0,cols*cellSize,rows*cellSize);
        cells = new Cell[cols][rows];

    }



    public void init() {
        rectangle.draw();

        for(int col = 0; col < cols; col++){

            for(int row = 0; row < rows; row++){
                cells[col][row] = new Cell(col,row,cellSize);

            }
        }
        painter = new Painter(Color.GREEN, this);

}

        public void start(){
        painter.init();
}

        public void painter(int col, int row){

        cells[col][row].paintItself();


        }

    public void SaveDataToFile(File file){

    try{
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for(int col = 0; col < cols; col++) {

            for (int row = 0; row < rows; row++) {
                if(cells[col][row].isPainted()){
                    objectOutputStream.write(1);
                }else{
                    objectOutputStream.write(0);
                }

            }
        }
            objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    }



    public void LoadDataFromFile(String file) throws ClassCastException {

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            for(int col = 0; col < cols; col++) {

                for (int row = 0; row < rows; row++) {
                    if(objectInputStream.read() == 1){
                        cells[col][row].setPainted(false);
                    }else{
                        cells[col][row].setPainted(true);

                    }
                    cells[col][row].paintItself();
                }
            }


            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}



