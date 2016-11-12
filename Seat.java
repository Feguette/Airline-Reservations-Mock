

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
    //private String[] seatLetter = {"A", "B", "C", "D", "E", "F", "G", "H"};
    //private boolean[][] occupied = new boolean[8][12];
    private int row;
    private String section;
    private boolean windowView, firstClass;
    private boolean vacancy;
    private Passenger passenger;
    
    public Seat(String aSection, int aRow)
    {
        section = aSection;
        row = aRow;
        Passenger passenger = new Passenger("John", "Doe");
        windowView = false;
        firstClass = false;
        vacancy = true;
    }

    public void setRow(int aRow) {
        row = aRow;
    }
    
    public int getRow() {
        return row;
    }
    
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
    
    public void setSeatSection(String s) {
        section = s;
    }
    
    public String getSeatSection() {
        return section;
    }
    
    public void setVacancy(boolean status) {
        vacancy = status;
    }
    
    public boolean getVacancy() {
        return vacancy;
    }    
    
    public void assignPassenger(Passenger p) {
        passenger = p;
    }
    
    public Passenger getPassenger() {
        return passenger;
    }
    
}
