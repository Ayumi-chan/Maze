public class Maze
{
          private char[][] maze;
          public Pair<Integer, Integer> origin;
          public Pair<Integer, Integer> exit;
          public int steps;
       
       public Maze(char[][] aMaze, int i, int j)
          {
    	   		maze = aMaze;
    	   		origin = new Pair<Integer, Integer>(i, j);
    	   		
    	   		maze[i][j] = '@';
    	   		
    	   		for (int n = 0; n < maze[0].length; ++n)
    	   		{
    	   			if (maze[0][n] == ' ')
    	   			{
    	   				exit = new Pair<Integer, Integer>(0, n);
    	   			}
    	   		}
    	   		
    	   		for (int n = 0; n < maze[maze.length - 1].length; ++n)
    	   		{
    	   			if (maze[maze.length - 1][n] == ' ')
    	   			{
    	   				exit = new Pair<Integer, Integer>(maze.length - 1, n);
    	   			}
    	   		}
    	   		
    	   		if (exit == null)
    	   			exit = new Pair<Integer, Integer>(-1, -1); //no exits
          }
  
       public boolean findExit()
   {
    	   return escape(origin.first, origin.second);
   }
  
   private boolean escape(int i, int j)
   {
	   return (move(i - 1, j) || move(i + 1, j) || move(i, j - 1) || move(i, j + 1));
   }
 
   private boolean move(int i, int j)
   {
	   
	   
	  if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length)
	  {
		  return false;
	  }
	  
	  
	  if (maze[i][j] == ' ')
	  {
		  maze[i][j] = '#';
		  if (isExit(i, j))
		  {
			  return true;
		  }
		  steps++;
		  return escape (i, j);
	  }
	  
	  return false;
	  
   }
  
   private boolean isExit(int i, int j)
   {
	   return (i == 0 || i == maze.length || j == 0 || j == maze.length);
   }
  
 
   public void display()
   {
	   for (char [] c : maze)
	   {
		   for (char cx : c)
		   {
			   System.out.print(cx + " ");
		   }
		   System.out.println();
	   }
	   
    }

   public static void main(String args[])
   {
      char[][] m = {
         {'*', ' ', '*', '*', '*', '*', '*', '*', '*'}, 
         {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'}, 
         {'*', ' ', '*', '*', '*', '*', '*', ' ', '*'}, 
         {'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*'}, 
         {'*', ' ', '*', '.', '*', '*', '*', ' ', '*'}, 
         {'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*'}, 
         {'*', '*', '*', ' ', '*', ' ', '*', ' ', '*'}, 
         {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'}, 
         {'*', '*', '*', '*', '*', '*', '*', '*', '*'}};
         
    
      Maze maze = new Maze(m, 4, 3); //(m, xStart, yStart)
      maze.display();
      if (maze.findExit())
         System.out.println("There is an exit at (" + maze.exit.first + ", "
               + maze.exit.second + ")");
      else
         System.out.println("No exit was found");
      
      System.out.println();
      System.out.println();
      maze.display();
      System.out.println("Steps:" + maze.steps);
      
   }
}



