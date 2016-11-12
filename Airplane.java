/**
 * Airplane containing seats.
 *
 * int ROW, SECTION
 * Seat[][]seats
 * Airplane()
 * initializeSeats()
 * printSeats()
 * displayMenu()
 * reserveSeat(String section, int row)
 * randomFill(int numberOfSeats) //Name as John Doe1, John Doe2, John Doe3...
 *
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * Write a description of class Airplane here.
 * 
 * @author (Jennifer Lai & Jason Liang) 
 * @version (-- Nov 2016)
 */
import java.util.Scanner;
import java.util.Random;
public class Airplane
{
    private final int ROW = 13; //Rows 1-12
    private final int SECTION = 9; //Sections A-H
    private String[] seatLetter = {"Z", "A", "B", "C", "D", "E", "F", "G", "H"};
    private Seat[][] seats;
    private Random rand;
    
    public Airplane() {
        seats = new Seat[SECTION][ROW];
        rand = new Random();
        initializeSeats();
    }
    
    public void initializeSeats() {
        for (int i=1; i<ROW; i++) {
            boolean firstClass = true;
            if (i>4) {
                firstClass = false;
            }
            
            for (int j=1; j<SECTION; j++) {
                String section = "Z";
                boolean windowView = false;
                section = seatLetter[j];
                if (section.equalsIgnoreCase("A") || section.equalsIgnoreCase("H")) {
                    windowView = true;
                }
                Seat temp = new Seat(section,i);
                temp.setWindowView(windowView);
                temp.setSeatClass(firstClass);
                temp.setVacancy(true);
                seats[j][i] = temp;
                System.out.println("section " +seats[j][i].getSeatSection()+ " row " + seats[j][i].getRow());
            }
        }
    }
    
    public void printSeats() {
        for (int i=1; i<SECTION; i++) {
            System.out.print(seatLetter[i] + " "); 
            for (int j=1; j<ROW; j++) {
                if (seats[i][j].getVacancy()==false)
                    System.out.print("[X]");
                else
                    System.out.print("[ ]");
                if(j==3) {
                    System.out.print("   ");
                }
            }
            if (i==1 || i==5)
                System.out.println();
            System.out.println();
        }
        System.out.println("   1  2  3  4     5  6  7  8  9  10 11 12");
    }
    
    public void displayPassengers() {
        for (int i=1;i<SECTION; i++) {
            for (int j=1;j<ROW; j++) {
                if (seats[i][j].getVacancy()==false) {
                    System.out.print("Section: " + seats[i][j].getSeatSection());
                    System.out.print(" Row: " + seats[i][j].getRow());
                    System.out.println(" Passenger: " + seats[i][j].getPassenger().getFullName());
                }
            }
        }
    }
    
    public int seatToInt(String str)
    {
       for (int i = 1; i < seatLetter.length; i ++)
       {
           if (str.equalsIgnoreCase(seatLetter[i]))
           {
               return i;
            }
       }
       return -1;
    }
    
    public void  reserveSeat(String section, int row, Passenger p) {
        int sectionNew = seatToInt(section);
        if (seats[sectionNew][row].getVacancy()==true) {
            seats[sectionNew][row].assignPassenger(p);
            seats[sectionNew][row].setVacancy(false);
        }
        else
            System.out.println("Occupied. Please choose another seat.");
    }
    
    public void randomFill(int n) {
        int count=0;
        while (count<n) {
           int randSection = rand.nextInt(SECTION);
           int randRow = rand.nextInt(ROW);
           if (randSection !=0 && randRow !=0 && seats[randSection][randRow].getVacancy()==true) {
               seats[randSection][randRow].setVacancy(false);
               Passenger temp = new Passenger("John", "Doe" + count + "");
               seats[randSection][randRow].assignPassenger(temp);
               count = count+1;
            }
        }
    }
   
    public int countPassengers() {
        int count = 0;
        for (int i=1; i<SECTION; i++) {
            for (int j=1; j<ROW; j++) {
                if (seats[i][j].getVacancy()==false)
                    count = count + 1;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
       
       Scanner in = new Scanner(System.in);
       Scanner st = new Scanner(System.in);
       //Scanner val = new Scanner(System.in);
       boolean opCont = true;
       Airplane airborne = new Airplane();
       airborne.randomFill(20);
       airborne.printSeats();
       int option;
       
       while (opCont)
       {
           System.out.println("Number of passengers are: " + airborne.countPassengers());
           System.out.println("1. Print occupancy.");
           System.out.println("2. Reserve seat manually.");
           System.out.println("3. Reserve seat automatically.");
           System.out.println("6. Print passenger information.");
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
           
           if (option == 6) {
               airborne.displayPassengers();
            }
           
           System.out.println("");
       }
    }    
}
