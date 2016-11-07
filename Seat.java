
/**
 * Write a description of class Seat here.
 *
 * int row
 * String section
 * boolean vacancy, windowView, firstClass
 * Passener passenger
 * Seat(String aSection, int aRow)
 * getRow()
 * setWindowView(boolean status)
 * getWindowViewStatus()
 * setSeatClass(boolean status)
 * getSeatSection()
 * setSeatSection(String s)
 * setVacancy(boolean status)
 * getVacancy()
 * assignPassenger(Passenger p)
 *
 * @author (Jennifer Lai & Jason Liang) 
 * @version (7 Nov 2016)
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
       System.out.println("");
       for (int seat = 0; seat < 8; seat ++)
       {
           if (seat == 2 || seat == 6)
           System.out.println("");
           System.out.print(seatLetter[seat] + "  ");
           for (int row = 0; row < 12; row ++)
           {
               if (row == 4)
               System.out.print("  ");
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
       System.out.print("    1  2  3  4    5  6  7  8  9  10 11 12");
    }
}
