 
/**
 * Attributes of a passenger in a seat of an airplane.
 * 
 * @author (Jennifer and Jason) 
 * @version (11/13/16)
 */
public class Passenger
{
    private String firstName, lastName; //first name and last name of Passenger
    
    /**
     * Creates passenger object with first name and last name.
     * (Postcondition: passenger is created with first and last name.)
     * @param first first name of passenger
     * @param last last name of passenger
     * (Precondition: passenger has first and last name.)
     */
    public Passenger(String first, String last) {
        firstName = first;
        lastName = last;
    }
    
    /**
     * Returns full name of passenger.
     * @return returns full name of passenger.
     * (Precondition: passenger has first and last name.)
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    /**
     * Returns first name of passenger.
     * @return first name of passenger
     * (Precondition: passenger has first and last name.)
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Returns last name of passenger.
     * @return last name of passenger
     * (Precondition: passenger has first and last name.)
     */    
    public String getLastName() {
        return lastName;
    }
}
