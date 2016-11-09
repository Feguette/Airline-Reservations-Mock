
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
public class Airplane
{
   public static void main(String[] args)
   {
       Scanner in = new Scanner(System.in);
       Scanner val = new Scanner(System.in);
       boolean opCont = true;
       Seat airborne = new Seat();
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
               System.out.println("Input seat(Letter A - H), then row (No. 1 - 12): ");
               String str = val.nextLine();
               airborne.setOccupied(str.substring(0, 1), Integer.valueOf(str.substring(1)) - 1);
           }
           
           System.out.println("");
       }
       }
   }

