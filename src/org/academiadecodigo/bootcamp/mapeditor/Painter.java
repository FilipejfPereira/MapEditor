package org.academiadecodigo.bootcamp.mapeditor;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.File;


public class Painter implements KeyboardHandler {
    private int col = 0;
    private int row = 0;
    //private Rectangle rectangle;
    private Cell cell;
    private MapEditorGrid grid;



    public Painter(Color color, MapEditorGrid grid){
    cell = new Cell(0,0,grid.getCellSize(),Color.GREEN);
    this.grid = grid;

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();
        switch (key) {
            case KeyboardEvent.KEY_LEFT:
                if (col > 0) {
                    cell.getRectangle().translate(-1 * grid.getCellSize(), 0);
                    col -= 1;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (col < grid.getCols()) {
                    cell.getRectangle().translate(1 * grid.getCellSize(), 0);
                    col += 1;
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (row > 0) {
                    cell.getRectangle().translate(0, -1 * grid.getCellSize());
                    row -= 1;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (row < grid.getRows()) {
                    cell.getRectangle().translate(0, 1 * grid.getCellSize());
                    row += 1;
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                grid.painter(col, row);
                break;
            case KeyboardEvent.KEY_S:
                grid.SaveDataToFile(new File("resources/SavedData.txt"));

                break;
            case KeyboardEvent.KEY_L:

                    grid.LoadDataFromFile("resources/SavedData.txt");


        }
    }




    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void init(){

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUp);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);

        KeyboardEvent eventSpace = new KeyboardEvent();
        eventSpace.setKey(KeyboardEvent.KEY_SPACE);
        eventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventSpace);

        KeyboardEvent eventS = new KeyboardEvent();
        eventS.setKey(KeyboardEvent.KEY_S);
        eventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventS);

        KeyboardEvent eventL = new KeyboardEvent();
        eventL.setKey(KeyboardEvent.KEY_L);
        eventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventL);

    }




}
