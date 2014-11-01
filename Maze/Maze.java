// Name:
// USC loginid:
// CS 455 PA3
// Fall 2014


import java.util.LinkedList;
import java.util.*;


/**
   Maze class

   Stores information about a maze and can find a path through the maze
   (if there is one).

   Assumptions about structure of the mazeData (given in constructor), and the
   path:
     -- no outer walls given in mazeData -- search assumes there is a virtual 
        border around the maze (i.e., the maze path can't go outside of the maze
        boundaries)
     -- start location for a path is maze coordinate (START_SEARCH_ROW,
        START_SEARCH_COL) (constants defined below)
     -- exit loc is maze coordinate (numRows()-1, numCols()-1) 
           (methods defined below)
     -- mazeData input 2D array of 0's and 1's (see public FREE / WALL 
        constants below) where the first index indicates the row. 
        e.g., mazeData[row][col]
     -- only travel in 4 compass directions (no diagonal paths)
     -- can't travel through walls

   Modified 10/23/14 by CMB
      Made START_SEARCH_ROW and START_SEARCH_COL constants (as they were
      intended to be).

 */

public class Maze {
   
   public static final int START_SEARCH_COL = 0;
   public static final int START_SEARCH_ROW = 0;

   public static final int FREE = 0;
   public static final int WALL = 1;
   
   private static int[][] maze;
   private LinkedList<MazeCoord> path;
   private ArrayList<MazeCoord> reversePath;
   /**
      Constructs a maze.
      @param mazeData the maze to search.  See Maze class comments, above,
      for what goes in this array.

    */
   public Maze(int[][] mazeData) {
      maze = new int[mazeData.length][mazeData[0].length];
      for (int i = 0; i < mazeData.length; i++) {
        for (int j = 0; j < mazeData[0].length; j++) {
            maze[i][j] = mazeData[i][j];
        }
      } 
   }


   /**
      Returns the number of rows in the maze
      @return number of rows
    */
   public int numRows() {
      return maze.length;   // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Returns the number of columns in the maze
     @return number of columns
   */
   public int numCols() {
      return maze[0].length;   // DUMMY CODE TO GET IT TO COMPILE
   } 


   /**
      Gets the maze data at loc.
      @param loc the location in maze coordinates
      @return the value at that location.  One of FREE and WALL
      PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
    */
   public int getValAt(MazeCoord loc) {
      if (loc.getRow() < 0 || loc.getRow() >= numRows() || loc.getCol() < 0 || loc.getCol() >= numCols()) {
        return WALL;
      }

      if (maze[loc.getRow()][loc.getCol()] == WALL) {
        return WALL;
      } else {
        return FREE;
      }
      //return 0;   // DUMMY CODE TO GET IT TO COMPILE

   }

   
   /**
      Returns the path through the maze. First element is starting location, and
      last element is exit location.  If there was not path, or if this is called
      before search, returns empty list.

      @return the maze path
    */
   public LinkedList<MazeCoord> getPath() {
      
      return path;   // DUMMY CODE TO GET IT TO COMPILE

   }


   /**
      Find a path through the maze if there is one.
      @return whether path was found.
    */
   public boolean search()  {  

      ArrayList<MazeCoord> result = new ArrayList<MazeCoord>();
      boolean[][] visited = new boolean[maze.length][maze[0].length];
      dfs(result, maze, 0, 0, visited);
      if (result.size() == 0) {
        path = null;
        return false;
      } else {
        path = new LinkedList<MazeCoord>();
        for (int i = 0; i < reversePath.size() ;  i++) {
          path.add(reversePath.get(i));
        } 

        for (MazeCoord item : path) {
          System.out.print(item.toString() + " ");
        }
        System.out.println("");
        return true;
      }



     // return false;  // DUMMY CODE TO GET IT TO COMPILE

   }

   private void dfs(ArrayList<MazeCoord> result, int[][] maze, int i, int j, boolean[][] visited)  {
      

      MazeCoord current = new MazeCoord(i, j);
      visited[i][j] = true;
      result.add(current);
      int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      for (int[] dir : dirs) {
          int adjX = i + dir[0];
          int adjY = j + dir[1];
          MazeCoord adj = new MazeCoord(adjX, adjY);
          if (adjX == visited.length - 1 && adjY == visited[0].length - 1) {
              result.add(adj);
              reversePath = new ArrayList<MazeCoord>(result);
              return;
          }

         
          if (getValAt(adj) == FREE && visited[adjX][adjY] == false) {
              //System.out.println(adj.toString());
              dfs(result, maze, adjX, adjY, visited);
          }
      }
      visited[i][j] = false;
      result.remove(result.size() - 1);
   }

}
