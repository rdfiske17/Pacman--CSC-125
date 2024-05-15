package fiskehartfinalproject;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 * The Character Class contains the attributes of a character on the map. This
 * Character can move around in different ways depending on if it is a Pacman or
 * a Ghost, hold specific icons depending on the way it is moving, and have different
 * character types depending on if super orbs have been collected or not or if
 * Pacman is defeated.
 * 
 * @author Riley Fiske & Evan Hart
 */

public class Character
{
    protected Cell currentCell;
    protected Cell newCell;
    protected Cell oldCell;
    protected int characterType;
    protected Map map;

    //List of Character Type Constants
    public static final int pacman = 0;
    public static final int ghost = 1;
    public static final int munchable = 2; 
    public static final int deadPacman = 3;
    //public static final int deadGhost = 4;
    
    //Used for ghosts when munchable
    public static int munchableTicker;
    public static int genericMunchTimer = 75;


    public static final int[][] possibleMoves = {
        {-1,0},
        {1,0},
        {0,1},
        {0,-1}  
    };

    public static final Random randomNumberGenerator = new Random();

    /*
    * Constructor: creates a Character with a cell, map, coordinates on the map,
    * and a timer for long it is munchable if it is a Ghost
    */

    public Character(int startingCharacterType, Map newMap, int startRow, int startColumn )
    {
        currentCell = null;
        map = newMap;
        map.addCharacter(this,startRow,startColumn);
        munchableTicker = genericMunchTimer;
        characterType = startingCharacterType;
    }

    /**
    * Moves the Character randomly to one of the neighboring tiles if it is a
    * Ghost, moves the Character in the specified direction if a Pacman, and if
    * a Pacman and runs on a super orb, changes the character types of all the
    * ghosts to munchable for genericMunchTimer amount.
    */

    public void move()
    {
        //move for if not a Pacman, essentially the same as Citizen moving from Project8
        if(!(this instanceof Pacman))
        {
            ArrayList<Cell> availableCells = new ArrayList<Cell>();
            availableCells.add(currentCell);
            int row = currentCell.getRow();
            int col = currentCell.getCol();

            for(int[] possibleMove : possibleMoves)
            {
                int newRow = row + possibleMove[0];
                int newCol = col + possibleMove[1];

                if(newRow >= 0 && newRow < Map.NUMBER_OF_ROWS && newCol >= 0 && newCol < Map.NUMBER_OF_COLUMNS)
                {
                    Cell potentialCell = map.getCell(newRow, newCol);
                    if(potentialCell.getAvailability() && !potentialCell.isWallCell())
                    {
                        availableCells.add(potentialCell);
                    }
                }
            }

            int nn = availableCells.size();
            int randomIndex = randomNumberGenerator.nextInt(nn);
            oldCell = currentCell;
            newCell = availableCells.get(randomIndex);
            setCell(newCell);
            if(getCharacterType() == munchable)
            {
                
                setIcon(Ghost.vulnerableGhost);
            }
            else
            {
                findIcon();
            }
            oldCell.removeCharacter();
            newCell.addCharacter(this);
            //doesn't eat Pacman if munchable
            if(!(getCharacterType() == munchable))
            {
                eat();
            }
        }
        //specific move type for Pacman
        else
        {
            int row = currentCell.getRow();
            int col = currentCell.getCol();
            oldCell = currentCell;
            int newRow = row + Pacman.verticalMove;
            int newCol = col + Pacman.horizontalMove;
            Cell potentialCell = map.getCell(newRow, newCol);
            if(potentialCell.getAvailability() && !potentialCell.isWallCell() || !potentialCell.getAvailability() && !potentialCell.isWallCell() && potentialCell.getCharacter().getCharacterType() == munchable)
            {
                setCell(potentialCell);
                //if Pacman runs on a super orb it makes all the ghosts munchable
                if(potentialCell.getIcon() == Cell.superOrbIcon)
                {
                    for(Character cc : Tester.population)
                    {
                        if(cc instanceof Ghost)
                        {
                            cc.munchableTicker = genericMunchTimer;
                            cc.changeCharacterType(munchable);
                        }
                    }
                }
                oldCell.removeCharacter();
                //use try catch to remove the ghosts when eaten and add a new one back at the orignal spawn point
                try {
                    if(potentialCell.getCharacter().getCharacterType() == munchable)
                    {
                        if(potentialCell.getCharacter() instanceof Blinky)
                        {
                            Tester.population.remove(potentialCell.getCharacter());
                            Tester.population.add(new Blinky(Character.ghost, Tester.map1, 15, 14));
                            potentialCell.removeCharacter();
                        }
                        else if(potentialCell.getCharacter() instanceof Inky)
                        {
                            Tester.population.remove(potentialCell.getCharacter());
                            Tester.population.add(new Inky(Character.ghost, Tester.map1, 15, 13));
                            potentialCell.removeCharacter();
                        }
                        else if(potentialCell.getCharacter() instanceof Pinky)
                        {
                            Tester.population.remove(potentialCell.getCharacter());                            
                            Tester.population.add(new Pinky(Character.ghost, Tester.map1, 15, 12));
                            potentialCell.removeCharacter();
                        }        
                        else if(potentialCell.getCharacter() instanceof Clyde)
                        {
                            Tester.population.remove(potentialCell.getCharacter());                            
                            Tester.population.add(new Clyde(Character.ghost, Tester.map1, 14, 11));        
                            potentialCell.removeCharacter();
                        }        
                    }
                }
                catch(Exception e){}
                potentialCell.addCharacter(this);                
            }
            //changes the cell to having pacman moved upon it so it doesn't place another orb upon it
            //potentialCell.pacmanMovedOn();
        }

        Tester.pause(Tester.sleepTime);

    }

