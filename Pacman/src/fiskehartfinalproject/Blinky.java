package fiskehartfinalproject;

import javax.swing.*;

/**
 * Blinky is one of the four ghosts that move sporadically around the map. 
 * Blinky is the red ghost. His sole objective is to KILL PACMAN through whatever
 * means possible, or he might just kinda run around until he accidentally 
 * bumps into him.
 * 
 * Each ghost has four unique icons to visually represent which direction they 
 * are moving.
 * 
 * @author Riley Fiske & Evan Hart
 */

public class Blinky extends Ghost
{
    //initializes instance variables
    public static final Icon blinkyIcon_W = new ImageIcon("src\\fiskehartfinalproject\\images\\blinky_w.png");
    public static final Icon blinkyIcon_A = new ImageIcon("src\\fiskehartfinalproject\\images\\blinky_a.png");
    public static final Icon blinkyIcon_S = new ImageIcon("src\\fiskehartfinalproject\\images\\blinky_s.png");
    public static final Icon blinkyIcon_D = new ImageIcon("src\\fiskehartfinalproject\\images\\blinky_d.png");
    public static Icon currentBlinkyIcon = blinkyIcon_D;
    
    // Creates the Inky object to be implemented in the Tester class.
    public Blinky(int startingCharacterType, Map newMap, int startRow, int startColumn )
    {
        super(startingCharacterType, newMap, startRow, startColumn);
    }
    
    // Figures out which direction Blinky is moving and sets the icon correspondingly.
    @Override
    public void findIcon()
    {
        if(oldCell.getRow() + 1 == newCell.getRow())
        {
            setIcon(blinkyIcon_S);
        }
        else if(oldCell.getRow() - 1 == newCell.getRow())
        {
            setIcon(blinkyIcon_W);
        }
        else if(oldCell.getCol() + 1 == newCell.getCol())
        {
            setIcon(blinkyIcon_D);
        }
        else if(oldCell.getCol() - 1 == newCell.getCol())
        {
            setIcon(blinkyIcon_A);
        }
    }
    
    // Allows the findIcon method to set the correct icon for whichever direction Blinky is moving.
    @Override
    public void setIcon(Icon i)
    {
        currentBlinkyIcon = i;
    }
    
 
}