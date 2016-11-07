
/**
 * Write a description of class Seat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seat
{
    private String[] seatLetter = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private boolean[][] occupied = new boolean[8][12];
    public Seat()
    {
        for (int i = 0; i < occupied.length; i ++)
        {
            for (int j = 0; j < occupied[1].length; j ++)
            {
                occupied[i][j] = false;
            }
        }
    }
    
    public void printSeats()
    {
       for (int seat = 0; seat < 8; seat ++)
       {
           if (seat == 2 || seat == 5)
           System.out.println("");
           System.out.print(seatLetter[seat] + "  ");
           for (int row = 0; row < 12; row ++)
           {
               if (row == 4 || row == 8)
               System.out.print(" ");
               System.out.print("[");
               if (occupied[seat][row] == false)
               {
                   System.out.print(" ");
               }
               else {
               if (occupied[seat][row] == false)
               {
                   System.out.print("x");
               }
               }
               System.out.print("]");
           }
           System.out.println("");
       }
    }
}
