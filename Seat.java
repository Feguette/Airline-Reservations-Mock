
/**
 * Write a description of class Seat here.
 *
 * int row
 * String section
 * boolean vacancy, windowView, firstClass
 * Passenger passenger
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
 * getPassenger()
 *
 * @author (Jennifer Lai & Jason Liang) 
 * @version (7 Nov 2016)
 */
public class Seat
{
    private String[] seatLetter = {"A", "B", "C", "D", "E", "F", "G", "H"};
    //private boolean[][] occupied = new boolean[8][12];
    private boolean windowView, firstClass, vacancy;
    private Passenger[][] passengers = new Passenger[8][12];
    
    public Seat()
    {
        windowView = false;
        firstClass = false;
    }
    
    /*
    public int getRow() {
    }
    */
    public void assignPassenger(Passenger p, int seat, int row)
    {
        passengers[seat][row] = p;
    }
    
    public int seatToInt(String str)
   {
       for (int i = 0; i < seatLetter.length; i ++)
       {
           if (str.equals(seatLetter[i]))
           {
               return i;
            }
       }
       return -1;
   }
    
    /**
     * 
     */
    public void setWindowView(boolean status) {
        windowView = status;
    }
    
    public boolean getWindowViewStatus() {
        return windowView;
    }
    
    public void setSeatClass(boolean status) {
        firstClass = status;
    }
    
    public boolean getSeatClass() {
        return firstClass;
    }
    
    /**
     * 
     */
    public void setSeatSection(String s) {
        
    }
    
    public void setVacancy(boolean status) {
        vacancy = status;
    }
    
    public boolean getVacancy() {
        return vacancy;
    }
    
    /*
    public void assignPassenger(Passenger p) {
    }
    
    public Passenger getPassenger() {
    }
    */
    
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
               if (passengers[seat][row] == null)
               {
                   System.out.print(" ");
               }
               else {
               if (passengers[seat][row] != null)
               {
                   System.out.print("x");
               }
               }
               System.out.print("]");
           }
           System.out.println("");
       }
       System.out.println("    1  2  3  4    5  6  7  8  9  10 11 12");
    }
}
