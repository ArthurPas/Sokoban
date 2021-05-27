/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanproject;

import sokobanproject.playermanager.KeyboardEntry;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;


/**
 *
 * @author apascal002
 */
public class KeyboardEntryTest {
    
    /**
     *
     */
    @Test
    public void testBadEntry(){
        String trueTest = "LURD";
        String falseTest = "vim";
        assertTrue(KeyboardEntry.badEntry(trueTest));
        assertFalse(KeyboardEntry.badEntry(falseTest));
    }
    
}
