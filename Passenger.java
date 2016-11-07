
/**
 * Passenger of Airplane.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Passenger
{
    private String firstName, lastName;
    private int preference; //0 for none, 1 for first class, 2 for window
    private int seatRow, seatColumn;
    
    public Passenger(String first, String last, int sCol, int sRow) {
        firstName = first;
        lastName = last;
        seatRow = sRow;
        seatColumn = sCol;
        preference = 0;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getSeatRow() {
        return seatRow;
    }
    
    public int getSeatColumn() {
        return seatColumn;
    }
    
    public int getPreference() {
        return preference;
    }
}