    /**
     * This is called if the character is not a Pacman, and checks if it has any
     * neighbors. If it does, it eatAt() them.
     */
    public void eat()
    {
        ArrayList<Character> neighbors = getListOfNeighbors();
        for(Character cc : neighbors)
        {
            this.eatAt(cc);
        }
    }

    /**
     * Checks if a ghost is going to eat a Pacman, and if it does Pacman becomes
     * deadPacman which ends the game.
     */

    public void eatAt(Character potentialVictim)
    {
        if(characterType == ghost && potentialVictim.getCharacterType() == pacman)
        {
            potentialVictim.changeCharacterType(deadPacman);
        }
    }

    /**
     * Obtains a list of all Characters in the 4 neighboring cells.
     */

    public ArrayList<Character> getListOfNeighbors()
    {
        ArrayList<Character> neighbors = new ArrayList<Character>();
        int row = currentCell.getRow();
        int col = currentCell.getCol();

        for(int[] possibleMove : possibleMoves)
        {
            int newRow = row + possibleMove[0];
            int newCol = col + possibleMove[1];

            if(newRow >= 0 && newRow < Map.NUMBER_OF_ROWS && newCol >= 0 && newCol < Map.NUMBER_OF_COLUMNS)
            {
                Cell potentialCell = map.getCell(newRow, newCol);
                if(!potentialCell.getAvailability() && !potentialCell.isWallCell())
                {
                    neighbors.add(potentialCell.getCharacter());
                }
            }
            
        }

        return neighbors;
    }

    /*
    * Accessor
    */
    
    public Cell getCell()
    {
        return currentCell;
    }

    /*
    * Accessor
    */
    
    public int getCharacterType()
    {
        return characterType;
    }

    /*
    * Changes from one cell to another.
    */
    
    public void setCell(Cell newCell)
    {
        currentCell = newCell;
    }

    /*
    * Sets the Icon of a Character; overridden in each subclass to obtain the
    * correct Icons
    */
    public void setIcon(Icon i)
    {
        
    }
    
    /*
    * Overriden in the ghost subclass, finds which icon corresponds with the
    * direction the character is moving.
    */
    
    public void findIcon()
    {
        
    }
    
    /*
    * Changes the Character Type.
    */
    public void changeCharacterType(int newStatus)
    {
        characterType = newStatus;
    }
}