/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanproject;

import java.io.FileNotFoundException;

/**
 *
 * @author arthur
 */
public interface BoardBuilder {
    Board build(String path)throws FileNotFoundException ;   
}
