package fiskehartfinalproject;

import javax.swing.*;

/**
 * Inky is one of the four ghosts that move sporadically around the map. 
 * Inky is the cyan ghost. Inky is by far the smartest ghost (not really) and he
 * tries his absolute best to hunt down Pacman with his elevated mindset. (In
 * reality he is just as clueless as the rest of the ghosts, but don't tell him 
 * that.)
 * 
 * Each ghost has four unique icons to visually represent which direction they 
 * are moving.
 * 
 * @author Riley Fiske & Evan Hart
 */

public class Inky extends Ghost
{
    //initializes instance variables
    public static final Icon inkyIcon_W = new ImageIcon("src\\fiskehartfinalproject\\images\\inky_w.png");
    public static final Icon inkyIcon_A = new ImageIcon("src\\fiskehartfinalproject\\images\\inky_a.png");
    public static final Icon inkyIcon_S = new ImageIcon("src\\fiskehartfinalproject\\images\\inky_s.png");
    public static final Icon inkyIcon_D = new ImageIcon("src\\fiskehartfinalproject\\images\\inky_d.png");
    public static Icon currentInkyIcon = inkyIcon_D;
    
    // Creates the Inky object to be implemented in the Tester class.
    public Inky(int startingCharacterType, Map newMap, int startRow, int startColumn )
    {
        super(startingCharacterType, newMap, startRow, startColumn);
    }
    
    // Figures out which direction Inky is moving and sets the icon correspondingly.
    @Override
    public void findIcon()
    {
        if(oldCell.getRow() + 1 == newCell.getRow())
        {
            setIcon(inkyIcon_S);
        }
        else if(oldCell.getRow() - 1 == newCell.getRow())
        {
            setIcon(inkyIcon_W);
        }
        else if(oldCell.getCol() + 1 == newCell.getCol())
        {
            setIcon(inkyIcon_D);
        }
        else if(oldCell.getCol() - 1 == newCell.getCol())
        {
            setIcon(inkyIcon_A);
        }
    }
    
    // Allows the findIcon method to set the correct icon for whichever direction Inky is moving.
    @Override
    public void setIcon(Icon i)
    {
        currentInkyIcon = i;
    }
}