// Name:
// USC loginid:
// CS 455 PA3
// Fall 2014

import java.awt.Graphics;
import javax.swing.JComponent;

/**
   MazeComponent class
   
   A component that displays the maze and path through it if one has been found.
*/
public class MazeComponent extends JComponent
{
   
   private static final int START_X = 10;  // where to start drawing maze in frame
   private static final int START_Y = 10;  // (i.e., upper-left corner)
   
   private static final int BOX_WIDTH = 20;  // width and height of one maze unit
   private static final int BOX_HEIGHT = 20;

   
   /**
      Constructs the component.
      @param maze   the maze to display
   */
   public MazeComponent(Maze maze) 
   {      

   }

   
   /**
     Draws the current state of maze including the path through it if one has
     been found.
     @param g the graphics context
   */
   public void paintComponent(Graphics g)
   {
   
   }
   
}



