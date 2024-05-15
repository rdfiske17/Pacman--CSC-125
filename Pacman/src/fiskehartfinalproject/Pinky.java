package fiskehartfinalproject;

import javax.swing.*;


/**
 * Pinky is one of the four ghosts that move sporadically around the map. 
 * Pinky is the pink ghost. Pinky doesn't hate Pacman, but she actually really likes him.
 * Pinky simply wants to go give him a hug, but unfortunately she doesn't have a 
 * brain or any higher thinking skills, so Pinky just runs around till she finds him!
 * 
 * Each ghost has four unique icons to visually represent which direction they 
 * are moving.
 * 
 * @author Riley Fiske & Evan Hart
 */

public class Pinky extends Ghost
{
    //initializes instance variables
    public static final Icon pinkyIcon_W = new ImageIcon("src\\fiskehartfinalproject\\images\\pinky_w.png");
    public static final Icon pinkyIcon_A = new ImageIcon("src\\fiskehartfinalproject\\images\\pinky_a.png");
    public static final Icon pinkyIcon_S = new ImageIcon("src\\fiskehartfinalproject\\images\\pinky_s.png");
    public static final Icon pinkyIcon_D = new ImageIcon("src\\fiskehartfinalproject\\images\\pinky_d.png");
    public static Icon currentPinkyIcon = pinkyIcon_D;
    
    // Creates the Inky object to be implemented in the Tester class.
    public Pinky(int startingCharacterType, Map newMap, int startRow, int startColumn )
    {
        super(startingCharacterType, newMap, startRow, startColumn);
    }
    
    // Figures out which direction Pinky is moving and sets the icon correspondingly.
    @Override
    public void findIcon()
    {
        if(oldCell.getRow() + 1 == newCell.getRow())
        {
            setIcon(pinkyIcon_S);
        }
        else if(oldCell.getRow() - 1 == newCell.getRow())
        {
            setIcon(pinkyIcon_W);
        }
        else if(oldCell.getCol() + 1 == newCell.getCol())
        {
            setIcon(pinkyIcon_D);
        }
        else if(oldCell.getCol() - 1 == newCell.getCol())
        {
            setIcon(pinkyIcon_A);
        }
    }
    
    // Allows the findIcon method to set the correct icon for whichever direction Pinky is moving.
    @Override
    public void setIcon(Icon i)
    {
        currentPinkyIcon = i;
    }
}