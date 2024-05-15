package fiskehartfinalproject;

import javax.swing.*;

/**
 * The Pacman Class initializes and sets up all things related to the player-
 * controlled character. 
 * 
 * Pacman is the big yellow ball with a mouth that moves around the map to collect
 * a bunch of orbs for whatever reason. I think he might be hungry? Who knows.
 * 
 * @author Riley Fiske & Evan Hart
 */

public class Pacman extends Character
{
    //Initializes instance variables
    public static int horizontalMove = possibleMoves[1][0];
    public static int verticalMove = possibleMoves[1][1];
    public static final Icon pacmanIcon_W = new ImageIcon("src\\fiskehartfinalproject\\images\\pacman_w.png");
    public static final Icon pacmanIcon_A = new ImageIcon("src\\fiskehartfinalproject\\images\\pacman_a.png");
    public static final Icon pacmanIcon_S = new ImageIcon("src\\fiskehartfinalproject\\images\\pacman_s.png");
    public static final Icon pacmanIcon_D = new ImageIcon("src\\fiskehartfinalproject\\images\\pacman_d.png");
    public static Icon currentPacmanIcon = pacmanIcon_D;
    
    // Creates the Pacman object to be implemented in the Tester class.
    public Pacman(int startingCharacterType, Map newMap, int startRow, int startColumn )
    {
        super(startingCharacterType, newMap, startRow, startColumn);
    }
   
   /**
    * Makes Pacman move in a certain direction until he receives another order to
    * move. Additionally, it sets the correct image icon to correspond with whichever 
    * direction Pacman is moving in.
    */
   public void setDirection(char x)
   {
       
        switch (x) {
            case 'w':
                setIcon(pacmanIcon_W);
                setVerticalMoveDirection(possibleMoves[3][1]);
                setHorizontalMoveDirection(possibleMoves[3][0]);
                break;
            case 'a':
                setIcon(pacmanIcon_A);
                setHorizontalMoveDirection(possibleMoves[0][0]);
                setVerticalMoveDirection(possibleMoves[0][1]);
                break;
            case 's':
                setIcon(pacmanIcon_S);                
                setVerticalMoveDirection(possibleMoves[2][1]);
                setHorizontalMoveDirection(possibleMoves[2][0]);
                break;
            case 'd':
                setIcon(pacmanIcon_D);
                setHorizontalMoveDirection(possibleMoves[1][0]);
                setVerticalMoveDirection(possibleMoves[1][1]);
                break;
            default:
                break;
        }
    }
   
    // Sets the vertical direction for Pacman to continually move until he recieves another
    // order to move.
    public void setVerticalMoveDirection(int ii)
    {
        verticalMove = ii;
    }
    
    // Sets the horizontal direction for Pacman to continually move until he recieves another
    // order to move.
    public void setHorizontalMoveDirection(int jj)
    {
        horizontalMove = jj;
    }
    
    // Allows the findIcon method to set the correct icon for whichever direction Pacman is moving.
    public void setIcon(Icon i)
    {
        currentPacmanIcon = i;
    }
}