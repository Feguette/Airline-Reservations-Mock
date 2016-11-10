 */

/**
 * Write a description of class Airplane here.
 * 
 * @author (Jennifer Lai & Jason Liang) 
 * @version (-- Nov 2016)
 */
import java.util.Scanner;
public class Airplane
{
    private final int ROW = 12;
    private final int SECTION = 8;
    private String[] seatLetter = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private Seat[][] seats;
    
    public Airplane() {
        seats = new Seat[SECTION][ROW];
        initializeSeats();
    }
    
    public void initializeSeats() {
        for (int i=0; i<ROW; i++) {
            boolean firstClass = true;
            if (i>4) {
                firstClass = false;
            }
            
            for (int j=0; j<SECTION; j++) {
                String section = "Z";
                boolean windowView = true;
                
                for (int k=0; k<seatLetter.length; k++) {
                    section = seatLetter[k];
                    if (section.equalsIgnoreCase("A") || section.equalsIgnoreCase("H")) {
                        windowView = true;
                    }
                }
                Seat temp = new Seat(section,i);
                temp.setWindowView(windowView);
                temp.setSeatClass(firstClass);
                temp.setVacancy(true);
                seats[j][i] = temp;
            }
        }
    }
    
    public void printSeats() {
        for (int i=0; i<SECTION; i++) {
            System.out.print(seatLetter[i] + " "); 
            for (int j=0; j<ROW; j++) {
                if (j==3) {
                    if (seats[i][j].getVacancy()==false)
                        System.out.print("[X]   ");
                    else
                        System.out.print("[ ]   ");
                }    
                else {
                    if (seats[i][j].getVacancy()==false)
                        System.out.print("[X]");
                    else
                        System.out.print("[ ]");    
                }
            }
            System.out.println("");
        }
        System.out.println("   1  2  3  4     5  6  7  8  9  10 11 12");
    }
    
    public void displayMenu() {
    
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
    
    public void  reserveSeat(String section, int row, Passenger p) {
        int sectionNew = seatToInt(section);
        int rowNew = row-1;
        seats[sectionNew][rowNew].assignPassenger(p);
        seats[sectionNew][rowNew].setVacancy(false);
    }
    
    public static void main(String[] args) {
       
       Scanner in = new Scanner(System.in);
       Scanner st = new Scanner(System.in);
       //Scanner val = new Scanner(System.in);
       boolean opCont = true;
       Airplane airborne = new Airplane();
       airborne.printSeats();
       int option;
       
       while (opCont)
       {
           System.out.println("1. Print occupancy");
           System.out.println("2. Set occupancy");
           System.out.println("0. Quit");
           System.out.print("Input option: ");
           option = in.nextInt();
           
           
           if (option == 0)
           break;
           
           if (option == 1)
           airborne.printSeats();
           
           if (option == 2)
           {
               System.out.print("Input seat(Letter A - H):  ");
               String seatLetter = st.nextLine();
               System.out.print("Input row (No. 1 - 12): ");
               int seatRow = in.nextInt();
               System.out.print("What is the passenger's first name: ");
               String pFirst = st.nextLine();
               System.out.print("What is the passenger's last name: ");
               String pLast = st.nextLine();
               Passenger temp = new Passenger(pFirst, pLast);
               airborne.reserveSeat(seatLetter, seatRow, temp);
           }
           
           System.out.println("");
           
       }
       
      Airplane fly = new Airplane();
      fly.printSeats();
   }    
}
