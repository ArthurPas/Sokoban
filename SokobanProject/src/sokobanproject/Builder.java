/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arthur
 */
public class Builder implements BoardBuilder {

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    public ArrayList<String> readFile(String path) throws FileNotFoundException {
        ArrayList<String> row = new ArrayList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                row.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return row;
    }

    public Type convertion(char c) {
        Type theType;
        switch (c) {
            case '#':
                theType = Type.WALL;
                break;
            case 'P':
                theType = Type.PLAYER;
                break;
            case '.':
                theType = Type.EMPTY;
                break;
            case 'C':
                theType = Type.BOX;
                break;
            case 'x':
                theType = Type.TARGET;
                break;
            default:
                theType = Type.EMPTY;
                break;
        }
        return theType;
    }

    /**
     *
     * @param path
     * @param stringRow
     * @return
     * @throws FileNotFoundException
     */
    @Override
    public Board build(ArrayList<String> stringRow) throws FileNotFoundException {
        String boardName = stringRow.get(0);
        int nbCol = stringRow.get(1).length();
        int nbRow = stringRow.size() - 1;
        Board b = new Board(boardName, nbCol, nbRow);
        b.fillBoard();
        for (int col = 0; col < nbCol; col++) {
            for (int row = 0; row < nbRow; row++) {
                b.listPositions[col][row].type = convertion(stringRow.get(row + 1).charAt(col));
            }
        }
        return b;
    }
}
