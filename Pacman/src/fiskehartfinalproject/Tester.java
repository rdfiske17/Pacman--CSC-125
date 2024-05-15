package fiskehartfinalproject;

import java.util.ArrayList;
import javax.swing.*;

/**
 * This is our final project and a replication of the classic game Pacman. We used
 * much of the code from the COVID-19 Transmission Agent Based Simulation to
 * create a map with characters, some that move automatically and others that move
 * according to input by the user. The objective is to go around and collect all 
 * the orbs on the map as pacman (using WASD to move up, right, down, and left)
 * and not run into the ghosts which will cause the end of the game. See README.txt
 * for further information.
 * 
 * @author Riley Fiske & Evan Hart
 */

public class Tester extends JFrame
{
    public static int sleepTime = 40; //compile project everytime after updating this
    public static int timeTicker = 0;
    public static ArrayList<Character> population = new ArrayList<Character>();
    public static Map map1;
    
    
    public static void main(String[] args)
    {        
        //makes a map
        map1 = new Map(Map.map1);
        map1.initializeMap();
        map1.showMap();
        //adds the ghosts to the population
        population.add(new Blinky(Character.ghost, map1, 15, 14));
        population.add(new Inky(Character.ghost, map1, 15, 13));
        population.add(new Pinky(Character.ghost, map1, 15, 12));
        population.add(new Clyde(Character.ghost, map1, 14, 11));
        
        //while a deadPacman doesn't exist, run the game.
        while(population.get(0).getCharacterType() != Character.deadPacman && population.get(1).getCharacterType() != Character.deadPacman
                && population.get(2).getCharacterType() != Character.deadPacman && population.get(3).getCharacterType() != Character.deadPacman
                && population.get(4).getCharacterType() != Character.deadPacman)
        {
            //try and catch statement used to catch errors with changing population when ghosts are killed
            try
            {
            for(Character cc : population)
            {
                
                cc.move();
                //decrements the munchable timer and sets the ghost back to normal after munchableTicker hits 0
                if(cc.getCharacterType() == cc.munchable)
                {
                    cc.munchableTicker--;
                    if(cc.munchableTicker == 0)
                    {
                        cc.changeCharacterType(Character.ghost);
                        cc.munchableTicker = Character.genericMunchTimer;
                    }
                }
            }
            timeTicker++;
            int orbCounter = 0;
            //checks if the map has any orbs on it
            for(int ii = 0; ii< Map.NUMBER_OF_ROWS; ii++)
            {
                for(int jj = 0; jj< Map.NUMBER_OF_COLUMNS; jj++)
                {
                    if(Map.cells[ii][jj].getIcon() == Cell.orbIcon)
                    {
                        orbCounter++;
                    }
                }
            }
            //if no orbs left, end the game
            if(orbCounter == 0)
            {
                break;
            }
            //the game gets slightly faster as time progresses
            if(timeTicker % 30 == 0 && sleepTime > 0)
            {
                timeTicker = 0;
                sleepTime--;
            }
        }
        catch(Exception e)
                {
                
                }   
        }
        //prints out a message if you won or lost
        if(population.get(0).getCharacterType() != Character.deadPacman && population.get(1).getCharacterType() != Character.deadPacman
                && population.get(2).getCharacterType() != Character.deadPacman && population.get(3).getCharacterType() != Character.deadPacman
                && population.get(4).getCharacterType() != Character.deadPacman)
        {
            System.out.println("Congratulations! You have won and collected all the orbs!");
        }
        else
        {
            System.out.println("Game Over!");        
        }    
    }    
    /**
     * Used to delay actions ingame
     * @param pauseTime milliseconds between movements
     */
    public static void pause(int pauseTime)
    {
        try
              {
                    Thread.sleep(pauseTime);
              }
              catch(InterruptedException ex)
              {
               Thread.currentThread().interrupt();
              }
    }
}