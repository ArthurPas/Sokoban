package sokobanproject;

import java.util.Scanner;

/**
 *
 * @author apascal002
 */
public class KeyboardEntry {
    static Scanner in = new Scanner(System.in);
    
    /**
     * Read the line entered by the user
     * @return
     */
    public static String readLine() {
        return in.nextLine().trim();
    }
    
    public static boolean badEntry(String theEntry){
        if(!theEntry.contains(Directions.D.toString()) || 
                !theEntry.contains(Directions.R.toString()) ||
                !theEntry.contains(Directions.U.toString()) ||
                !theEntry.contains(Directions.L.toString()))
        {
            return false;
        }
        return true;
    }
}
/*!theEntry.contains(Directions.R.toString())) )||(
            !theEntry.contains(Directions.U.toString()))||(
            !theEntry.contains(Directions.L.toString())){*/