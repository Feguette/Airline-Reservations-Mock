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
import java.util.ArrayList;
import java.util.Random;
public class Airplane
{
    private final int ROW = 13; //Rows 1-12, exclude 0
    private final int SECTION = 9; //Sections A-H, exclude Z
    private static String[] seatLetter = {"Z", "A", "B", "C", "D", "E", "F", "G", "H"};
    private Seat[][] seats;
    private Random rand;
    private int type; //Number of times John Doe's have been made
    
    public Airplane() {
        seats = new Seat[SECTION][ROW];
        rand = new Random();
        type = 0;
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
                if(j==4) {
                    System.out.print("   ");
                }
            }
            if (i==2 || i==6)
                System.out.println("");
            System.out.println("");
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
    
    public void displaySeats() {
        int length = 0;
        for (int i = 1; i <=8; i ++)
        {
            for (int j = 1; j < 12; j ++)
            {
                int current = seats[i][j].getPassenger().getFullName().length();
                length = Math.max(current, length);
            }
        }
        
        for (int i = 1; i <= 4; i ++)
        {
            System.out.print("Seat|");
            System.out.print("Name");
            for (int j = 4; j < length; j ++)
             System.out.print(" ");
             System.out.print("|");
             System.out.print("First Class|Window Seat");
            for (int j = 0; j < 4; i ++)
            {
                
            }
        }
            
        
        
        for (int i = 0; i < 4; i ++)
        {}
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
    
    public void reserveSeat(String section, int row, Passenger p) {
        int sectionNew = seatToInt(section);
        if (seats[sectionNew][row].getVacancy()==true) {
            seats[sectionNew][row].assignPassenger(p);
            seats[sectionNew][row].setVacancy(false);
        }
        else
            System.out.println("Occupied. Please choose another seat.");
    }
    
    public void cancelByName(String fullName) {
        int foundSection = -1;
        int foundRow = -1;
        outerloop:
        for (int i=1; i<SECTION; i++) {
            for (int j=1; j<ROW; j++) {
                if (seats[i][j].getVacancy()==false) {
                    if (seats[i][j].getPassenger().getFullName().equalsIgnoreCase(fullName)) {
                        foundSection = i;
                        foundRow = j;
                        break outerloop;
                    }
                }
            }
        }
        
        if (foundSection==-1 && foundRow==-1) {
            System.out.println("No such passenger found.");
        }
        else {
            Passenger empty = new Passenger("", "");
            seats[foundSection][foundRow].assignPassenger(empty);
            seats[foundSection][foundRow].setVacancy(true);
        }
    }
    
    
    public void cancelBySeat(String section, int row) {
        int foundSection = seatToInt(section);
        if (seats[foundSection][row].getVacancy()==false) {
            Passenger empty = new Passenger("", "");
            seats[foundSection][row].assignPassenger(empty);
            seats[foundSection][row].setVacancy(true);
        }
        else
            System.out.println("No such passenger found.");
    }
    
    /*public void randomFill1(int n) {
        int count=0;
        while (count<n) {
           int randSection = rand.nextInt(SECTION);
           int randRow = rand.nextInt(ROW);
           if (randSection !=0 && randRow !=0 && seats[randSection][randRow].getVacancy()==true) {
               count += 1;
               type += 1;
               seats[randSection][randRow].setVacancy(false);
               Passenger temp = new Passenger("John", "Doe" + type + "");
               seats[randSection][randRow].assignPassenger(temp);
            }
        }
    }*/
    
    /**
     * Randomly selects availible spots
     */
    public void randomFill(int n) {
        int count = 0;
        int randIndex;
        boolean[][] vacancy = new boolean[10][14];
        int[] current;
        ArrayList<int[]> spots = new ArrayList<int[]>();
        
        Scanner st = new Scanner(System.in);
        int option1, option2;
        
        for(int i = 0; i < 10; i ++)
        {
            for(int j = 0; j < 14; j ++)
            {
                vacancy[i][j] = true;
                if (!(i == 0 || i == 9 || j == 0 || j == 13))
                if (seats[i][j].getVacancy() == false)
                    vacancy[i][j] = false;
                
            }
        }
        
        for(int i = 0; i < 10; i ++)
        {
            vacancy[i][0] = false;
            vacancy[i][13] = false;
        }
        
        for(int i = 0; i < 14; i ++)
        {
            vacancy[0][i] = false;
            vacancy[9][i] = false;
        }
        
        
        System.out.println("1. First Class ");
        System.out.println("2. Economy Class ");
        System.out.println("other. No preference ");
        System.out.println("Input a preference: ");
        option1 = st.nextInt();
        
        System.out.println("1. Window ");
        System.out.println("2. Aisle ");
        System.out.println("other. No preference ");
        System.out.println("Input a preference: ");
        option2 = st.nextInt();
        
        if (option1 == 1)
        {
            for(int i = 1; i <= 8; i ++)
            {
                for(int j = 1; j <= 12; j ++)
                {
                    if (seats[i][j].getSeatClass() == false)
                        vacancy[i][j] = false;
                    
                }
            }
        }
        
        if (option1 == 2)
        {
            for(int i = 1; i <= 8; i ++)
            {
                for(int j = 1; j <= 12; j ++)
                {
                    if (seats[i][j].getSeatClass() == true)
                        vacancy[i][j] = false;
                    
                }
            }
        }
        
        if (option2 == 1)
        {
            for(int i = 1; i <= 8; i ++)
            {
                for(int j = 1; j <= 12; j ++)
                {
                    if (seats[i][j].getWindowViewStatus() == false)
                        vacancy[i][j] = false;
                    
                }
            }
        }
        
        if (option2 == 2)
        {
            for(int i = 1; i <= 8; i ++)
            {
                for(int j = 1; j <= 12; j ++)
                {
                    if (seats[i][j].getWindowViewStatus() == true)
                        vacancy[i][j] = false;
                    
                }
            }
        }
        
        for (int i = 1; i <= 8; i ++)
        {
            for (int j = 1; j <= 12; j ++)
            {
                if (vacancy[i][j] == true)
                    spots.add(new int[] {i,j});
            }
        }
        
        if (n <= spots.size())
        {
            while (count < n)
            {
                randIndex = rand.nextInt(spots.size());
                count += 1;
                type += 1;
                current = spots.get(randIndex);
                seats[current[0]][current[1]].setVacancy(false);
                Passenger temp = new Passenger("John", "Doe" + type + "");
                seats[current[0]][current[1]].assignPassenger(temp);
                spots.remove(randIndex);
            }
        }
        else
        {
            System.out.println("No possible seats for those preferences.");
        }
        
    }
    
    public Passenger createPassenger() {
        Scanner st = new Scanner(System.in);
        String partName;
        String pFirst;
        String pLast;
        while (true)
        {
            System.out.print("Input passenger's first and last name (add the last space in between first and last name): ");
            partName = st.nextLine();
            if (!(partName.length() - partName.replace(" ","").length() > 0)) //Checks if there is at least 1 space in the input
                System.out.println("Enter a last name, or add a space between first name and last name."); 
            else 
                break;
        }
        pFirst = partName.substring(0, partName.lastIndexOf(" "));
        pLast =  partName.substring(partName.lastIndexOf(" ") + 1);
        return new Passenger(pFirst, pLast);
    }
    
    /**
     * 
     */
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
    
    /**
     * Returns an arraylist of arrays containing the sections and rows that may be used to group passengers. If no spots found, returns null.
     * (Postcondition: An arraylist within boundaries)
     * @return Either null or a list of available adjacent seats.
     * @param valSeats The number of seats the user wants to reserve.
     * (Precondition: A positive valSeats)
     */
    public ArrayList<int[]> groupFinder(int valSeats)   {
        boolean[][] vacancy = new boolean[10][14]; //boolean of an 8 by 12 with 1 wide borders.
        ArrayList<int[]> position = new ArrayList<int[]>(); //storage for positions; also acts as a queue for counter to check
        Scanner st = new Scanner(System.in);
        int option1, option2;
        
        for(int i = 0; i < 10; i ++)
        {
            for(int j = 0; j < 14; j ++)
            {
                vacancy[i][j] = true;
                if (!(i == 0 || i == 9 || j == 0 || j == 13))
                if (seats[i][j].getVacancy() == false)
                    vacancy[i][j] = false;
                
            }
        }
        
        for(int i = 0; i < 10; i ++)
        {
            vacancy[i][0] = false;
            vacancy[i][13] = false;
        }
        
        for(int i = 0; i < 14; i ++)
        {
            vacancy[0][i] = false;
            vacancy[9][i] = false;
        }
        
        
        System.out.println("1. First Class ");
        System.out.println("2. Economy Class ");
        System.out.println("other. No preference ");
        System.out.println("Input a preference: ");
        option1 = st.nextInt();
        
        System.out.println("1. Window ");
        System.out.println("2. Aisle ");
        System.out.println("other. No preference ");
        System.out.println("Input a preference: ");
        option2 = st.nextInt();
        
        if (option1 == 1)
        {
            for(int i = 1; i <= 8; i ++)
            {
                for(int j = 1; j <= 12; j ++)
                {
                    if (seats[i][j].getSeatClass() == false)
                        vacancy[i][j] = false;
                    
                }
            }
        }
        
        if (option1 == 2)
        {
            for(int i = 1; i <= 8; i ++)
            {
                for(int j = 1; j <= 12; j ++)
                {
                    if (seats[i][j].getSeatClass() == true)
                        vacancy[i][j] = false;
                    
                }
            }
        }
        
        if (option2 == 1)
        {
            for(int i = 1; i <= 8; i ++)
            {
                for(int j = 1; j <= 12; j ++)
                {
                    if (seats[i][j].getWindowViewStatus() == false)
                        vacancy[i][j] = false;
                    
                }
            }
        }
        
        if (option2 == 2)
        {
            for(int i = 1; i <= 8; i ++)
            {
                for(int j = 1; j <= 12; j ++)
                {
                    if (seats[i][j].getWindowViewStatus() == true)
                        vacancy[i][j] = false;
                    
                }
            }
        }
        

        int[] checkV = {-1,1,0,0};
        int[] checkH = {0,0,-1,1};
        for (int j = 1; j <= 12; j ++)
        {
            for (int i = 1; i <= 8; i ++)
            {
                //System.out.print("Thisruns");
                if (vacancy[i][j] == true)
                {
                    //System.out.print("Thisruns0");
                    int counter = 0;
                    position.add(new int[] {i,j});
                    vacancy[i][j] = false;
                    while (position.size() > counter)
                    {
                        //System.out.print("Thisruns2");
                        if (valSeats <= position.size())
                        {
                            for (int k = 0; k < position.size() - valSeats; k++)
                            position.remove(valSeats);
                            //System.out.print("Thisruns3");
                            return position;
                        }
                        int[] current = position.get(counter);
                        for (int k = 0; k < 4; k ++)
                        {
                            if (vacancy[current[0] + checkV[k]][current[1] + checkH[k]] == true)
                            {
                                //System.out.print("Thisruns1");
                                position.add(new int[]{current[0] + checkV[k], current[1] + checkH[k]});
                                vacancy[current[0] + checkV[k]][current[1] + checkH[k]] = false;
                            }
                        }
                        counter += 1;
                    }
                    position.clear();
                }
            }
        }
        return null;
        
    }
    
    public static void main(String[] args) {
       
       Scanner in = new Scanner(System.in);
       Scanner st = new Scanner(System.in);
       //Scanner val = new Scanner(System.in);
       boolean opCont = true;
       Airplane airborne = new Airplane();
       //airborne.randomFill(20);
       airborne.printSeats();
       int option;
       
       while (opCont)
       {
           System.out.println("Number of passengers are: " + airborne.countPassengers());
           System.out.println("1. Print occupancy.");
           System.out.println("2. Reserve seat(s) manually.");
           System.out.println("3. Reserve seat(s) automatically.");
           System.out.println("4. Preferential seating reservation for one or more seats (WINDOW/AISLE).");
           System.out.println("5. Cancel reservation.");
           System.out.println("6. Print passenger information.");
           System.out.println("7. Print all reserved seats information.");
           //System.out.println("8. Seat class and preferential seating reservation for one or more seats.");
           System.out.println("0. Quit");
           System.out.print("Input option: ");
           option = in.nextInt();
           
           
           if (option == 0)
           break;
           
           if (option == 1)
           airborne.printSeats();
           
           if (option == 2) {
               System.out.print("How many passengers will be flying: ");
               int numberPassengers = in.nextInt();
               for (int i=0; i<numberPassengers; i++) {
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
            }
           
           if (option == 3) {
               System.out.println("1. Reserve randomly with filler");
               System.out.println("2. Reserve in group");
               System.out.print("Input one of the options above: ");
               option = in.nextInt();
               System.out.print("How many passengers will be flying? ");
               int numberPassengers = in.nextInt();
               airborne.randomFill(numberPassengers);
           }
           
           if (option==4) {
               System.out.println("1. Reserve individually");
               System.out.println("2. Reserve in group");
               System.out.print("Input one of the options above: ");
               option = in.nextInt();
               
               System.out.print("How many passengers will be flying? ");
               int numberPassengers = in.nextInt();
               
               if (option == 1){
                    for (int i=0; i < numberPassengers; i++) {
                           System.out.print("Input seat(Letter A - H) and row (No. 1 - 12): ");
                           String partSeat = st.nextLine();
                           String seatLetter = partSeat.substring(0,1);
                           int seatRow = Integer.valueOf(partSeat.substring(1));
                           airborne.reserveSeat(seatLetter, seatRow, airborne.createPassenger());
        
                    }
                }
                
               if (option == 2){
                       ArrayList<int[]> position = airborne.groupFinder(numberPassengers);
                       if (position != null)
                       {
                            for (int i = 0; i < numberPassengers; i++)
                            {
                                int[] spot = position.get(i);
                                airborne.reserveSeat(seatLetter[spot[0]], spot[1], airborne.createPassenger());
                            }
                       }
                       else
                       {
                            System.out.println("Could not find appropriate number of seats.");
                       }
               }
               option = -1;
           }
            
           if (option==5) {
               System.out.println("(1) Cancel by name.");
               System.out.println("(2) Cancel by section and row.");
               System.out.print("Input one of the options above: ");
               int choice = in.nextInt();
               if (choice==1) {
                   String fullName;
                   while (true)
                   {
                       System.out.print("Input passenger's first and last name (add the last space in between first and last name): ");
                       fullName = st.nextLine();
                       if (!(fullName.length() - fullName.replace(" ","").length() > 0))
                            System.out.println("Enter a last name, or add a space between first name and last name."); 
                       else 
                            break;
                   }
                   airborne.cancelByName(fullName);
                }
                
               if (choice==2) {
                   System.out.print("Input seat(Letter A - H) and row (No. 1 - 12): ");
                   String partSeat = st.nextLine();
                   String seatLetter = partSeat.substring(0,1);
                   int seatRow = Integer.valueOf(partSeat.substring(1));
                   airborne.cancelBySeat(seatLetter, seatRow);
                }
           }
           
           if (option == 6) {
               airborne.displayPassengers();
           }
           
           if (option==7) {
               
               
           }
            
           if (option==8) {
               
               
           }
           
           System.out.println("");
       }
    }    
}
