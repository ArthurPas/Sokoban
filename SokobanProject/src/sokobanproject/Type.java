/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanproject;

/**
 *
 * @author apascal002
 */
public enum Type {
    BOX,
    EMPTY,
    PLAYER,
    TARGET,
    WALL;
    
    @Override
    public String toString(){
        String s = "";
        switch(this){
            case BOX:
                s = "C";
                break;
            case EMPTY:
                s = ".";
                break;
            case PLAYER:
                s = "P";
                break;
            case TARGET:
                s = "x";
                break;
            case WALL:
                s = "#";
                break;
        }
        return s;
    }
}
