package fiskehartfinalproject;

import javax.swing.*;


/**
 * The Ghost class is the original class that all of the unique ghost classes stem from.
 * This is to allow variability between the vulnerableGhost image icon (for when Pacman
 * collects a superOrb) and the regular ghost icons.
 *
 * @author Riley Fiske & Evan Hart
 */

public class Ghost extends Character
{
    // Initializes instance variables
    public static final Icon vulnerableGhost = new ImageIcon("src\\fiskehartfinalproject\\images\\vulnerableGhost.png");
    public static Icon currentGhostIcon;
    
    // Creates the Ghost object to be implemented in the Tester class.
    public Ghost(int startingCharacterType, Map newMap, int startRow, int startColumn )
    {
        super(startingCharacterType, newMap, startRow, startColumn); 
    }

}