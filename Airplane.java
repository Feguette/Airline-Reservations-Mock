/**
 * Constructs airplane containing seats.
 *
 *
 * @author (Jennifer & Jason) 
 * @version (11/13/16)
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Airplane
{
    private final int ROW = 13; //Rows 1-12, exclude 0
    private final int SECTION = 9; //Sections A-H, exclude Z
    private static String[] seatLetter = {"Z", "A", "B", "C", "D", "E", "F", "G", "H"}; //seat letters from A-H
    private Seat[][] seats; //array of seats
    private Random rand; //random generator
    private int type; //Number of times John Doe's have been made
    
    /**
     * Constructs airplane and intializes seats & random generator.
     * (Postcondition: airplane is created)
     */
    public Airplane() {
        seats = new Seat[SECTION][ROW];
        rand = new Random();
        type = 0;
        initializeSeats();
    }
    
    /**
     * Initializes seats array.
     * (Postcondition: seats have vacancy,window view, and first class booleans & section & row)
     */
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
    
    /**
     * Prints visual of seat layout. '[X]' represents occupied seats and '[ ]' represents available seats.
     * (Postcondition: prints seat layout)
     */
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
    
    /**
     * Displays all reserved information about passengers, including full name, seat section, and seat row.
     * (Postcondiition: prints passengers in airplane)
     */
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
    
    /*
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
    */
    
    /**
     * Converts seat to integer to search within seats array.
     * (Postcondition: index of section within array, -1 if not found)
     * @param str section of seat.
     * @return index of section within array, -1 if not found
     * (Precondition: section exists in array)
     */
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
    
    /**
     * Reserves seat for individual passenger.
     * (Postcondition: sets certain seat to occupied and assigns passenger to that seat)
     * @param section section of seat
     * @param row row of seat
     * @param p passenger reserving that seat
     * (Precondition: section, row, and passenger p all exist)
     */
    public void reserveSeat(String section, int row, Passenger p) {
        int sectionNew = seatToInt(section);
        if (seats[sectionNew][row].getVacancy()==true) {
            seats[sectionNew][row].assignPassenger(p);
            seats[sectionNew][row].setVacancy(false);
        }
        else
            System.out.println("Occupied. Please choose another seat.");
    }

    /**
     * Cancels seat for individual passenger by passenger name.
     * (Postcondition: sets certain seat to unoccupied and removes passenger from that seat)
     * @param fullName full name of passenger
     * (Precondition: section, row, and passenger p all exist)
     */    
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
    
    /**
     * Cancels seat for individual passenger by seat section and row.
     * (Postcondition: sets certain seat to unoccupied and removes passenger from that seat)
     * @param section section of seat
     * @param row row of seat
     * (Precondition: section, row, and passenger p all exist)
     */    
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
    
    /**
     * Randomly selects availible spots
     * (Postcondition: sets certain amount of seats to occupied and assigns passengers to those seats)
     * @param n number of seats to be randomly filled by passengers
     * (Precondition: amount of available seats>n)
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
    
    /**
     * Creates passenger with first name and last name.
     * @return passenger with first and last name.
     * (Precondition: passenger must have first and last name)
     */
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
     * Counts number of passengers inside airplane.
     * @return number of passengers inside airplane.
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
     * Assigns group of passengers to certain adjacent seats in the airplane.
     * (Postcondition: numberPassengers amount of passengers are assigned to adjacent groups)
     * @param numberPassengers number of passengers that must be in a group
     * (Precondition: numberPassengers>0)
     */
    public void groupMaker(int numberPassengers) {
        ArrayList<int[]> position = groupFinder(numberPassengers);
        if (position != null)
        {
            for (int i = 0; i < numberPassengers; i++)
            {
                int[] spot = position.get(i);
                reserveSeat(seatLetter[spot[0]], spot[1], createPassenger());
            }
        }
        else
        {
            System.out.println("Could not find appropriate number of seats.");
        }
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
    
    
}
