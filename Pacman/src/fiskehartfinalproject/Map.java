package fiskehartfinalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Creates a map that has walls and a JPanel to display everything in the program on.
 * This map can be initialized, shown, add characters to it, retrieve cells displayed 
 * on it, and later has an inner-class.
 * 
 * @author Riley Fiske & Evan Hart
 */

public class Map
{
    public JPanel panel;
    
    // Creates the map by initializing where the walls are.
    static boolean[][]  map1 = {
	{true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true },
           	{true ,false,false,false,false,false,false,false,false,false,false,false,false,true ,true ,false,false,false,false,false,false,false,false,false,false,false,false,true },
            	{true ,false,true ,true ,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,true ,true ,false,true },
            	{true ,false,true ,true ,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,true ,true ,false,true },
            	{true ,false,true ,true ,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,true ,true ,false,true },
            	{true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            	{true ,false,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,false,true },
            	{true ,false,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,false,true },
            	{true ,false,false,false,false,false,false,true ,true ,false,false,false,false,true ,true ,false,false,false,false,true ,true ,false,false,false,false,false,false,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,false,false,false,false,false,false,false,false,false,false,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,false,false,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,false,false,false,false,false,false,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,false,false,false,false,false,false,false,false,false,false ,false,false,false,false,false,false,false ,false,false,false,false,false,false,false,false,false,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,false,false,false,false,false,false,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,false,false,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,false,false,false,false,false,false,false,false,false,false,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true },
            	{true ,false,false,false,false,false,false,false,false,false,false,false,false,true ,true ,false,false,false,false,false,false,false,false,false,false,false,false,true },
            	{true ,false,true ,true ,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,true ,true ,false,true },
            	{true ,false,true ,true ,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,false,true ,true ,true ,true ,false,true },
            	{true ,false,false,false,true ,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true ,true ,false,false,false,true },
            	{true ,true ,true ,false,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,false,true ,true ,true },
            	{true ,true ,true ,false,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,false,true ,true ,true },
            	{true ,false,false,false,false,false,false,true ,true ,false,false,false,false,true ,true ,false,false,false,false,true ,true ,false,false,false,false,false,false,true },
            	{true ,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,true },
            	{true ,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,true ,true ,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,true },
            	{true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            	{true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true }
        };

    // Initializes instance variables. Controls the number of rows, columns, and the size of the cells.
    public static final  int  NUMBER_OF_ROWS = 31;
    public static final  int  NUMBER_OF_COLUMNS = 28;
    public static final  int  CELL_SIZE= 30;
    public static Cell[][] cells = new Cell[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

    // Sets up the map
    public Map(boolean[][] map)
    {
        map = map1;
    }
    
    // Initializes the map within a grid layout of jPanels.
    public void initializeMap()
    {

        panel = new JPanel(new GridLayout(NUMBER_OF_ROWS,NUMBER_OF_COLUMNS));
        //cells = new Cell[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for(int ii = 0; ii< NUMBER_OF_ROWS; ii++)
        {
            for(int jj = 0; jj<NUMBER_OF_COLUMNS; jj++)
            {
                cells[ii][jj] = new Cell(ii,jj,map1[ii][jj]);
                panel.add(cells[ii][jj].getButton());
            }
        }
    }
    
    // Initializes the visual representation of the map on a jFrame.
    public void showMap()
    {
        Pacman player = new Pacman(Character.pacman, this, 23,14);
        Tester.population.add(player);
        PlayerFrame frame = new PlayerFrame(player);
        frame.add(panel);
        frame.pack();//gets rid of any extra space not occupied by the cells in the window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setVisible(true);
    }
    
    // Retreives the row and column of the cell
    public Cell getCell(int row, int col)
    {
        return cells[row][col];
    }

    // Adds a character to the map at a specified location.
    public void addCharacter(Character character, int row, int col)
    {
        Cell cc = cells[row][col];
        cc.addCharacter(character);
        character.setCell(cc);
    }
    
    /**
     * inner-class that will contain KeyListeners to make Pacman move the way
     * the user designates (Framed around Nurse from Project8 with Nurse KeyListener)
     */
    private class PlayerFrame extends JFrame
    {
        private static final long serialVersionUID = 1L;
        private Pacman player;
        public PlayerFrame(Pacman nn)
        {
            super();
            player = nn;
            addKeyListener(new MyKeyListener(player));
        }
    }
    
    /**
     * Assigns the KeyListener to Pacman
     */
    private class MyKeyListener extends KeyAdapter
    {
        private Pacman player;
        public MyKeyListener(Pacman pacman)
        {
            super();
            this.player = pacman;
        }

        /**
         * When W,A,S, or D are pressed, calls a method within the Pacman
         * class to assign the movement direction to which way the player
         * inputs it.
         * @param ee KeyEvent
         */
        @Override
        public void keyPressed(KeyEvent ee)
        {   
            //System.out.println("Key Event detected!");
            switch (ee.getKeyCode()) {
                case KeyEvent.VK_W:
                    player.setDirection('w');
                    break;
                case KeyEvent.VK_A:
                    player.setDirection('a');
                    break;
                case KeyEvent.VK_S:
                    player.setDirection('s');
                    break;
                case KeyEvent.VK_D:
                    player.setDirection('d');
                    break;
                default:
                    break;
            }
            ee.consume();
        }
    }   
}