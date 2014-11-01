
import java.util.Scanner;

public class testProg
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      TrinaryTree x = new TrinaryTree();  
                  // Key = String, Value = String

      x.put( 5 );
      x.put( 4 );

      x.put( 9 );
      x.put( 5 );
      x.put( 7 );
      x.put(  2);
      x.put( 2 );
      
      x.printBST();
/*
      System.out.println("Remove *************************");
      System.out.println("*** remove 50 ***");
      x.remove( 50 );
      x.printBST();
      System.out.println("*** remove 7 ***");
      x.remove( 7 );
      x.printBST();

      System.out.println("*** remove 10 ***");
      x.remove( 10 );
      x.printBST();

      System.out.println("*** remove 70 ***");
      x.remove( 70 );
      x.printBST();

      System.out.println("*** remove 30 ***");
      x.remove( 30 );
      x.printBST();
      System.out.println("*** remove 80 ***");
      x.remove( 80 );
      x.printBST();

      System.out.println("*** remove 38 ***");
      x.remove( 38 );
      x.printBST();
      System.out.println("*** remove 90 ***");
      x.remove( 90 );
      x.printBST();

      System.out.println("*** remove 50 ***");
      x.remove( 50 );
      x.printBST();

      System.out.println("*** remove 75 ***");
      x.remove( 75 );
      x.printBST();

      

      System.out.println("*** remove 90 ***");
      x.remove( 90 );
      x.printBST();
      System.out.println("*** remove 50 ***");
      x.remove( 50 );
      x.printBST();

      System.out.println("*** remove 5 ***");
      x.remove( 5 );
      x.printBST();

      System.out.println("*** remove 39 ***");
      x.remove( 39 );
      x.printBST();

      System.out.println("*** remove 45 ***");
      x.remove( 45 );
      x.printBST();

      System.out.println("*** remove 40 ***");
      x.remove( 40 );
      x.printBST();
*/
   }
}
