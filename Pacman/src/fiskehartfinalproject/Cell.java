package fiskehartfinalproject;

import javax.swing.*;
import java.awt.*;

/*
 * "The purpose of class is to ensure the proper functionality of the cell and to make it interactive" - ndaxvig
 *  Cell also can contain icons depeding if an orb, super orb, or nothing is upon it
 *  as well as hold characters on it when they move upon it.
 *
 *  @author Riley Fiske & Evan Hart
 */

public class Cell
{

    public static final Color WALL_COLOR = Color.BLACK;
    public static final Color EMPTY_COLOR = Color.GRAY;
    public static final Icon orbIcon = new ImageIcon("src\\fiskehartfinalproject\\images\\orb.png");
    public static final Icon superOrbIcon = new ImageIcon("src\\fiskehartfinalproject\\images\\superOrb.png");
    public static final Icon transparent = new ImageIcon("src\\fiskehartfinalproject\\images\\transparent.png");

        
    private JButton button;
    private boolean occupied;
    private boolean isWallCell;//indicating whether the cell is a wall or if free for people to be on.
    private final int row;
    private final int col;
    private Character currentCharacter;
    private boolean pacmanHasBeenHere;
    
    /**
     * Cell constructor constructs a Cell and checks if its a wall or not, paints
     * the background the corresponding color, then checks if it should have an
     * orb on it or not and displays the corresponding icon.
     * 
     * @param rr row
     * @param cc column 
     * @param wallCell if it is a wallCell or not
     */
    public Cell(int rr, int cc, boolean wallCell)
    {
        row = rr;
        col = cc;
        occupied = false;
        pacmanHasBeenHere = false;
        isWallCell = wallCell;
        button = new JButton();
        button.setPreferredSize(new Dimension(Map.CELL_SIZE,Map.CELL_SIZE));
        button.setMargin(new Insets(0,0,0,0));
        if(isWallCell == true)
        {
            button.setBackground(WALL_COLOR);
        }
        else
        {
            button.setBackground(EMPTY_COLOR);
            //puts a super orb on the four spots there should be super orbs
            if(rr == 3 && cc == 1 || rr == 23 && cc == 1 || rr == 3 && cc == 26 || rr == 23 && cc == 26)
            {
                button.setIcon(superOrbIcon);
            }
            //places orbs everywhere else but within the square around where the ghosts spawn
            else if(!(rr>=9 && rr<=19 && cc>=7 && cc<=20))
            {
                button.setIcon(orbIcon);
            }
            //pacmanHasBeenHere places no orbs when walked upon
            else
            {
                pacmanHasBeenHere = true;
            }

        }
        currentCharacter = null;
    }
    /**
     * Returns the button
     * @return button 
     */
    
    public JButton getButton() {
        return button;
    }
    
    /**
     * Returns the Icon on the button
     * @return Icon
     */
    
    public Icon getIcon()
    {
        return button.getIcon();
    }
    
    /**
     * Returns if the cell is available
     * @return if occupied
     */
    
    public boolean getAvailability(){
        return !occupied;
    }
    
    /**
     * Checks if a cell wall or not
     * @return if cell wall
     */
    
    public boolean isWallCell() {
        return isWallCell;
    }
    
    /**
     * Gets the cell's row
     * @return row
     */
    
    public int getRow() {
        return row;
    }

    /**
     * Gets the cell's column
     * @return column
     */
    
    public int getCol() {
        return col;
    }
    
    /**
     * Adds the character onto the cell visually with the currently assigned icon
     * for each type of Class
     * @param character Character in population
     */
    
    public void addCharacter(Character character)
    {
        currentCharacter = character;
        occupied = true;
        if(character instanceof Pacman)
        {
            pacmanMovedOn();
            button.setIcon(Pacman.currentPacmanIcon);
        }
        else if(character instanceof Blinky)
        {
            button.setIcon(Blinky.currentBlinkyIcon);
        }
        else if(character instanceof Inky)
        {
            button.setIcon(Inky.currentInkyIcon);
        }
        else if(character instanceof Pinky)
        {
            button.setIcon(Pinky.currentPinkyIcon);
        }
        else if(character instanceof Clyde)
        {
            button.setIcon(Clyde.currentClydeIcon);
        }
    }
    /**
     * Removes the character from the space and puts an orb down if Pacman hasn't
     * already been there.
     */
    
    public void removeCharacter()
    {
        currentCharacter = null;
        occupied = false;
        if(!pacmanHasBeenHere)
        {
            if(getRow() == 3 && getCol() == 1 || getRow() == 23 && getCol() == 1 || getRow() == 3 && getCol() == 26 || getRow() == 23 && getCol() == 26)
            {
                button.setIcon(superOrbIcon);
            }
            else
            {
                button.setIcon(orbIcon);
            }
            
        }
        else
        {
            button.setIcon(transparent);
        }
    }
    
    /**
     * Retrieves the current character on a cell
     * @return Character
     */
    
    public Character getCharacter()
    {
        return currentCharacter;
    }
    
    /**
     * sets pacmanHasBeenHere to true meaning an orb is no longer placeable on
     * the cell.
     */
    
    public void pacmanMovedOn()
    {
        pacmanHasBeenHere = true;
    }
}