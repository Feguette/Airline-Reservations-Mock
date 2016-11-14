

/**
 * Attributes of a seat in an airplane.
 *
 * @author (Jennifer Lai & Jason Liang) 
 * @version (11/13/16)
 */
public class Seat
{
    private int row; //row of seat
    private String section; //section of seat
    private boolean windowView, firstClass; //booleans for status of window view and class of seat
    private boolean vacancy; //boolean for vacancy status of seat
    private Passenger passenger; //passenger in seat
    
    /**
     * Creates seat object with section and row.
     * (Postcondition: seat is created with certain section and row.)
     * @param aSection section of seat
     * @param aRow row of seat
     * (Precondition: seat has section and row.)
     */  
    public Seat(String aSection, int aRow)
    {
        section = aSection;
        row = aRow;
        Passenger passenger = new Passenger("John", "Doe");
        windowView = false;
        firstClass = false;
        vacancy = true;
    }

    /**
     * Changes row of seat.
     * (Postcondition: seat now has row aRow)
     * @param aRow new row of seat.
     * (Precondition: seat has been created).
     */      
    public void setRow(int aRow) {
        row = aRow;
    }

    /**
     * Returns row of seat.
     * @return row of seat
     * (Precondition: seat has a row)
     */    
    public int getRow() {
        return row;
    }
    
    /**
     * Changes window view status of seat.
     * (Postcondition: windowView = status)
     * @param status new window view status of seat.
     * (Precondition: seat has window view boolean)
     */          
    public void setWindowView(boolean status) {
        windowView = status;
    }
    
    /**
     * Returns window view status of seat
     * @return window view status of seat
     * (Precondition: seat has a window view status)
     */    
    public boolean getWindowViewStatus() {
        return windowView;
    }

    /**
     * Changes first class status of seat.
     * (Postcondition: firstClass= status)
     * @param status new first class status of seat.
     * (Precondition: seat has first class boolean)
     */              
    public void setSeatClass(boolean status) {
        firstClass = status;
    }

    /**
     * Returns first class status of seat
     * @return first class status of seat
     * (Precondition: seat has a first class status)
     */        
    public boolean getSeatClass() {
        return firstClass;
    }
    
    /**
     * Changes section of seat.
     * (Postcondition: seat now has section s)
     * @param s new section of seat.
     * (Precondition: seat has been created).
     */          
    public void setSeatSection(String s) {
        section = s;
    }

    /**
     * Returns section of seat.
     * @return section of seat
     * (Precondition: seat has a row)
     */        
    public String getSeatSection() {
        return section;
    }

    /**
     * Changes vacancy status of seat.
     * (Postcondition: vacancy = status)
     * @param status new vacancy status of seat.
     * (Precondition: seat has vacancy boolean)
     */                  
    public void setVacancy(boolean status) {
        vacancy = status;
    }

    /**
     * Returns vacancy status of seat.
     * @return vacancy status of seat
     * (Precondition: seat has vacancy boolean)
     */      
    public boolean getVacancy() {
        return vacancy;
    }    
    
    /**
     * Assigns passenger to seat.
     * (Postcondition: passenger = p)
     * @param p new passenger
     * (Precondition: seat and passenger exists.)
     */
    public void assignPassenger(Passenger p) {
        passenger = p;
    }
    
    /**
     * Returns passenger in seat.
     * @return passenger in seat
     * (Precondition: passenger exists)
     */
    public Passenger getPassenger() {
        return passenger;
    }
    
}
