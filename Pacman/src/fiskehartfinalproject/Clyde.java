package fiskehartfinalproject;

import javax.swing.*;

/**
 * Clyde is one of the four ghosts that move sporadically around the map. 
 * Clyde is the orange ghost. Clyde honestly could care less if he catches Pacman,
 * he's really just here for the ride, man. Clyde's honestly just chillin' and he
 * doesn't have any other aspirations.
 * 
 * Each ghost has four unique icons to visually represent which direction they 
 * are moving.
 * 
 * @author Riley Fiske & Evan Hart
 */

public class Clyde extends Ghost
{
    //initializes instance variables
    public static final Icon clydeIcon_W = new ImageIcon("src\\fiskehartfinalproject\\images\\clyde_w.png");
    public static final Icon clydeIcon_A = new ImageIcon("src\\fiskehartfinalproject\\images\\clyde_a.png");
    public static final Icon clydeIcon_S = new ImageIcon("src\\fiskehartfinalproject\\images\\clyde_s.png");
    public static final Icon clydeIcon_D = new ImageIcon("src\\fiskehartfinalproject\\images\\clyde_d.png");
    public static Icon currentClydeIcon = clydeIcon_D;
    
    // Creates the Clyde object to be implemented in the Tester class.
    public Clyde(int startingCharacterType, Map newMap, int startRow, int startColumn )
    {
        super(startingCharacterType, newMap, startRow, startColumn);
    }
    
    // Figures out which direction Clyde is moving and sets the icon correspondingly.
    @Override
    public void findIcon()
    {
        if(oldCell.getRow() + 1 == newCell.getRow())
        {
            setIcon(clydeIcon_S);
        }
        else if(oldCell.getRow() - 1 == newCell.getRow())
        {
            setIcon(clydeIcon_W);
        }
        else if(oldCell.getCol() + 1 == newCell.getCol())
        {
            setIcon(clydeIcon_D);
        }
        else if(oldCell.getCol() - 1 == newCell.getCol())
        {
            setIcon(clydeIcon_A);
        }
    }
    
    // Allows the findIcon method to set the correct icon for whichever direction Clyde is moving.
    @Override
    public void setIcon(Icon i)
    {
        currentClydeIcon = i;
    }     
}