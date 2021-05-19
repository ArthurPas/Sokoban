/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanproject;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author arthur
 */
public interface BoardBuilder {
    Board build(ArrayList<String> stringRow)throws FileNotFoundException ;   
}
